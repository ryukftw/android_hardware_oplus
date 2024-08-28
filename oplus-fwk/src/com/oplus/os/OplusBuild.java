package com.oplus.os;

import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;

public class OplusBuild {
    public static final int OplusOS_11_0 = 19;
    public static final int OplusOS_11_1 = 20;
    public static final int OplusOS_11_2 = 21;
    public static final int OplusOS_11_3 = 22;
    public static final int OplusOS_12_0 = 23;
    public static final int OplusOS_12_1 = 24;
    public static final int OplusOS_12_2 = 25;
    public static final int OplusOS_1_0 = 1;
    public static final int OplusOS_1_2 = 2;
    public static final int OplusOS_1_4 = 3;
    public static final int OplusOS_2_0 = 4;
    public static final int OplusOS_2_1 = 5;
    public static final int OplusOS_3_0 = 6;
    public static final int OplusOS_3_1 = 7;
    public static final int OplusOS_3_2 = 8;
    public static final int OplusOS_5_0 = 9;
    public static final int OplusOS_5_1 = 10;
    public static final int OplusOS_5_2 = 11;
    public static final int OplusOS_6_0 = 12;
    public static final int OplusOS_6_1 = 13;
    public static final int OplusOS_6_2 = 14;
    public static final int OplusOS_6_7 = 15;
    public static final int OplusOS_7_0 = 16;
    public static final int OplusOS_7_1 = 17;
    public static final int OplusOS_7_2 = 18;
    public static final int UNKNOWN = 0;
    private static final String[] VERSIONS = {"V1.0", "V1.2", "V1.4", "V2.0", "V2.1", "V3.0", "V3.1", "V3.2", "V5.0", "V5.1", "V5.2", "V6.0", "V6.1", "V6.2", "V6.7", "V7", "V7.1", "V7.2", "V11", "V11.1", "V11.2", "V11.3", "V12", "V12.1", "V12.2", null};

    public static class VERSION {
        public static final String RELEASE = "V12.1";
        public static final int SDK_VERSION = getOplusOSVERSION();
        public static final int SDK_SUB_VERSION = 19;
    }

    public static int getOplusOSVERSION() {
        for (int i = VERSIONS.length - 2; i >= 0; i--) {
            if (!TextUtils.isEmpty(VERSION.RELEASE) && VERSION.RELEASE.startsWith(VERSIONS[i])) {
                return i + 1;
            }
        }
        return 23;
    }

    public static boolean setDeviceName(String name) {
        return true;
    }

    public static String getDeviceName() {
        return null;
    }

    public static String getDeviceName(Context context) {
        String name = Settings.Global.getString(context.getContentResolver(), Settings.Global.DEVICE_NAME);
        if (name != null && name.length() != 0 && !name.trim().isEmpty()) {
            return name;
        }
        return Build.MODEL;
    }

    public static void putDeviceName(Context context, String deviceName) {
        if (deviceName != null) {
            Settings.Global.putString(context.getContentResolver(), Settings.Global.DEVICE_NAME, deviceName);
        }
    }

    public static void setDeviceName(Context context, String deviceName) {
        
    }

    private static String getString(String property) {
        return SystemProperties.get(property, "unknown");
    }

    public static String getVersionProp(String property) {
        return "V12.1";
    }
}
