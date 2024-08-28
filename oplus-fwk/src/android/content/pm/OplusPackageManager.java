package android.content.pm;

import android.app.ActivityManager;
import android.app.ActivityThread;
import android.content.ComponentName;
import android.content.Context;
import android.content.IntentSender;
import android.content.pm.IOplusPackageManager;
import android.content.pm.IPackageDeleteObserver;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Singleton;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class OplusPackageManager {
    public static final int FLAG_APP_DATA_CE = 2;
    public static final int FLAG_APP_DATA_DE = 1;
    public static final int FLAG_APP_DATA_EXTERNAL_DATA = 16;
    public static final int FLAG_APP_DATA_EXTERNAL_MEDIA = 32;
    public static final int FLAG_APP_DATA_EXTERNAL_OBB = 64;
    public static final int INSTALL_FROM_OPLUS_ADB_INSTALLER = 268435456;
    public static final int INSTALL_SPEED_BACKGROUND = Integer.MIN_VALUE;
    public static final int INSTALL_SPEED_CPU_HIGH = 1073741824;
    public static final int INSTALL_SPEED_CPU_MID = 536870912;
    public static final int MATCH_OPLUS_FREEZE_APP = 1073741824;
    public static final int OPLUS_DONT_KILL_APP = 268435456;
    public static final int OPLUS_FREEZE_FLAG_AUTO = 2;
    public static final int OPLUS_FREEZE_FLAG_MANUAL = 1;
    public static final int OPLUS_UNFREEZE_FLAG_NORMAL = 1;
    public static final int OPLUS_UNFREEZE_FLAG_TEMP = 2;
    public static final int RE_INSTALL_DUPLICATE_PERMISSION = 1;
    public static final int STATE_OPLUS_FREEZE_FREEZED = 2;
    public static final int STATE_OPLUS_FREEZE_NORMAL = 0;
    public static final int STATE_OPLUS_FREEZE_TEMP_UNFREEZED = 1;
    private static final String TAG = "OplusPackageManager";
    private static OplusPackageManager mOplusPackageManager = null;
    private static final int sDefaultFlags = 1024;
    private final Context mContext;
    private final PackageDeleteObserver mPackageDeleleteObserver;
    private static final Singleton<IOplusPackageManager> IOplusPackageManagerSingleton = new Singleton<IOplusPackageManager>() { // from class: android.content.pm.OplusPackageManager.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.util.Singleton
        public IOplusPackageManager create() {
            try {
                IOplusPackageManager oplusPackageManager = IOplusPackageManager.Stub.asInterface(ActivityThread.getPackageManager().asBinder().getExtension());
                return oplusPackageManager;
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
    };
    private static HashMap<String, Bitmap> mAppIconsCache = new HashMap<>();
    private static HashMap<String, Bitmap> mActivityIconsCache = new HashMap<>();
    private static boolean mIconCacheDirty = false;

    private static IOplusPackageManager getService() {
        return IOplusPackageManagerSingleton.get();
    }

    public OplusPackageManager(Context context) {
        this.mPackageDeleleteObserver = new PackageDeleteObserver();
        this.mContext = context;
    }

    public OplusPackageManager() {
        this.mPackageDeleleteObserver = new PackageDeleteObserver();
        this.mContext = null;
    }

    public static OplusPackageManager getOplusPackageManager(Context context) {
        OplusPackageManager oplusPackageManager = mOplusPackageManager;
        if (oplusPackageManager != null) {
            return oplusPackageManager;
        }
        OplusPackageManager oplusPackageManager2 = new OplusPackageManager(context);
        mOplusPackageManager = oplusPackageManager2;
        return oplusPackageManager2;
    }

    public boolean isClosedSuperFirewall() {
        if (getService() != null) {
            try {
                return getService().isClosedSuperFirewall();
            } catch (RemoteException e) {
                Log.e(TAG, "isClosedSuperFirewall failed");
                return false;
            }
        }
        Log.e(TAG, "isClosedSuperFirewall failed because service has not been created");
        return false;
    }

    public Bitmap getAppIconBitmap(String packageName) throws RemoteException {
        if (getService() != null) {
            return getService().getAppIconBitmap(packageName);
        }
        Log.e(TAG, "getAppIconBitmap failed because service has not been created");
        return null;
    }

    public Map getAppIconsCache(boolean compress) throws RemoteException {
        if (getService() != null) {
            return getService().getAppIconsCache(compress);
        }
        Log.e(TAG, "getAppIconsCache failed because service has not been created");
        return null;
    }

    public Map getActivityIconsCache(IPackageDeleteObserver observer) throws RemoteException {
        if (getService() != null) {
            return getService().getActivityIconsCache(observer);
        }
        Log.e(TAG, "getActivityIconsCache failed because service has not been created");
        return null;
    }

    public boolean prohibitChildInstallation(int userId, boolean isInstall) throws RemoteException {
        if (getService() != null) {
            return getService().prohibitChildInstallation(userId, isInstall);
        }
        Log.e(TAG, "prohibitChildInstallation failed because service has not been created");
        return false;
    }

    public int oplusFreezePackage(String pkgName, int userId, int freezeFlag, int flag, String callingPkg) throws RemoteException {
        if (getService() != null) {
            return getService().oplusFreezePackage(pkgName, userId, freezeFlag, flag, callingPkg);
        }
        Log.e(TAG, "oplusFreezePackage failed because service has not been created");
        return 0;
    }

    public int oplusUnFreezePackage(String pkgName, int userId, int freezeFlag, int flag, String callingPkg) throws RemoteException {
        if (getService() != null) {
            return getService().oplusUnFreezePackage(pkgName, userId, freezeFlag, flag, callingPkg);
        }
        Log.e(TAG, "oplusUnFreezePackage failed because service has not been created");
        return 0;
    }

    public int getOplusFreezePackageState(String pkgName, int userId) throws RemoteException {
        if (getService() != null) {
            return getService().getOplusFreezePackageState(pkgName, userId);
        }
        Log.e(TAG, "getOplusFreezePackageState failed because service has not been created");
        return 0;
    }

    public boolean inOplusFreezePackageList(String pkgName, int userId) throws RemoteException {
        if (getService() != null) {
            return getService().inOplusFreezePackageList(pkgName, userId);
        }
        Log.e(TAG, "inOplusFreezePackageList failed because service has not been created");
        return false;
    }

    public List<String> getOplusFreezedPackageList(int userId) throws RemoteException {
        if (getService() != null) {
            return getService().getOplusFreezedPackageList(userId);
        }
        Log.e(TAG, "getOplusFreezedPackageList failed because service has not been created");
        return null;
    }

    public int getOplusPackageFreezeFlag(String pkgName, int userId) throws RemoteException {
        if (getService() != null) {
            return getService().getOplusPackageFreezeFlag(pkgName, userId);
        }
        Log.e(TAG, "getOplusPackageFreezeFlag failed because service has not been created");
        return 0;
    }

    public boolean loadRegionFeature(String name) throws RemoteException {
        Log.e(TAG, "loadRegionFeature failed because no longer used");
        return false;
    }

    public FeatureInfo[] getOplusSystemAvailableFeatures() throws RemoteException {
        if (getService() != null) {
            return getService().getOplusSystemAvailableFeatures();
        }
        Log.e(TAG, "getOplusSystemAvailableFeatures failed because service has not been created");
        return null;
    }

    public boolean isSecurePayApp(String name) throws RemoteException {
        if (getService() != null) {
            return getService().isSecurePayApp(name);
        }
        Log.e(TAG, "isSecurePayApp failed because service has not been created");
        return false;
    }

    public boolean isSystemDataApp(String packageName) throws RemoteException {
        if (getService() != null) {
            return getService().isSystemDataApp(packageName);
        }
        Log.e(TAG, "isSystemDataApp failed because service has not been created");
        return false;
    }

    public boolean inPmsWhiteList(int type, String verifyStr, List<String> defaultList) {
        if (getService() != null) {
            try {
                return getService().inPmsWhiteList(type, verifyStr, defaultList);
            } catch (RemoteException e) {
                Log.e(TAG, "inPmsWhiteList failed");
                return false;
            }
        }
        Log.e(TAG, "inPmsWhiteList failed because service has not been created");
        return false;
    }

    public boolean isFullFunctionMode() throws RemoteException {
        if (getService() != null) {
            return getService().isClosedSuperFirewall();
        }
        Log.e(TAG, "isFullFunctionMode failed because service has not been created");
        return false;
    }

    public Drawable getApplicationIconCacheAll(ApplicationInfo info) {
        Context context = this.mContext;
        if (context == null) {
            Log.e(TAG, "App must create OplusPackageManager with context parameter when using this method");
            return null;
        }
        return info.loadIcon(context.getPackageManager());
    }

    public Drawable getApplicationIconCache(ApplicationInfo info) {
        Context context = this.mContext;
        if (context == null) {
            Log.e(TAG, "App must create OplusPackageManager with context parameter when using this method");
            return null;
        }
        return info.loadIcon(context.getPackageManager());
    }

    public Drawable getApplicationIconCache(String packageName) throws PackageManager.NameNotFoundException {
        Context context = this.mContext;
        if (context == null) {
            Log.e(TAG, "App must create OplusPackageManager with context parameter when using this method");
            return null;
        }
        return context.getPackageManager().getApplicationIcon(this.mContext.getPackageManager().getApplicationInfoAsUser(packageName, 1024, ActivityManager.getCurrentUser()));
    }

    public Drawable getApplicationIconCacheOrignal(ApplicationInfo info) {
        Context context = this.mContext;
        if (context == null) {
            Log.e(TAG, "App must create OplusPackageManager with context parameter when using this method");
            return null;
        }
        return info.loadIcon(context.getPackageManager());
    }

    public Drawable getApplicationIconCacheOrignal(String packageName) throws PackageManager.NameNotFoundException {
        Context context = this.mContext;
        if (context == null) {
            Log.e(TAG, "App must create OplusPackageManager with context parameter when using this method");
            return null;
        }
        return context.getPackageManager().getApplicationIcon(this.mContext.getPackageManager().getApplicationInfoAsUser(packageName, 1024, ActivityManager.getCurrentUser()));
    }

    /* loaded from: classes.dex */
    private class PackageDeleteObserver extends IPackageDeleteObserver.Stub {
        private PackageDeleteObserver() {
        }

        @Override // android.content.pm.IPackageDeleteObserver
        public void packageDeleted(String packageName, int returnCode) {
            if (packageName == null) {
                return;
            }
            try {
                if (OplusPackageManager.mAppIconsCache.get(packageName) != null) {
                    OplusPackageManager.mAppIconsCache.remove(packageName);
                }
                ArrayList<String> deleteList = new ArrayList<>();
                for (Map.Entry entry : OplusPackageManager.mActivityIconsCache.entrySet()) {
                    String key = (String) entry.getKey();
                    if (packageName.equals(key.split("/")[0])) {
                        deleteList.add(key);
                    }
                }
                Iterator<String> it = deleteList.iterator();
                while (it.hasNext()) {
                    String deleteName = it.next();
                    OplusPackageManager.mActivityIconsCache.remove(deleteName);
                }
                OplusPackageManager.mIconCacheDirty = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Drawable getActivityIconCache(ComponentName componentName) throws PackageManager.NameNotFoundException {
        Context context = this.mContext;
        if (context == null) {
            Log.e(TAG, "App must create OplusPackageManager with context parameter when using this method");
            return null;
        }
        return context.getPackageManager().getActivityInfo(componentName, 1024).loadIcon(this.mContext.getPackageManager());
    }

    public List<String> getRemovableAppList() throws RemoteException {
        if (getService() != null) {
            return getService().getRemovableAppList();
        }
        Log.e(TAG, "getRemovableAppList failed because service has not been created");
        return null;
    }

    public boolean restoreRemovableApp(String packageName, IntentSender sender, Bundle bundle) throws RemoteException {
        if (getService() != null) {
            return getService().restoreRemovableApp(packageName, sender, bundle);
        }
        Log.e(TAG, "restoreRemovableApp failed because service has not been created");
        return false;
    }

    public void checkEMMApkRuntimePermission(ComponentName cn) throws SecurityException {
        String packageName = cn.getPackageName();
        if (packageName == null) {
            throw new SecurityException("Package name is null");
        }
        throw new SecurityException("Peimission Denized. Deprecated API");
    }

    public boolean isSupportSessionWrite() throws RemoteException {
        if (getService() != null) {
            return getService().isSupportSessionWrite();
        }
        Log.e(TAG, "isSupportSessionWrite failed because service has not been created");
        return false;
    }

    public List<String> getCptListByType(int tag) throws RemoteException {
        if (getService() != null) {
            return getService().getCptListByType(tag);
        }
        Log.e(TAG, "getCptListByType failed because service has not been created");
        return null;
    }

    public void sendCptUpload(String pkgName, String point) throws RemoteException {
        Log.e(TAG, "sendCptUpload failed");
    }

    public boolean inCptWhiteList(int type, String verifyStr) {
        if (getService() != null) {
            try {
                return getService().inCptWhiteList(type, verifyStr);
            } catch (RemoteException e) {
                Log.e(TAG, "inCptWhiteList failed");
                return false;
            }
        }
        Log.e(TAG, "inCptWhiteList failed because service has not been created");
        return false;
    }

    public boolean inOplusStandardWhiteList(String filterName, int type, String verifyStr) throws RemoteException {
        if (getService() != null) {
            return getService().inOplusStandardWhiteList(filterName, type, verifyStr);
        }
        Log.e(TAG, "inOplusStandardWhiteList failed because service has not been created");
        return false;
    }

    public void sendMapCommonDcsUpload(String logTag, String eventId, Map map) throws RemoteException {
        if (getService() != null) {
            getService().sendMapCommonDcsUpload(logTag, eventId, map);
        } else {
            Log.e(TAG, "sendMapCommonDcsUpload failed because service has not been created");
        }
    }

    public List<ApplicationInfo> getIconPackList() {
        if (getService() != null) {
            try {
                return getService().getIconPackList();
            } catch (RemoteException e) {
                Log.e(TAG, "getIconPackList failed");
                return null;
            }
        }
        Log.e(TAG, "getIconPackList failed because service has not been created");
        return null;
    }

    public boolean isDetectApp(String packageName) throws RemoteException {
        if (getService() != null) {
            return getService().isDetectApp(packageName);
        }
        Log.e(TAG, "isDetectApp failed because service has not been created");
        return false;
    }

    public List<String> getDetectAppList() throws RemoteException {
        if (getService() != null) {
            return getService().getDetectAppList();
        }
        Log.e(TAG, "getDetectAppList failed because service has not been created");
        return null;
    }

    public boolean isCrossVersionUpdate() throws RemoteException {
        if (getService() != null) {
            return getService().isCrossVersionUpdate();
        }
        Log.e(TAG, "isCrossVersionUpdate failed because service has not been created");
        return false;
    }

    public List<String> getNotInstalledSystemApps() throws RemoteException {
        if (getService() != null) {
            return getService().getNotInstalledSystemApps();
        }
        Log.e(TAG, "getNotInstalledSystemApps failed because service has not been created");
        return null;
    }

    public List<String> getValidAppList() throws RemoteException {
        if (getService() != null) {
            return getService().getValidAppList();
        }
        Log.e(TAG, "getValidAppList failed because service has not been created");
        return null;
    }

    public List<String> getAppListFromPartition(String partition) throws RemoteException {
        if (getService() != null) {
            return getService().getAppListFromPartition(partition);
        }
        Log.e(TAG, "getAppListFromPartition failed because service has not been created");
        return null;
    }

    public void deletePackageDelegated(String packageName, int callUid, int callPid, int flags, int userId, IPackageDeleteObserver observer) throws RemoteException {
        if (getService() != null) {
            getService().deletePackageDelegated(packageName, callUid, callPid, flags, userId, observer);
        } else {
            Log.e(TAG, "deletePackageDelegated failed because service has not been created");
        }
    }

    public boolean fixupAppData(String pkgName, int flags) throws RuntimeException {
        return fixupAppData(pkgName, null, flags);
    }

    public boolean fixupAppData(String pkgName, String relativePath, int flags) throws RuntimeException {
        if (getService() != null) {
            try {
                return getService().fixupAppData(pkgName, relativePath, flags);
            } catch (RemoteException e) {
                throw e.rethrowFromSystemServer();
            }
        }
        Log.e(TAG, "fixupAppData failed because service has not been created");
        return false;
    }

    public String getMigMappingPkgName(boolean findOldNameByNew, String refPkgName) throws RuntimeException {
        if (getService() != null) {
            try {
                return getService().getMigMappingPkgName(findOldNameByNew, refPkgName);
            } catch (RemoteException e) {
                Log.e(TAG, "getMigMappingPkgName failed");
                return null;
            }
        }
        Log.e(TAG, "getMigMappingPkgName failed because service has not been created");
        return null;
    }

    public List<String> getUninstallableAppConfig(int type) {
        if (getService() != null) {
            try {
                return getService().getUninstallableAppConfig(type);
            } catch (RemoteException e) {
                Log.e(TAG, "getUninstallableAppConfig failed");
                return null;
            }
        }
        Log.e(TAG, "getUninstallableAppConfig failed because service has not been created");
        return null;
    }

    public boolean inUninstallableAppConfig(int type, String pkgName) {
        if (TextUtils.isEmpty(pkgName)) {
            return false;
        }
        if (getService() != null) {
            try {
                return getService().inUninstallableAppConfig(type, pkgName);
            } catch (RemoteException e) {
                Log.e(TAG, "inUninstallableAppConfig failed");
            }
        } else {
            Log.e(TAG, "inUninstallableAppConfig failed because service has not been created");
        }
        return false;
    }

    public boolean setCustomizeDefaultApp(String roleName, String packageName) throws RemoteException {
        if (getService() != null) {
            return getService().setCustomizeDefaultApp(roleName, packageName);
        }
        Log.e(TAG, "setCustomizeDefaultApp failed because service has not been created");
        return false;
    }

    public void removeCustomizeDefaultApp(String roleName) throws RemoteException {
        if (getService() != null) {
            getService().removeCustomizeDefaultApp(roleName);
        } else {
            Log.e(TAG, "removeCustomizeDefaultApp failed because service has not been created");
        }
    }

    public String getCustomizeDefaultApp(String roleName) throws RemoteException {
        if (getService() != null) {
            return getService().getCustomizeDefaultApp(roleName);
        }
        Log.e(TAG, "getCustomizeDefaultApp failed because service has not been created");
        return null;
    }

    public boolean isFreezeEnabled() {
        if (getService() != null) {
            try {
                return getService().isFreezeEnabled();
            } catch (RemoteException e) {
                Log.e(TAG, "isFreezeEnabled failed");
                return false;
            }
        }
        Log.e(TAG, "isFreezeEnabled failed because service has not been created");
        return false;
    }

    public void setFreezeEnable(boolean enabled) {
        if (getService() != null) {
            try {
                getService().setFreezeEnable(enabled);
                return;
            } catch (RemoteException e) {
                Log.e(TAG, "setFreezeEnable failed");
                return;
            }
        }
        Log.e(TAG, "setFreezeEnable failed because service has not been created");
    }

    public int getPackageFreezeState(String pkg, UserHandle userHandle) {
        if (getService() != null) {
            try {
                return getService().getPackageFreezeState(pkg, userHandle);
            } catch (RemoteException e) {
                Log.e(TAG, "getPackageFreezeState failed");
                return -1;
            }
        }
        Log.e(TAG, "getPackageFreezeState failed because service has not been created");
        return -1;
    }

    public int getPackageFreezeUserSetting(String pkg, UserHandle userHandle) {
        if (getService() != null) {
            try {
                return getService().getPackageFreezeUserSetting(pkg, userHandle);
            } catch (RemoteException e) {
                Log.e(TAG, "getPackageFreezeUserSetting failed");
                return -1;
            }
        }
        Log.e(TAG, "getPackageFreezeUserSetting failed because service has not been created");
        return -1;
    }

    public void setPackageFreezeState(String pkg, int state, UserHandle userHandle) {
        if (getService() != null) {
            try {
                getService().setPackageFreezeState(pkg, state, userHandle);
                return;
            } catch (RemoteException e) {
                Log.e(TAG, "setPackageFreezeState failed");
                return;
            }
        }
        Log.e(TAG, "setPackageFreezeState failed because service has not been created");
    }

    public void setPackageFreezeUserSetting(String pkg, int setting, UserHandle userHandle) {
        if (getService() != null) {
            try {
                getService().setPackageFreezeUserSetting(pkg, setting, userHandle);
                return;
            } catch (RemoteException e) {
                Log.e(TAG, "setPackageFreezeUserSetting failed");
                return;
            }
        }
        Log.e(TAG, "setPackageFreezeUserSetting failed because service has not been created");
    }

    public List<String> getFreezedApplicationList(UserHandle userHandle) {
        if (getService() != null) {
            try {
                return getService().getFreezedApplicationList(userHandle);
            } catch (RemoteException e) {
                Log.e(TAG, "getFreezedApplicationList failed");
                return null;
            }
        }
        Log.e(TAG, "getFreezedApplicationList failed because service has not been created");
        return null;
    }

    public List<String> getUserSettingFreezeableApplicationList(UserHandle userHandle) {
        if (getService() != null) {
            try {
                return getService().getUserSettingFreezeableApplicationList(userHandle);
            } catch (RemoteException e) {
                Log.e(TAG, "getUserSettingFreezeableApplicationList failed");
                return null;
            }
        }
        Log.e(TAG, "getUserSettingFreezeableApplicationList failed because service has not been created");
        return null;
    }

    public boolean hasFeatureIPC(String featureName, int featureID) throws RemoteException {
        if (getService() != null) {
            return getService().hasFeatureIPC(featureName, featureID);
        }
        Log.e(TAG, "hasFeature failed because service has not been created");
        return false;
    }

    public boolean enableFeature(String featureName) throws RemoteException {
        if (getService() != null) {
            return getService().enableFeature(featureName);
        }
        Log.e(TAG, "enableFeature failed because service has not been created");
        return false;
    }

    public boolean disableFeature(String featureName) throws RemoteException {
        if (getService() != null) {
            return getService().disableFeature(featureName);
        }
        Log.e(TAG, "disableFeature failed because service has not been created");
        return false;
    }

    public boolean enableFeatureMap(String featureName, int featureID) throws RemoteException {
        if (getService() != null) {
            return getService().enableFeatureMap(featureName, featureID);
        }
        Log.e(TAG, "enableFeature failed because service has not been created");
        return false;
    }

    public boolean disableFeatureMap(String featureName, int featureID) throws RemoteException {
        if (getService() != null) {
            return getService().disableFeatureMap(featureName, featureID);
        }
        Log.e(TAG, "disableFeature failed because service has not been created");
        return false;
    }

    public void notifyFeaturesUpdate(String action, String actionValue) throws RemoteException {
        if (getService() != null) {
            getService().notifyFeaturesUpdate(action, actionValue);
        } else {
            Log.e(TAG, "notifyFeaturesUpdate failed because service has not been created");
        }
    }

    public void notifyFeaturesMapUpdate(String action, String actionValue, int featureID) throws RemoteException {
        if (getService() != null) {
            getService().notifyFeaturesMapUpdate(action, actionValue, featureID);
        } else {
            Log.e(TAG, "notifyFeaturesMapUpdate failed because service has not been created");
        }
    }

    public static Bundle appDetailsForwardToMarket(int type, Bundle bundle) {
        try {
            if (getService() != null) {
                return getService().appDetailsForwardToMarket(type, bundle);
            }
            Log.e(TAG, "appDetailsForwardToMarket failed because service has not been created");
            return null;
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public static boolean markResolveIntentForMarket(String token) {
        try {
            if (getService() != null) {
                return getService().markResolveIntentForMarket(token);
            }
            Log.e(TAG, "markResolveIntentForMarket failed because service has not been created");
            return false;
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public int getAbiCheckResult(String packageName) {
        try {
            if (getService() != null) {
                return getService().getAbiCheckResult(packageName);
            }
            Log.e(TAG, "getAbiCheckResult failed because service has not been created");
            return -1;
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }

    public List<String> queryIncompatibleApplist() {
        try {
            if (getService() != null) {
                return getService().queryIncompatibleApplist();
            }
            Log.e(TAG, "queryIncompatibleApplist failed because service has not been created");
            return new ArrayList();
        } catch (RemoteException e) {
            throw e.rethrowFromSystemServer();
        }
    }
}
