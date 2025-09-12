/*
 * Copyright (C) 2024-2025 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#include "include/CancellationSignal.h"
#include "include/Session.h"

namespace aidl {
namespace android {
namespace hardware {
namespace biometrics {
namespace fingerprint {

CancellationSignal::CancellationSignal(Session* session) : mSession(session) {}

ndk::ScopedAStatus CancellationSignal::cancel() {
    mSession->cancel();
    return ndk::ScopedAStatus::ok();
}

}  // namespace fingerprint
}  // namespace biometrics
}  // namespace hardware
}  // namespace android
}  // namespace aidl