/*
 * Copyright (C) 2024-2025 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#define LOG_TAG "android.hardware.biometrics.fingerprint-service.oplus"

#include <android-base/logging.h>
#include <android/binder_manager.h>
#include <android/binder_process.h>

#include "include/Fingerprint.h"

using aidl::android::hardware::biometrics::fingerprint::Fingerprint;

int main() {
    ABinderProcess_setThreadPoolMaxThreadCount(0);

    std::shared_ptr<Fingerprint> fingerprint = ndk::SharedRefBase::make<Fingerprint>();

    const std::string instance = std::string() + Fingerprint::descriptor + "/default";
    binder_status_t status = AServiceManager_addService(fingerprint->asBinder().get(), instance.c_str());

    if (status != STATUS_OK) {
        LOG(ERROR) << "Failed to register fingerprint AIDL service";
        return 1;
    }

    LOG(INFO) << "AIDL fingerprint service started";
    ABinderProcess_joinThreadPool();
    return 0;
}