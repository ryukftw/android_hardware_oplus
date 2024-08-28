package com.oplus.util;

import android.app.OplusActivityManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;

public final class OplusCommonConfig {
    private static final String TAG = "OplusCommonConfig";
    private OplusActivityManager mOppoAm;

    private static OplusCommonConfig sInstance = null;

    private OplusCommonConfig() {
        this.mOppoAm = null;
        this.mOppoAm = new OplusActivityManager();
    }

    public static OplusCommonConfig getInstance() {
        if (sInstance == null) {
            sInstance = new OplusCommonConfig();
        }
        return sInstance;
    }

    public boolean putConfigInfo(String configName, Bundle bundle, int flag) {
        if (this.mOppoAm == null) {
            this.mOppoAm = new OplusActivityManager();
        }
        OplusActivityManager oplusActivityManager = this.mOppoAm;
        if (oplusActivityManager != null) {
            try {
                return oplusActivityManager.putConfigInfo(configName, bundle, flag, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.e(TAG, "putConfigInfo " + configName + " failed!");
                return false;
            }
        }
        return false;
    }

    public boolean putConfigInfoAsUser(String configName, Bundle bundle, int flag, int userId) {
        if (this.mOppoAm == null) {
            this.mOppoAm = new OplusActivityManager();
        }
        OplusActivityManager oplusActivityManager = this.mOppoAm;
        if (oplusActivityManager != null) {
            try {
                return oplusActivityManager.putConfigInfo(configName, bundle, flag, userId);
            } catch (RemoteException e) {
                Log.e(TAG, "putConfigInfoAsUser " + configName + " failed!");
                return false;
            }
        }
        return false;
    }

    public Bundle getConfigInfo(String configName, int flag) {
        if (this.mOppoAm == null) {
            this.mOppoAm = new OplusActivityManager();
        }
        OplusActivityManager oplusActivityManager = this.mOppoAm;
        if (oplusActivityManager != null) {
            try {
                return oplusActivityManager.getConfigInfo(configName, flag, UserHandle.myUserId());
            } catch (RemoteException e) {
                Log.e(TAG, "getConfigInfo " + configName + " failed!");
                return null;
            }
        }
        return null;
    }

    public Bundle getConfigInfoAsUser(String configName, int flag, int userId) {
        if (this.mOppoAm == null) {
            this.mOppoAm = new OplusActivityManager();
        }
        OplusActivityManager oplusActivityManager = this.mOppoAm;
        if (oplusActivityManager != null) {
            try {
                return oplusActivityManager.getConfigInfo(configName, flag, userId);
            } catch (RemoteException e) {
                Log.e(TAG, "getConfigInfoAsUser " + configName + " failed!");
                return null;
            }
        }
        return null;
    }    
}
