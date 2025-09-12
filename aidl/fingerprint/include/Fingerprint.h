/*
 * Copyright (C) 2024-2025 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#pragma once

#include <aidl/android/hardware/biometrics/fingerprint/BnFingerprint.h>
#include <android/hardware/biometrics/fingerprint/2.1/types.h>
#include <android/hardware/biometrics/fingerprint/2.2/IBiometricsFingerprintClientCallback.h>
#include <android/hardware/biometrics/fingerprint/2.3/IBiometricsFingerprint.h>
#include <hidl/MQDescriptor.h>
#include <hidl/Status.h>
#include <vendor/oplus/hardware/biometrics/fingerprint/2.1/IBiometricsFingerprint.h>

#include "LockoutTracker.h"
#include "Session.h"

namespace aidl::android::hardware::biometrics::fingerprint {

using ::android::sp;
using ::android::hardware::biometrics::fingerprint::V2_1::FingerprintError;
using ::android::hardware::biometrics::fingerprint::V2_1::RequestStatus;
using ::android::hardware::biometrics::fingerprint::V2_2::FingerprintAcquiredInfo;
using ::android::hardware::biometrics::fingerprint::V2_2::IBiometricsFingerprintClientCallback;
using ::android::hardware::biometrics::fingerprint::V2_3::IBiometricsFingerprint;
using IOplusBiometricsFingerprint =
    ::vendor::oplus::hardware::biometrics::fingerprint::V2_1::IBiometricsFingerprint;

class Fingerprint : public BnFingerprint {
  public:
    Fingerprint();

    ndk::ScopedAStatus getSensorProps(std::vector<SensorProps>* out) override;

    ndk::ScopedAStatus createSession(int32_t sensorId, int32_t userId,
                                     const std::shared_ptr<ISessionCallback>& cb,
                                     std::shared_ptr<ISession>* out) override;
    
    bool connected() { return mOplusBiometricsFingerprint != nullptr; }

    static const char* type2String(FingerprintSensorType type);

    binder_status_t dump(int fd, const char** /*args*/, uint32_t numArgs);

  private:
    LockoutTracker mLockoutTracker;
    std::shared_ptr<Session> mSession;
    FingerprintSensorType mSensorType;
    sp<IOplusBiometricsFingerprint> mOplusBiometricsFingerprint;
};

}  // namespace aidl::android::hardware::biometrics::fingerprint