package com.oplus.app;

import android.os.UserHandle;

public class OPlusAccessControlManager {
    private static volatile OPlusAccessControlManager sInstance = null;
    public static final int USER_CURRENT = UserHandle.myUserId();

    private OPlusAccessControlManager() {
    }

    public static OPlusAccessControlManager getInstance() {
        if (sInstance == null) {
            synchronized (OPlusAccessControlManager.class) {
                if (sInstance == null) {
                    sInstance = new OPlusAccessControlManager();
                }
            }
        }
        return sInstance;
    }

    public boolean isEncryptPass(String packageName, int userId) {
        return true;
    }

    public boolean isEncryptedPackage(String packageName, int userId) {
        return true;
    }
}
