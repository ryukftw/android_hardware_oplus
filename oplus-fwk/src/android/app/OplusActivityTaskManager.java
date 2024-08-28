package android.app;

import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.RemoteException;
import com.oplus.app.OplusAppInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class OplusActivityTaskManager extends OplusBaseActivityTaskManager implements IOplusActivityTaskManager {
    public static OplusActivityTaskManager getInstance() {
        return LazyHolder.INSTANCE;
    }

    /* loaded from: classes.dex */
    public static class LazyHolder {
        private static final OplusActivityTaskManager INSTANCE = new OplusActivityTaskManager();

        private LazyHolder() {
        }
    }

    @Override // android.app.IOplusActivityTaskManager
    public ComponentName getTopActivityComponentName() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            data.writeInterfaceToken("android.app.IActivityTaskManager");
            this.mRemote.transact(10007, data, reply, 0);
            reply.readException();
            ComponentName name = ComponentName.readFromParcel(reply);
            return name;
        } finally {
            data.recycle();
            reply.recycle();
        }
    }

    @Override // android.app.IOplusActivityTaskManager
    public ApplicationInfo getTopApplicationInfo() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        try {
            data.writeInterfaceToken("android.app.IActivityTaskManager");
            this.mRemote.transact(10011, data, reply, 0);
            reply.readException();
            ApplicationInfo info = ApplicationInfo.CREATOR.createFromParcel(reply);
            return info;
        } finally {
            data.recycle();
            reply.recycle();
        }
    }

    @Override // android.app.IOplusActivityTaskManager
    public List<OplusAppInfo> getAllTopAppInfos() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        new ArrayList();
        try {
            data.writeInterfaceToken("android.app.IActivityTaskManager");
            this.mRemote.transact(10053, data, reply, 0);
            reply.readException();
            List<OplusAppInfo> list = reply.createTypedArrayList(OplusAppInfo.CREATOR);
            return list;
        } finally {
            data.recycle();
            reply.recycle();
        }
    }

    @Override // android.app.IOplusActivityTaskManager
    public List<OplusAppInfo> getAllTopApps() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        new ArrayList();
        try {
            data.writeInterfaceToken("android.app.IActivityTaskManager");
            this.mRemote.transact(10058, data, reply, 0);
            reply.readException();
            List<OplusAppInfo> list = reply.createTypedArrayList(OplusAppInfo.CREATOR);
            return list;
        } finally {
            data.recycle();
            reply.recycle();
        }
    }
}
