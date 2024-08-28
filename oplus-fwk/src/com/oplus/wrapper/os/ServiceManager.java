package com.oplus.wrapper.os;

import android.os.IBinder;

/* loaded from: classes.dex */
public class ServiceManager {
    public static IBinder checkService(String name) {
        return android.os.ServiceManager.checkService(name);
    }

    public static IBinder getService(String name) {
        return android.os.ServiceManager.getService(name);
    }

    public static void addService(String name, IBinder service) {
        android.os.ServiceManager.addService(name, service);
    }
}
