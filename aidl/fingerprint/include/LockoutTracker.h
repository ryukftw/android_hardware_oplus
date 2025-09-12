/*
 * Copyright (C) 2024-2025 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#pragma once

#include <chrono>

namespace aidl {
namespace android {
namespace hardware {
namespace biometrics {
namespace fingerprint {

class LockoutTracker {
public:
    LockoutTracker() : mFailedAttempts(0), mLockoutTimeLeft(0) {}

    void reset(bool clearAttemptCounter = false);
    void addFailedAttempt();
    int64_t getLockoutTimeLeft();
    int64_t getTimeoutForFailedAttempts(int32_t attempts);

private:
    int32_t mFailedAttempts;
    int64_t mLockoutTimeLeft;
    std::chrono::steady_clock::time_point mLockoutTime;

    static const int32_t kFailedAttemptsTillLockoutTimed = 5;
    static const int32_t kFailedAttemptsTillLockoutPermanent = 20;
    static const int32_t kLockoutTimedDuration = 30 * 1000; // 30 seconds
};

}  // namespace fingerprint
}  // namespace biometrics
}  // namespace hardware
}  // namespace android
}  // namespace aidl