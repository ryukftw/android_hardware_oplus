package com.oplus.osense.eventinfo;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IOsenseEventCallback extends IInterface {

    public static class Default implements IOsenseEventCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IOsenseEventCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
