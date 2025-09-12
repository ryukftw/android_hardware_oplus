/*
 * Copyright (C) 2024-2025 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#pragma once

#include <aidl/android/hardware/biometrics/common/BnCancellationSignal.h>

namespace aidl {
namespace android {
namespace hardware {
namespace biometrics {
namespace fingerprint {

class Session;

class CancellationSignal
    : public aidl::android::hardware::biometrics::common::BnCancellationSignal {
  public:
    explicit CancellationSignal(Session* session);

    ndk::ScopedAStatus cancel() override;

  private:
    Session* mSession;
};

}  // namespace fingerprint
}  // namespace biometrics
}  // namespace hardware
}  // namespace android
}  // namespace aidl