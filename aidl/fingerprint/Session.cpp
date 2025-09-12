/*
 * Copyright (C) 2024-2025 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#include "include/Session.h"

#include <android-base/logging.h>
#include <endian.h>

#include "include/CancellationSignal.h"
#include "include/Legacy2Aidl.h"

namespace aidl::android::hardware::biometrics::fingerprint {

void onClientDeath(void* cookie) {
    LOG(INFO) << "Client died, closing session";
    if (cookie) {
        Session* session = static_cast<Session*>(cookie);
        session->close();
    }
}

Session::Session(int sensorId, int userId, std::shared_ptr<ISessionCallback> cb,
                 IOplusBiometricsFingerprint* oplusFp, LockoutTracker lockoutTracker)
    : mSensorId(sensorId), 
      mUserId(userId), 
      mCb(cb), 
      mOplusFp(oplusFp),
      mScheduledState(SessionState::IDLING),
      mCurrentState(SessionState::IDLING),
      mLockoutTracker(lockoutTracker) {
    
    mOplusFpCallback = new FingerprintCallback(cb, this, mLockoutTracker);
    if (mOplusFp) {
        mOplusFp->setHalCallback(mOplusFpCallback.get());
        mOplusFp->setActiveGroup(mUserId, "");
    }

    mDeathRecipient = AIBinder_DeathRecipient_new(onClientDeath);
}

ndk::ScopedAStatus Session::generateChallenge() {
    scheduleStateOrCrash(SessionState::GENERATING_CHALLENGE);
    
    if (!mOplusFp) {
        mCb->onError(Error::HW_UNAVAILABLE, 0);
        return ndk::ScopedAStatus::ok();
    }
    
    enterStateOrCrash(SessionState::GENERATING_CHALLENGE);
    
    uint64_t challenge = mOplusFp->preEnroll();
    mCb->onChallengeGenerated(challenge);
    
    enterIdling();
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::revokeChallenge(int64_t challenge) {
    scheduleStateOrCrash(SessionState::REVOKING_CHALLENGE);
    
    if (!mOplusFp) {
        mCb->onError(Error::HW_UNAVAILABLE, 0);
        return ndk::ScopedAStatus::ok();
    }
    
    enterStateOrCrash(SessionState::REVOKING_CHALLENGE);
    
    mOplusFp->postEnroll();
    mCb->onChallengeRevoked(challenge);
    
    enterIdling();
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::enroll(const keymaster::HardwareAuthToken& hat,
                                   std::shared_ptr<common::ICancellationSignal>* out) {
    scheduleStateOrCrash(SessionState::ENROLLING);
    
    if (!mOplusFp) {
        mCb->onError(Error::HW_UNAVAILABLE, 0);
        return ndk::ScopedAStatus::ok();
    }
    
    *out = ndk::SharedRefBase::make<CancellationSignal>(this);
    
    enterStateOrCrash(SessionState::ENROLLING);
    
    // Enable HBM for UDFPS
    setDimlayerHbm(1);
    
    // Convert AIDL HAT to legacy format
    hw_auth_token_t legacyHat;
    translate(hat, legacyHat);
    
    hidl_array<uint8_t, 69> hidlHat;
    translate(legacyHat, hidlHat);
    
    RequestStatus status = mOplusFp->enroll(hidlHat, mUserId, 30);
    if (status != RequestStatus::SYS_OK) {
        setDimlayerHbm(0);
        mCb->onError(Error::UNABLE_TO_PROCESS, 0);
        enterIdling();
    }
    
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::authenticate(int64_t operationId,
                                        std::shared_ptr<common::ICancellationSignal>* out) {
    scheduleStateOrCrash(SessionState::AUTHENTICATING);
    
    if (checkSensorLockout()) {
        return ndk::ScopedAStatus::ok();
    }
    
    if (!mOplusFp) {
        mCb->onError(Error::HW_UNAVAILABLE, 0);
        return ndk::ScopedAStatus::ok();
    }
    
    *out = ndk::SharedRefBase::make<CancellationSignal>(this);
    
    enterStateOrCrash(SessionState::AUTHENTICATING);
    
    // Enable HBM for UDFPS
    setDimlayerHbm(1);
    
    RequestStatus status = mOplusFp->authenticate(operationId, mUserId);
    if (status != RequestStatus::SYS_OK) {
        setDimlayerHbm(0);
        mCb->onError(Error::UNABLE_TO_PROCESS, 0);
        enterIdling();
    }
    
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::detectInteraction(std::shared_ptr<common::ICancellationSignal>* out) {
    // Not implemented in oplus HAL
    mCb->onError(Error::UNABLE_TO_PROCESS, 0);
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::enumerateEnrollments() {
    scheduleStateOrCrash(SessionState::ENUMERATING_ENROLLMENTS);
    
    if (!mOplusFp) {
        mCb->onError(Error::HW_UNAVAILABLE, 0);
        return ndk::ScopedAStatus::ok();
    }
    
    enterStateOrCrash(SessionState::ENUMERATING_ENROLLMENTS);
    
    RequestStatus status = mOplusFp->enumerate();
    if (status != RequestStatus::SYS_OK) {
        mCb->onError(Error::UNABLE_TO_PROCESS, 0);
        enterIdling();
    }
    
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::removeEnrollments(const std::vector<int32_t>& enrollmentIds) {
    scheduleStateOrCrash(SessionState::REMOVING_ENROLLMENTS);
    
    if (!mOplusFp) {
        mCb->onError(Error::HW_UNAVAILABLE, 0);
        return ndk::ScopedAStatus::ok();
    }
    
    enterStateOrCrash(SessionState::REMOVING_ENROLLMENTS);
    
    for (int32_t enrollmentId : enrollmentIds) {
        RequestStatus status = mOplusFp->remove(mUserId, enrollmentId);
        if (status != RequestStatus::SYS_OK) {
            mCb->onError(Error::UNABLE_TO_PROCESS, 0);
            enterIdling();
            return ndk::ScopedAStatus::ok();
        }
    }
    
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::getAuthenticatorId() {
    scheduleStateOrCrash(SessionState::GETTING_AUTHENTICATOR_ID);
    
    if (!mOplusFp) {
        mCb->onError(Error::HW_UNAVAILABLE, 0);
        return ndk::ScopedAStatus::ok();
    }
    
    enterStateOrCrash(SessionState::GETTING_AUTHENTICATOR_ID);
    
    uint64_t authenticatorId = mOplusFp->getAuthenticatorId();
    mCb->onAuthenticatorIdRetrieved(authenticatorId);
    
    enterIdling();
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::invalidateAuthenticatorId() {
    mCb->onError(Error::UNABLE_TO_PROCESS, 0);
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::resetLockout(const keymaster::HardwareAuthToken& hat) {
    clearLockout(true);
    mCb->onLockoutCleared();
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::close() {
    if (mOplusFp) {
        mOplusFp->cancel();
    }
    setDimlayerHbm(0);
    setFpPress(0);
    mCurrentState = SessionState::CLOSED;
    mCb->onSessionClosed();
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::onPointerDown(int32_t pointerId, int32_t x, int32_t y, 
                                          float minor, float major) {
    setFpPress(1);
    if (!isUff() && mOplusFp) {
        mOplusFp->onFingerDown(x, y, minor, major);
    }
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::onPointerUp(int32_t pointerId) {
    setFpPress(0);
    if (!isUff() && mOplusFp) {
        mOplusFp->onFingerUp();
    }
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::onUiReady() {
    return ndk::ScopedAStatus::ok();
}

// Context-based methods just delegate to regular methods
ndk::ScopedAStatus Session::authenticateWithContext(
        int64_t operationId, const common::OperationContext& context,
        std::shared_ptr<common::ICancellationSignal>* out) {
    return authenticate(operationId, out);
}

ndk::ScopedAStatus Session::enrollWithContext(
        const keymaster::HardwareAuthToken& hat, const common::OperationContext& context,
        std::shared_ptr<common::ICancellationSignal>* out) {
    return enroll(hat, out);
}

ndk::ScopedAStatus Session::detectInteractionWithContext(
        const common::OperationContext& context,
        std::shared_ptr<common::ICancellationSignal>* out) {
    return detectInteraction(out);
}

ndk::ScopedAStatus Session::onPointerDownWithContext(const PointerContext& context) {
    return onPointerDown(context.pointerId, context.x, context.y, context.minor, context.major);
}

ndk::ScopedAStatus Session::onPointerUpWithContext(const PointerContext& context) {
    return onPointerUp(context.pointerId);
}

ndk::ScopedAStatus Session::onContextChanged(const common::OperationContext& context) {
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::onPointerCancelWithContext(const PointerContext& context) {
    return onPointerUp(context.pointerId);
}

ndk::ScopedAStatus Session::setIgnoreDisplayTouches(bool shouldIgnore) {
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Session::cancel() {
    if (mOplusFp) {
        mOplusFp->cancel();
    }
    setDimlayerHbm(0);
    setFpPress(0);
    enterIdling();
    return ndk::ScopedAStatus::ok();
}

binder_status_t Session::linkToDeath(AIBinder* binder) {
    return AIBinder_linkToDeath(binder, mDeathRecipient, this);
}

bool Session::isClosed() {
    return mCurrentState == SessionState::CLOSED;
}

void Session::scheduleStateOrCrash(SessionState state) {
    if (mCurrentState != SessionState::IDLING) {
        LOG(FATAL) << "Cannot schedule state " << static_cast<int>(state) 
                   << " from state " << static_cast<int>(mCurrentState);
    }
    mScheduledState = state;
}

void Session::enterStateOrCrash(SessionState state) {
    if (mScheduledState != state) {
        LOG(FATAL) << "Expected state " << static_cast<int>(mScheduledState)
                   << " but got " << static_cast<int>(state);
    }
    mCurrentState = state;
    mScheduledState = SessionState::IDLING;
    mCb->onStateChanged(static_cast<common::SessionState>(state));
}

void Session::enterIdling() {
    mCurrentState = SessionState::IDLING;
    mCb->onStateChanged(common::SessionState::IDLING);
}

bool Session::checkSensorLockout() {
    int64_t lockoutTime = mLockoutTracker.getLockoutTimeLeft();
    if (lockoutTime > 0) {
        mCb->onLockoutTimed(lockoutTime);
        return true;
    }
    return false;
}

void Session::clearLockout(bool clearAttemptCounter) {
    mLockoutTracker.reset(clearAttemptCounter);
}

void Session::startLockoutTimer(int64_t timeout) {
    // Lockout timer implementation would go here
}

void Session::lockoutTimerExpired() {
    // Implementation for lockout timer expiry
}

// FingerprintCallback implementation
Return<void> FingerprintCallback::onEnrollResult(uint64_t deviceId, uint32_t fingerId, 
                                                  uint32_t groupId, uint32_t remaining) {
    mCb->onEnrollmentProgress(fingerId, remaining);
    if (remaining == 0) {
        setDimlayerHbm(0);
        mSession->enterIdling();
    }
    return Void();
}

Return<void> FingerprintCallback::onAcquired(uint64_t deviceId, 
                                             V2_1::FingerprintAcquiredInfo acquiredInfo,
                                             int32_t vendorCode) {
    AcquiredInfo aidlAcquiredInfo = static_cast<AcquiredInfo>(acquiredInfo);
    mCb->onAcquired(aidlAcquiredInfo, vendorCode);
    return Void();
}

Return<void> FingerprintCallback::onAuthenticated(uint64_t deviceId, uint32_t fingerId,
                                                  uint32_t groupId, const hidl_vec<uint8_t>& token) {
    if (fingerId != 0) {
        setDimlayerHbm(0);
        std::vector<uint8_t> aidlToken(token.begin(), token.end());
        mCb->onAuthenticationSucceeded(fingerId, aidlToken);
        mLockoutTracker.reset(true);
    } else {
        mCb->onAuthenticationFailed();
        mLockoutTracker.addFailedAttempt();
        
        int64_t lockoutTime = mLockoutTracker.getLockoutTimeLeft();
        if (lockoutTime > 0) {
            mCb->onLockoutTimed(lockoutTime);
        }
    }
    setFpPress(0);
    mSession->enterIdling();
    return Void();
}

Return<void> FingerprintCallback::onError(uint64_t deviceId, FingerprintError error, 
                                          int32_t vendorCode) {
    setDimlayerHbm(0);
    setFpPress(0);
    Error aidlError = static_cast<Error>(error);
    mCb->onError(aidlError, vendorCode);
    mSession->enterIdling();
    return Void();
}

Return<void> FingerprintCallback::onRemoved(uint64_t deviceId, uint32_t fingerId, 
                                            uint32_t groupId, uint32_t remaining) {
    std::vector<int32_t> enrollmentIds = {static_cast<int32_t>(fingerId)};
    mCb->onEnrollmentsRemoved(enrollmentIds);
    if (remaining == 0) {
        mSession->enterIdling();
    }
    return Void();
}

Return<void> FingerprintCallback::onEnumerate(uint64_t deviceId, uint32_t fingerId, 
                                              uint32_t groupId, uint32_t remaining) {
    if (fingerId != 0) {
        std::vector<int32_t> enrollmentIds = {static_cast<int32_t>(fingerId)};
        mCb->onEnrollmentsEnumerated(enrollmentIds);
    }
    if (remaining == 0) {
        mSession->enterIdling();
    }
    return Void();
}

Return<void> FingerprintCallback::onAcquired_2_2(uint64_t deviceId, 
                                                  FingerprintAcquiredInfo acquiredInfo,
                                                  int32_t vendorCode) {
    AcquiredInfo aidlAcquiredInfo = static_cast<AcquiredInfo>(acquiredInfo);
    mCb->onAcquired(aidlAcquiredInfo, vendorCode);
    return Void();
}

Return<void> FingerprintCallback::onEngineeringInfoUpdated(uint32_t /*lenth*/, 
                                                           const hidl_vec<uint32_t>& /*keys*/,
                                                           const hidl_vec<hidl_string>& /*values*/) {
    return Void();
}

Return<void> FingerprintCallback::onFingerprintCmd(int32_t /*cmdId*/, 
                                                   const hidl_vec<int8_t>& /*result*/,
                                                   uint32_t /*resultLen*/) {
    return Void();
}

}  // namespace aidl::android::hardware::biometrics::fingerprint