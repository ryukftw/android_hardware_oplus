package android.app;

import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.os.RemoteException;
import com.oplus.app.OplusAppInfo;
import java.util.List;

/* loaded from: classes.dex */
public interface IOplusActivityTaskManager extends IOplusBaseActivityTaskManager {

    List<OplusAppInfo> getAllTopAppInfos() throws RemoteException;

    List<OplusAppInfo> getAllTopApps() throws RemoteException;

    ComponentName getTopActivityComponentName() throws RemoteException;

    ApplicationInfo getTopApplicationInfo() throws RemoteException;
}
