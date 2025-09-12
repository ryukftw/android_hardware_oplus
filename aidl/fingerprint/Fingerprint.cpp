/*
 * Copyright (C) 2024-2025 The LineageOS Project
 *
 * SPDX-License-Identifier: Apache-2.0
 */

#include "include/Fingerprint.h"

#include <android-base/file.h>
#include <android-base/logging.h>
#include <android-base/properties.h>
#include <android-base/stringprintf.h>
#include <android/binder_manager.h>
#include <android/binder_process.h>

#include "include/Session.h"

namespace aidl::android::hardware::biometrics::fingerprint {
namespace {
constexpr int SENSOR_ID = 0;
constexpr common::SensorStrength SENSOR_STRENGTH = common::SensorStrength::STRONG;
constexpr int MAX_ENROLLMENTS_PER_USER = 5;
constexpr bool SUPPORTS_NAVIGATION_GESTURES = false;
constexpr char HW_COMPONENT_ID[] = "fingerprintSensor";
constexpr char HW_VERSION[] = "oplus/1.0";
constexpr char FW_VERSION[] = "1.01";
constexpr char SERIAL_NUMBER[] = "00000001";
constexpr char SW_COMPONENT_ID[] = "matchingAlgorithm";
constexpr char SW_VERSION[] = "oplus/1.0";
}  // namespace

Fingerprint::Fingerprint() {
    // Detect sensor type
    std::string sensorType = ::android::base::GetProperty("persist.vendor.fingerprint.sensor_type", "");
    if (sensorType == "optical") {
        mSensorType = FingerprintSensorType::UNDER_DISPLAY_OPTICAL;
    } else if (sensorType == "ultrasonic") {
        mSensorType = FingerprintSensorType::UNDER_DISPLAY_ULTRASONIC;
    } else {
        mSensorType = FingerprintSensorType::REAR;
    }
    
    // Connect to vendor HAL
    mOplusBiometricsFingerprint = IOplusBiometricsFingerprint::getService();
    if (mOplusBiometricsFingerprint == nullptr) {
        LOG(ERROR) << "Failed to connect to oplus fingerprint HAL";
    }
}

ndk::ScopedAStatus Fingerprint::getSensorProps(std::vector<SensorProps>* out) {
    std::vector<SensorProps> props;
    
    SensorProps prop;
    prop.commonProps.sensorId = SENSOR_ID;
    prop.commonProps.sensorStrength = SENSOR_STRENGTH;
    prop.commonProps.maxEnrollmentsPerUser = MAX_ENROLLMENTS_PER_USER;
    
    // Component info
    common::ComponentInfo hwInfo;
    hwInfo.componentId = HW_COMPONENT_ID;
    hwInfo.hardwareVersion = HW_VERSION;
    hwInfo.firmwareVersion = FW_VERSION;
    hwInfo.serialNumber = SERIAL_NUMBER;
    hwInfo.softwareVersion = "";
    prop.commonProps.componentInfo.push_back(hwInfo);

    common::ComponentInfo swInfo;
    swInfo.componentId = SW_COMPONENT_ID;
    swInfo.hardwareVersion = "";
    swInfo.firmwareVersion = "";
    swInfo.serialNumber = "";
    swInfo.softwareVersion = SW_VERSION;
    prop.commonProps.componentInfo.push_back(swInfo);

    prop.sensorType = mSensorType;
    prop.halControlsIllumination = (mSensorType == FingerprintSensorType::UNDER_DISPLAY_OPTICAL);
    
    if (mSensorType == FingerprintSensorType::UNDER_DISPLAY_OPTICAL ||
        mSensorType == FingerprintSensorType::UNDER_DISPLAY_ULTRASONIC) {
        // Set sensor location for UDFPS
        SensorLocation location;
        location.sensorLocationX = ::android::base::GetIntProperty("persist.vendor.fingerprint.sensor_x", 540);
        location.sensorLocationY = ::android::base::GetIntProperty("persist.vendor.fingerprint.sensor_y", 2100);
        location.sensorRadius = ::android::base::GetIntProperty("persist.vendor.fingerprint.sensor_radius", 100);
        prop.sensorLocations.push_back(location);
    }
    
    props.push_back(prop);
    *out = std::move(props);
    
    return ndk::ScopedAStatus::ok();
}

ndk::ScopedAStatus Fingerprint::createSession(int32_t sensorId, int32_t userId,
                                              const std::shared_ptr<ISessionCallback>& cb,
                                              std::shared_ptr<ISession>* out) {
    if (mOplusBiometricsFingerprint == nullptr) {
        LOG(ERROR) << "Oplus biometrics fingerprint service is null";
        return ndk::ScopedAStatus::fromServiceSpecificError(
                static_cast<int32_t>(Error::HW_UNAVAILABLE));
    }

    if (mSession != nullptr && !mSession->isClosed()) {
        LOG(ERROR) << "Session already exists";
        return ndk::ScopedAStatus::fromServiceSpecificError(
                static_cast<int32_t>(Error::UNABLE_TO_PROCESS));
    }

    mSession = ndk::SharedRefBase::make<Session>(sensorId, userId, cb, 
                                                 mOplusBiometricsFingerprint.get(), 
                                                 mLockoutTracker);
    *out = mSession;
    
    return ndk::ScopedAStatus::ok();
}

const char* Fingerprint::type2String(FingerprintSensorType type) {
    switch (type) {
        case FingerprintSensorType::REAR:
            return "REAR";
        case FingerprintSensorType::UNDER_DISPLAY_ULTRASONIC:
            return "UNDER_DISPLAY_ULTRASONIC";
        case FingerprintSensorType::UNDER_DISPLAY_OPTICAL:
            return "UNDER_DISPLAY_OPTICAL";
        case FingerprintSensorType::POWER_BUTTON:
            return "POWER_BUTTON";
        case FingerprintSensorType::HOME_BUTTON:
            return "HOME_BUTTON";
        default:
            return "UNKNOWN";
    }
}

binder_status_t Fingerprint::dump(int fd, const char** /*args*/, uint32_t /*numArgs*/) {
    dprintf(fd, "Fingerprint HAL:\n");
    dprintf(fd, "  Sensor type: %s\n", type2String(mSensorType));
    dprintf(fd, "  HAL connected: %s\n", connected() ? "true" : "false");
    dprintf(fd, "  Active session: %s\n", (mSession != nullptr && !mSession->isClosed()) ? "true" : "false");
    return STATUS_OK;
}

}  // namespace aidl::android::hardware::biometrics::fingerprint