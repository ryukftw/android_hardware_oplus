package android.app;

import android.app.ActivityManager;
import android.os.Bundle;
import android.os.RemoteException;

/* loaded from: classes.dex */
public interface IOplusActivityManager extends IOplusBaseActivityManager {

    Bundle getConfigInfo(String str, int i, int i2) throws RemoteException;

    boolean putConfigInfo(String str, Bundle bundle, int i, int i2) throws RemoteException;
}
