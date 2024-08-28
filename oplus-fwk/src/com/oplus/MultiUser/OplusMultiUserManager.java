package com.oplus.multiuser;

import android.os.UserHandle;

public class OplusMultiUserManager {

    private static OplusMultiUserManager instance;

    private OplusMultiUserManager() {}

    public static OplusMultiUserManager getInstance() {
        if (instance == null) {
            instance = new OplusMultiUserManager();
        }
        return instance;
    }

    public boolean isMultiSystemUserHandle(UserHandle userHandle) {
        return false;
    }
}
