package oplus.app;

import android.os.IBinder;
import android.os.ServiceManager;
import android.util.Log;

public abstract class OplusCommonManager {
    protected final IBinder mRemote;

    public OplusCommonManager(String name) {
        this(ServiceManager.getService(name), name);
    }

    public OplusCommonManager(IBinder remote, String name) {
        if (remote == null) {
            Log.e("OplusCommonManager", "remote is null: " + name);
            remote = ServiceManager.getService(name);
            StringBuilder sb = new StringBuilder();
            sb.append("Retry remote is null: ");
            sb.append(remote == null);
            Log.d("OplusCommonManager", sb.toString());
        }
        this.mRemote = remote;
    }
}
