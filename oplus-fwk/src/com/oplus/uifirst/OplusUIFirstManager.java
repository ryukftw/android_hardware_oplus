package com.oplus.uifirst;

import com.oplus.uifirst.Utils;

public class OplusUIFirstManager extends Utils {
    private static OplusUIFirstManager sInstance = null;
    private OplusUIFirstManager() {}

    public static OplusUIFirstManager getInstance() {
        if (sInstance == null) {
            sInstance = new OplusUIFirstManager();
        }
        return sInstance;
    }

    public void setUxThreadValue(int pid, int tid, String value) {
    }
}
