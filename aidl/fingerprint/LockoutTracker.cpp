/*
 * Copyright (C) 2024-2025 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#include "include/LockoutTracker.h"

namespace aidl {
namespace android {
namespace hardware {
namespace biometrics {
namespace fingerprint {

void LockoutTracker::reset(bool clearAttemptCounter) {
    if (clearAttemptCounter) {
        mFailedAttempts = 0;
    }
    mLockoutTimeLeft = 0;
}

void LockoutTracker::addFailedAttempt() {
    mFailedAttempts++;
    if (mFailedAttempts >= kFailedAttemptsTillLockoutTimed) {
        mLockoutTime = std::chrono::steady_clock::now();
        mLockoutTimeLeft = kLockoutTimedDuration;
    }
}

int64_t LockoutTracker::getLockoutTimeLeft() {
    if (mLockoutTimeLeft > 0) {
        auto now = std::chrono::steady_clock::now();
        auto elapsed = std::chrono::duration_cast<std::chrono::milliseconds>(now - mLockoutTime);
        mLockoutTimeLeft = std::max(int64_t(0), mLockoutTimeLeft - elapsed.count());
        mLockoutTime = now;
    }
    return mLockoutTimeLeft;
}

int64_t LockoutTracker::getTimeoutForFailedAttempts(int32_t attempts) {
    if (attempts >= kFailedAttemptsTillLockoutPermanent) {
        return 0; // Permanent lockout
    } else if (attempts >= kFailedAttemptsTillLockoutTimed) {
        return kLockoutTimedDuration;
    }
    return 0;
}

}  // namespace fingerprint
}  // namespace biometrics
}  // namespace hardware
}  // namespace android
}  // namespace aidl