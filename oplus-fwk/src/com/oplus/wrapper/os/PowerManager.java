package com.oplus.wrapper.os;

/* loaded from: classes.dex */
public class PowerManager {
    public static final int USER_ACTIVITY_EVENT_OTHER = getUserActivityEventOther();
    public static final int WAKE_REASON_APPLICATION = getWakeReasonApplication();
    private final android.os.PowerManager mPowerManager;

    public PowerManager(android.os.PowerManager powerManager) {
        this.mPowerManager = powerManager;
    }

    private static int getUserActivityEventOther() {
        return 0;
    }

    private static int getWakeReasonApplication() {
        return 2;
    }

    public int getMaximumScreenBrightnessSetting() {
        return this.mPowerManager.getMaximumScreenBrightnessSetting();
    }

    public int getMinimumScreenBrightnessSetting() {
        return this.mPowerManager.getMinimumScreenBrightnessSetting();
    }

    public void wakeUp(long time, String details) {
        this.mPowerManager.wakeUp(time, details);
    }

    public void wakeUp(long time, int reason, String details) {
        this.mPowerManager.wakeUp(time, reason, details);
    }

    public int getDefaultScreenBrightnessSetting() {
        return this.mPowerManager.getDefaultScreenBrightnessSetting();
    }

    public PowerSaveState getPowerSaveState(int serviceType) {
        android.os.PowerSaveState powerSaveState = this.mPowerManager.getPowerSaveState(serviceType);
        if (powerSaveState == null) {
            return null;
        }
        return new PowerSaveState(powerSaveState);
    }

    public int getLastSleepReason() {
        return this.mPowerManager.getLastSleepReason();
    }

    public void shutdown(boolean confirm, String reason, boolean wait) {
        this.mPowerManager.shutdown(confirm, reason, wait);
    }

    public void reboot(String reason) {
        this.mPowerManager.reboot(reason);
    }

    public void goToSleep(long time) {
        this.mPowerManager.goToSleep(time);
    }

    public void userActivity(long when, int event, int flags) {
        this.mPowerManager.userActivity(when, event, flags);
    }

    public boolean setPowerSaveModeEnabled(boolean mode) {
        return this.mPowerManager.setPowerSaveModeEnabled(mode);
    }
}
