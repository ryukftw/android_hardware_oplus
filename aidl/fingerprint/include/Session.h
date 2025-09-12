/*
 * Copyright (C) 2024-2025 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#pragma once

#include <aidl/android/hardware/biometrics/fingerprint/BnSession.h>
#include <aidl/android/hardware/biometrics/fingerprint/ISessionCallback.h>
#include <android-base/logging.h>
#include <android-base/properties.h>
#include <android/hardware/biometrics/fingerprint/2.1/types.h>
#include <android/hardware/biometrics/fingerprint/2.2/IBiometricsFingerprintClientCallback.h>
#include <android/hardware/biometrics/fingerprint/2.3/IBiometricsFingerprint.h>
#include <hidl/MQDescriptor.h>
#include <hidl/Status.h>
#include <vendor/oplus/hardware/biometrics/fingerprint/2.1/IBiometricsFingerprint.h>

#include <fstream>

#include "LockoutTracker.h"

#define FP_PRESS_PATH "/sys/kernel/oplus_display/notify_fppress"
#define DIMLAYER_PATH "/sys/kernel/oplus_display/dimlayer_hbm"

namespace aidl::android::hardware::biometrics::fingerprint {

namespace common = aidl::android::hardware::biometrics::common;
namespace keymaster = aidl::android::hardware::keymaster;

using ::android::sp;
using ::android::base::GetProperty;
using ::android::hardware::hidl_string;
using ::android::hardware::hidl_vec;
using ::android::hardware::Return;
using ::android::hardware::Void;
using ::android::hardware::biometrics::fingerprint::V2_1::FingerprintError;
using ::android::hardware::biometrics::fingerprint::V2_1::RequestStatus;
using ::android::hardware::biometrics::fingerprint::V2_2::FingerprintAcquiredInfo;
using ::android::hardware::biometrics::fingerprint::V2_2::IBiometricsFingerprintClientCallback;
using ::android::hardware::biometrics::fingerprint::V2_3::IBiometricsFingerprint;

using namespace ::android::hardware::biometrics::fingerprint;

using IOplusBiometricsFingerprint =
    ::vendor::oplus::hardware::biometrics::fingerprint::V2_1::IBiometricsFingerprint;
using ::vendor::oplus::hardware::biometrics::fingerprint::V2_1::
    IBiometricsFingerprintClientCallbackEx;

enum class SessionState {
    IDLING,
    CLOSED,
    GENERATING_CHALLENGE,
    REVOKING_CHALLENGE,
    ENROLLING,
    AUTHENTICATING,
    DETECTING_INTERACTION,
    ENUMERATING_ENROLLMENTS,
    REMOVING_ENROLLMENTS,
    GETTING_AUTHENTICATOR_ID,
    INVALIDATING_AUTHENTICATOR_ID,
    RESETTING_LOCKOUT,
};

namespace {
/*
 * Write value to path and close file.
 */
template <typename T>
void set(const std::string& path, const T& value) {
    std::ofstream file(path);
    file << value;
}

template <typename T>
T get(const std::string& path, const T& def) {
    std::ifstream file(path);
    T result;

    file >> result;
    return file.fail() ? def : result;
}

bool isUdfps() {
    return GetProperty("persist.vendor.fingerprint.sensor_type", "") == "optical";
}

bool isUff() {
    return GetProperty("persist.vendor.fingerprint.version", "").find("UFF ") == 0;
}

bool setDimlayerHbm(unsigned int value) {
    set(DIMLAYER_PATH, value);
    return isUdfps() && get(DIMLAYER_PATH, 0) == value;
}

bool setFpPress(unsigned int value) {
    set(FP_PRESS_PATH, value);
    return isUdfps();
}
}

void onClientDeath(void* cookie);

class FingerprintCallback;
class Session : public BnSession {
   public:
    Session(int sensorId, int userId, std::shared_ptr<ISessionCallback> cb,
            IOplusBiometricsFingerprint* oplusFp, LockoutTracker lockoutTracker);

    ndk::ScopedAStatus generateChallenge() override;
    ndk::ScopedAStatus revokeChallenge(int64_t challenge) override;
    ndk::ScopedAStatus enroll(const keymaster::HardwareAuthToken& hat,
                              std::shared_ptr<common::ICancellationSignal>* out) override;
    ndk::ScopedAStatus authenticate(int64_t operationId,
                                    std::shared_ptr<common::ICancellationSignal>* out) override;
    ndk::ScopedAStatus detectInteraction(
        std::shared_ptr<common::ICancellationSignal>* out) override;
    ndk::ScopedAStatus enumerateEnrollments() override;
    ndk::ScopedAStatus removeEnrollments(const std::vector<int32_t>& enrollmentIds) override;
    ndk::ScopedAStatus getAuthenticatorId() override;
    ndk::ScopedAStatus invalidateAuthenticatorId() override;
    ndk::ScopedAStatus resetLockout(const keymaster::HardwareAuthToken& hat) override;
    ndk::ScopedAStatus close() override;
    ndk::ScopedAStatus onPointerDown(int32_t pointerId, int32_t x, int32_t y, float minor,
                                     float major) override;
    ndk::ScopedAStatus onPointerUp(int32_t pointerId) override;
    ndk::ScopedAStatus onUiReady() override;
    ndk::ScopedAStatus authenticateWithContext(
        int64_t operationId, const common::OperationContext& context,
        std::shared_ptr<common::ICancellationSignal>* out) override;
    ndk::ScopedAStatus enrollWithContext(
        const keymaster::HardwareAuthToken& hat, const common::OperationContext& context,
        std::shared_ptr<common::ICancellationSignal>* out) override;
    ndk::ScopedAStatus detectInteractionWithContext(
        const common::OperationContext& context,
        std::shared_ptr<common::ICancellationSignal>* out) override;
    ndk::ScopedAStatus onPointerDownWithContext(const PointerContext& context) override;
    ndk::ScopedAStatus onPointerUpWithContext(const PointerContext& context) override;
    ndk::ScopedAStatus onContextChanged(const common::OperationContext& context) override;
    ndk::ScopedAStatus onPointerCancelWithContext(const PointerContext& context) override;
    ndk::ScopedAStatus setIgnoreDisplayTouches(bool shouldIgnore) override;

    ndk::ScopedAStatus cancel();
    binder_status_t linkToDeath(AIBinder* binder);
    bool isClosed();

   private:
    friend FingerprintCallback;
    
    void scheduleStateOrCrash(SessionState state);
    void enterStateOrCrash(SessionState state);
    void enterIdling();
    bool checkSensorLockout();
    void clearLockout(bool clearAttemptCounter);
    void startLockoutTimer(int64_t timeout);
    void lockoutTimerExpired();

    // lockout timer
    bool mIsLockoutTimerStarted = false;
    bool mIsLockoutTimerAborted = false;

    // The sensor and user IDs for which this session was created.
    int32_t mSensorId;
    int32_t mUserId;

    std::shared_ptr<ISessionCallback> mCb;
    IOplusBiometricsFingerprint* mOplusFp;
    sp<FingerprintCallback> mOplusFpCallback;

    // Simple representation of the session's state machine.
    std::atomic<SessionState> mScheduledState;
    std::atomic<SessionState> mCurrentState;

    // Binder death handler.
    AIBinder_DeathRecipient* mDeathRecipient;

    LockoutTracker mLockoutTracker;
    sp<IOplusBiometricsFingerprint> mOplusBiometricsFingerprint;
    sp<V2_1::IBiometricsFingerprintClientCallback> mClientCallback;
};

class FingerprintCallback : public IBiometricsFingerprintClientCallback,
                            public IBiometricsFingerprintClientCallbackEx {
   public:
    FingerprintCallback(std::shared_ptr<ISessionCallback> cb, Session* session, 
                        LockoutTracker& tracker)
        : mCb(cb), mLockoutTracker(tracker), mSession(session) {}

    // HIDL callback methods
    Return<void> onEnrollResult(uint64_t deviceId, uint32_t fingerId, uint32_t groupId,
                                uint32_t remaining) override;
    Return<void> onAcquired(uint64_t deviceId, V2_1::FingerprintAcquiredInfo acquiredInfo,
                            int32_t vendorCode) override;
    Return<void> onAuthenticated(uint64_t deviceId, uint32_t fingerId, uint32_t groupId,
                                 const hidl_vec<uint8_t>& token) override;
    Return<void> onError(uint64_t deviceId, FingerprintError error, int32_t vendorCode) override;
    Return<void> onRemoved(uint64_t deviceId, uint32_t fingerId, uint32_t groupId,
                           uint32_t remaining) override;
    Return<void> onEnumerate(uint64_t deviceId, uint32_t fingerId, uint32_t groupId,
                             uint32_t remaining) override;
    Return<void> onAcquired_2_2(uint64_t deviceId, FingerprintAcquiredInfo acquiredInfo,
                                int32_t vendorCode) override;

    // Oplus extension callbacks
    Return<void> onEngineeringInfoUpdated(uint32_t lenth, const hidl_vec<uint32_t>& keys,
                                          const hidl_vec<hidl_string>& values) override;
    Return<void> onFingerprintCmd(int32_t cmdId, const hidl_vec<int8_t>& result,
                                  uint32_t resultLen) override;

   private:
    std::shared_ptr<ISessionCallback> mCb;
    LockoutTracker& mLockoutTracker;
    Session* mSession;
};

}  // namespace aidl::android::hardware::biometrics::fingerprint