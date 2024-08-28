package android.content.pm;

import android.content.IntentSender;
import android.content.pm.IPackageDeleteObserver;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.UserHandle;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface IOplusPackageManager extends IInterface {
    public static final String DESCRIPTOR = "android.content.pm.IOplusPackageManager";

    Bundle appDetailsForwardToMarket(int i, Bundle bundle) throws RemoteException;

    void deletePackageDelegated(String str, int i, int i2, int i3, int i4, IPackageDeleteObserver iPackageDeleteObserver) throws RemoteException;

    boolean disableFeature(String str) throws RemoteException;

    boolean disableFeatureMap(String str, int i) throws RemoteException;

    boolean enableFeature(String str) throws RemoteException;

    boolean enableFeatureMap(String str, int i) throws RemoteException;

    boolean fixupAppData(String str, String str2, int i) throws RemoteException;

    int getAbiCheckResult(String str) throws RemoteException;

    Map getActivityIconsCache(IPackageDeleteObserver iPackageDeleteObserver) throws RemoteException;

    Bitmap getAppIconBitmap(String str) throws RemoteException;

    Map getAppIconsCache(boolean z) throws RemoteException;

    List<String> getAppListFromPartition(String str) throws RemoteException;

    List<String> getCptListByType(int i) throws RemoteException;

    String getCustomizeDefaultApp(String str) throws RemoteException;

    List<String> getDetectAppList() throws RemoteException;

    List<String> getFreezedApplicationList(UserHandle userHandle) throws RemoteException;

    List<ApplicationInfo> getIconPackList() throws RemoteException;

    String getMigMappingPkgName(boolean z, String str) throws RemoteException;

    List<String> getNotInstalledSystemApps() throws RemoteException;

    int getOplusFreezePackageState(String str, int i) throws RemoteException;

    List<String> getOplusFreezedPackageList(int i) throws RemoteException;

    int getOplusPackageFreezeFlag(String str, int i) throws RemoteException;

    FeatureInfo[] getOplusSystemAvailableFeatures() throws RemoteException;

    int getPackageFreezeState(String str, UserHandle userHandle) throws RemoteException;

    int getPackageFreezeUserSetting(String str, UserHandle userHandle) throws RemoteException;

    List<String> getRemovableAppList() throws RemoteException;

    List<String> getUninstallableAppConfig(int i) throws RemoteException;

    List<String> getUserSettingFreezeableApplicationList(UserHandle userHandle) throws RemoteException;

    List<String> getValidAppList() throws RemoteException;

    boolean hasFeatureIPC(String str, int i) throws RemoteException;

    boolean inCptWhiteList(int i, String str) throws RemoteException;

    boolean inOplusFreezePackageList(String str, int i) throws RemoteException;

    boolean inOplusStandardWhiteList(String str, int i, String str2) throws RemoteException;

    boolean inPmsWhiteList(int i, String str, List<String> list) throws RemoteException;

    boolean inUninstallableAppConfig(int i, String str) throws RemoteException;

    boolean isClosedSuperFirewall() throws RemoteException;

    boolean isCrossVersionUpdate() throws RemoteException;

    boolean isDetectApp(String str) throws RemoteException;

    boolean isFreezeEnabled() throws RemoteException;

    boolean isSecurePayApp(String str) throws RemoteException;

    boolean isSupportSessionWrite() throws RemoteException;

    boolean isSystemDataApp(String str) throws RemoteException;

    boolean markResolveIntentForMarket(String str) throws RemoteException;

    void notifyFeaturesMapUpdate(String str, String str2, int i) throws RemoteException;

    void notifyFeaturesUpdate(String str, String str2) throws RemoteException;

    int oplusFreezePackage(String str, int i, int i2, int i3, String str2) throws RemoteException;

    int oplusUnFreezePackage(String str, int i, int i2, int i3, String str2) throws RemoteException;

    boolean prohibitChildInstallation(int i, boolean z) throws RemoteException;

    List<String> queryIncompatibleApplist() throws RemoteException;

    void removeCustomizeDefaultApp(String str) throws RemoteException;

    boolean restoreRemovableApp(String str, IntentSender intentSender, Bundle bundle) throws RemoteException;

    void sendMapCommonDcsUpload(String str, String str2, Map map) throws RemoteException;

    boolean setCustomizeDefaultApp(String str, String str2) throws RemoteException;

    void setFreezeEnable(boolean z) throws RemoteException;

    void setPackageFreezeState(String str, int i, UserHandle userHandle) throws RemoteException;

    void setPackageFreezeUserSetting(String str, int i, UserHandle userHandle) throws RemoteException;

    /* loaded from: classes.dex */
    public static class Default implements IOplusPackageManager {
        @Override // android.content.pm.IOplusPackageManager
        public boolean isClosedSuperFirewall() throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public Bitmap getAppIconBitmap(String packageName) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public Map getAppIconsCache(boolean compress) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public Map getActivityIconsCache(IPackageDeleteObserver observer) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean prohibitChildInstallation(int userId, boolean isInstall) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public int oplusFreezePackage(String pkgName, int userId, int freezeFlag, int flag, String callingPkg) throws RemoteException {
            return 0;
        }

        @Override // android.content.pm.IOplusPackageManager
        public int oplusUnFreezePackage(String pkgName, int userId, int freezeFlag, int flag, String callingPkg) throws RemoteException {
            return 0;
        }

        @Override // android.content.pm.IOplusPackageManager
        public int getOplusFreezePackageState(String pkgName, int userId) throws RemoteException {
            return 0;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean inOplusFreezePackageList(String pkgName, int userId) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getOplusFreezedPackageList(int userId) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public int getOplusPackageFreezeFlag(String pkgName, int userId) throws RemoteException {
            return 0;
        }

        @Override // android.content.pm.IOplusPackageManager
        public FeatureInfo[] getOplusSystemAvailableFeatures() throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean isSecurePayApp(String name) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean isSystemDataApp(String packageName) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean inPmsWhiteList(int type, String verifyStr, List<String> defaultList) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getRemovableAppList() throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean restoreRemovableApp(String packageName, IntentSender sender, Bundle bundle) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean isSupportSessionWrite() throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getCptListByType(int tag) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean inCptWhiteList(int type, String verifyStr) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean inOplusStandardWhiteList(String filterName, int type, String verifyStr) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public void sendMapCommonDcsUpload(String logTag, String eventId, Map map) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<ApplicationInfo> getIconPackList() throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean isDetectApp(String packageName) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getDetectAppList() throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean isCrossVersionUpdate() throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getNotInstalledSystemApps() throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getValidAppList() throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getAppListFromPartition(String partition) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public void deletePackageDelegated(String packageName, int callUid, int callPid, int flags, int userId, IPackageDeleteObserver observer) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean setCustomizeDefaultApp(String roleName, String packageName) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public void removeCustomizeDefaultApp(String roleName) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public String getCustomizeDefaultApp(String roleName) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean fixupAppData(String pkgName, String relativePath, int flags) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public String getMigMappingPkgName(boolean findOldNameByNew, String refPkgName) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getUninstallableAppConfig(int type) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean inUninstallableAppConfig(int type, String pkgName) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean isFreezeEnabled() throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public void setFreezeEnable(boolean enabled) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public int getPackageFreezeState(String pkg, UserHandle userHandle) throws RemoteException {
            return 0;
        }

        @Override // android.content.pm.IOplusPackageManager
        public int getPackageFreezeUserSetting(String pkg, UserHandle userHandle) throws RemoteException {
            return 0;
        }

        @Override // android.content.pm.IOplusPackageManager
        public void setPackageFreezeState(String pkg, int state, UserHandle userHandle) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public void setPackageFreezeUserSetting(String pkg, int setting, UserHandle userHandle) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getFreezedApplicationList(UserHandle userHandle) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> getUserSettingFreezeableApplicationList(UserHandle userHandle) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean hasFeatureIPC(String featureName, int featureID) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean enableFeature(String featureName) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean disableFeature(String featureName) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean enableFeatureMap(String featureName, int featureID) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean disableFeatureMap(String featureName, int featureID) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public void notifyFeaturesUpdate(String action, String actionValue) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public void notifyFeaturesMapUpdate(String action, String actionValue, int featureID) throws RemoteException {
        }

        @Override // android.content.pm.IOplusPackageManager
        public Bundle appDetailsForwardToMarket(int type, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // android.content.pm.IOplusPackageManager
        public boolean markResolveIntentForMarket(String token) throws RemoteException {
            return false;
        }

        @Override // android.content.pm.IOplusPackageManager
        public int getAbiCheckResult(String packageName) throws RemoteException {
            return 0;
        }

        @Override // android.content.pm.IOplusPackageManager
        public List<String> queryIncompatibleApplist() throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IOplusPackageManager {
        static final int TRANSACTION_appDetailsForwardToMarket = 66;
        static final int TRANSACTION_deletePackageDelegated = 36;
        static final int TRANSACTION_disableFeature = 55;
        static final int TRANSACTION_disableFeatureMap = 57;
        static final int TRANSACTION_dynamicDetectApp = 29;
        static final int TRANSACTION_enableFeature = 54;
        static final int TRANSACTION_enableFeatureMap = 56;
        static final int TRANSACTION_fixupAppData = 41;
        static final int TRANSACTION_getAbiCheckResult = 68;
        static final int TRANSACTION_getActivityIconsCache = 4;
        static final int TRANSACTION_getAppIconBitmap = 2;
        static final int TRANSACTION_getAppIconsCache = 3;
        static final int TRANSACTION_getAppListFromPartition = 35;
        static final int TRANSACTION_getCptListByType = 24;
        static final int TRANSACTION_getCustomizeDefaultApp = 40;
        static final int TRANSACTION_getDetectAppList = 31;
        static final int TRANSACTION_getFreezedApplicationList = 51;
        static final int TRANSACTION_getIconPackList = 28;
        static final int TRANSACTION_getInterceptRuleInfos = 17;
        static final int TRANSACTION_getMigMappingPkgName = 42;
        static final int TRANSACTION_getNotInstalledSystemApps = 33;
        static final int TRANSACTION_getOplusFreezePackageState = 8;
        static final int TRANSACTION_getOplusFreezedPackageList = 10;
        static final int TRANSACTION_getOplusPackageFreezeFlag = 11;
        static final int TRANSACTION_getOplusSystemAvailableFeatures = 12;
        static final int TRANSACTION_getPackageFreezeState = 47;
        static final int TRANSACTION_getPackageFreezeUserSetting = 48;
        static final int TRANSACTION_getRemovableAppInfo = 21;
        static final int TRANSACTION_getRemovableAppInfos = 20;
        static final int TRANSACTION_getRemovableAppList = 18;
        static final int TRANSACTION_getRemovedAppInfos = 19;
        static final int TRANSACTION_getSystemUpdateInfo = 37;
        static final int TRANSACTION_getUninstallableAppConfig = 43;
        static final int TRANSACTION_getUserSettingFreezeableApplicationList = 52;
        static final int TRANSACTION_getValidAppList = 34;
        static final int TRANSACTION_hasFeatureIPC = 53;
        static final int TRANSACTION_inCptWhiteList = 25;
        static final int TRANSACTION_inOplusFreezePackageList = 9;
        static final int TRANSACTION_inOplusStandardWhiteList = 26;
        static final int TRANSACTION_inPmsWhiteList = 15;
        static final int TRANSACTION_inUninstallableAppConfig = 44;
        static final int TRANSACTION_isClosedSuperFirewall = 1;
        static final int TRANSACTION_isCrossVersionUpdate = 32;
        static final int TRANSACTION_isDetectApp = 30;
        static final int TRANSACTION_isFreezeEnabled = 45;
        static final int TRANSACTION_isSecurePayApp = 13;
        static final int TRANSACTION_isSupportSessionWrite = 23;
        static final int TRANSACTION_isSystemDataApp = 14;
        static final int TRANSACTION_markResolveIntentForMarket = 67;
        static final int TRANSACTION_notifyFeaturesMapUpdate = 59;
        static final int TRANSACTION_notifyFeaturesUpdate = 58;
        static final int TRANSACTION_oplusFreezePackage = 6;
        static final int TRANSACTION_oplusUnFreezePackage = 7;
        static final int TRANSACTION_prohibitChildInstallation = 5;
        static final int TRANSACTION_queryIncompatibleApplist = 69;
        static final int TRANSACTION_registerFeatureActionObserverInner = 64;
        static final int TRANSACTION_registerFeatureMapObserverInner = 62;
        static final int TRANSACTION_registerFeatureObserverInner = 60;
        static final int TRANSACTION_removeCustomizeDefaultApp = 39;
        static final int TRANSACTION_restoreRemovableApp = 22;
        static final int TRANSACTION_sendMapCommonDcsUpload = 27;
        static final int TRANSACTION_setCustomizeDefaultApp = 38;
        static final int TRANSACTION_setFreezeEnable = 46;
        static final int TRANSACTION_setInterceptRuleInfos = 16;
        static final int TRANSACTION_setPackageFreezeState = 49;
        static final int TRANSACTION_setPackageFreezeUserSetting = 50;
        static final int TRANSACTION_unregisterFeatureActionObserverInner = 65;
        static final int TRANSACTION_unregisterFeatureMapObserverInner = 63;
        static final int TRANSACTION_unregisterFeatureObserverInner = 61;

        public Stub() {
            attachInterface(this, IOplusPackageManager.DESCRIPTOR);
        }

        public static IOplusPackageManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(IOplusPackageManager.DESCRIPTOR);
            if (iin != null && (iin instanceof IOplusPackageManager)) {
                return (IOplusPackageManager) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case 1:
                    return "isClosedSuperFirewall";
                case 2:
                    return "getAppIconBitmap";
                case 3:
                    return "getAppIconsCache";
                case 4:
                    return "getActivityIconsCache";
                case 5:
                    return "prohibitChildInstallation";
                case 6:
                    return "oplusFreezePackage";
                case 7:
                    return "oplusUnFreezePackage";
                case 8:
                    return "getOplusFreezePackageState";
                case 9:
                    return "inOplusFreezePackageList";
                case 10:
                    return "getOplusFreezedPackageList";
                case 11:
                    return "getOplusPackageFreezeFlag";
                case 12:
                    return "getOplusSystemAvailableFeatures";
                case 13:
                    return "isSecurePayApp";
                case 14:
                    return "isSystemDataApp";
                case 15:
                    return "inPmsWhiteList";
                case 16:
                    return "setInterceptRuleInfos";
                case 17:
                    return "getInterceptRuleInfos";
                case 18:
                    return "getRemovableAppList";
                case 19:
                    return "getRemovedAppInfos";
                case 20:
                    return "getRemovableAppInfos";
                case 21:
                    return "getRemovableAppInfo";
                case 22:
                    return "restoreRemovableApp";
                case 23:
                    return "isSupportSessionWrite";
                case 24:
                    return "getCptListByType";
                case 25:
                    return "inCptWhiteList";
                case 26:
                    return "inOplusStandardWhiteList";
                case 27:
                    return "sendMapCommonDcsUpload";
                case 28:
                    return "getIconPackList";
                case 29:
                    return "dynamicDetectApp";
                case 30:
                    return "isDetectApp";
                case 31:
                    return "getDetectAppList";
                case 32:
                    return "isCrossVersionUpdate";
                case 33:
                    return "getNotInstalledSystemApps";
                case 34:
                    return "getValidAppList";
                case 35:
                    return "getAppListFromPartition";
                case 36:
                    return "deletePackageDelegated";
                case 37:
                    return "getSystemUpdateInfo";
                case 38:
                    return "setCustomizeDefaultApp";
                case 39:
                    return "removeCustomizeDefaultApp";
                case 40:
                    return "getCustomizeDefaultApp";
                case 41:
                    return "fixupAppData";
                case 42:
                    return "getMigMappingPkgName";
                case 43:
                    return "getUninstallableAppConfig";
                case 44:
                    return "inUninstallableAppConfig";
                case 45:
                    return "isFreezeEnabled";
                case 46:
                    return "setFreezeEnable";
                case 47:
                    return "getPackageFreezeState";
                case 48:
                    return "getPackageFreezeUserSetting";
                case 49:
                    return "setPackageFreezeState";
                case 50:
                    return "setPackageFreezeUserSetting";
                case 51:
                    return "getFreezedApplicationList";
                case 52:
                    return "getUserSettingFreezeableApplicationList";
                case 53:
                    return "hasFeatureIPC";
                case 54:
                    return "enableFeature";
                case 55:
                    return "disableFeature";
                case 56:
                    return "enableFeatureMap";
                case 57:
                    return "disableFeatureMap";
                case 58:
                    return "notifyFeaturesUpdate";
                case 59:
                    return "notifyFeaturesMapUpdate";
                case 60:
                    return "registerFeatureObserverInner";
                case 61:
                    return "unregisterFeatureObserverInner";
                case 62:
                    return "registerFeatureMapObserverInner";
                case 63:
                    return "unregisterFeatureMapObserverInner";
                case 64:
                    return "registerFeatureActionObserverInner";
                case 65:
                    return "unregisterFeatureActionObserverInner";
                case 66:
                    return "appDetailsForwardToMarket";
                case 67:
                    return "markResolveIntentForMarket";
                case 68:
                    return "getAbiCheckResult";
                case 69:
                    return "queryIncompatibleApplist";
                default:
                    return null;
            }
        }

        @Override // android.os.Binder
        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            if (code >= 1 && code <= 16777215) {
                data.enforceInterface(IOplusPackageManager.DESCRIPTOR);
            }
            switch (code) {
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    reply.writeString(IOplusPackageManager.DESCRIPTOR);
                    return true;
                default:
                    switch (code) {
                        case 1:
                            boolean _result = isClosedSuperFirewall();
                            reply.writeNoException();
                            reply.writeBoolean(_result);
                            break;
                        case 2:
                            String _arg0 = data.readString();
                            data.enforceNoDataAvail();
                            Bitmap _result2 = getAppIconBitmap(_arg0);
                            reply.writeNoException();
                            reply.writeTypedObject(_result2, 1);
                            break;
                        case 3:
                            boolean _arg02 = data.readBoolean();
                            data.enforceNoDataAvail();
                            Map _result3 = getAppIconsCache(_arg02);
                            reply.writeNoException();
                            reply.writeMap(_result3);
                            break;
                        case 4:
                            IPackageDeleteObserver _arg03 = IPackageDeleteObserver.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            Map _result4 = getActivityIconsCache(_arg03);
                            reply.writeNoException();
                            reply.writeMap(_result4);
                            break;
                        case 5:
                            int _arg04 = data.readInt();
                            boolean _arg1 = data.readBoolean();
                            data.enforceNoDataAvail();
                            boolean _result5 = prohibitChildInstallation(_arg04, _arg1);
                            reply.writeNoException();
                            reply.writeBoolean(_result5);
                            break;
                        case 6:
                            String _arg05 = data.readString();
                            int _arg12 = data.readInt();
                            int _arg2 = data.readInt();
                            int _arg3 = data.readInt();
                            String _arg4 = data.readString();
                            data.enforceNoDataAvail();
                            int _result6 = oplusFreezePackage(_arg05, _arg12, _arg2, _arg3, _arg4);
                            reply.writeNoException();
                            reply.writeInt(_result6);
                            break;
                        case 7:
                            String _arg06 = data.readString();
                            int _arg13 = data.readInt();
                            int _arg22 = data.readInt();
                            int _arg32 = data.readInt();
                            String _arg42 = data.readString();
                            data.enforceNoDataAvail();
                            int _result7 = oplusUnFreezePackage(_arg06, _arg13, _arg22, _arg32, _arg42);
                            reply.writeNoException();
                            reply.writeInt(_result7);
                            break;
                        case 8:
                            String _arg07 = data.readString();
                            int _arg14 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result8 = getOplusFreezePackageState(_arg07, _arg14);
                            reply.writeNoException();
                            reply.writeInt(_result8);
                            break;
                        case 9:
                            String _arg08 = data.readString();
                            int _arg15 = data.readInt();
                            data.enforceNoDataAvail();
                            boolean _result9 = inOplusFreezePackageList(_arg08, _arg15);
                            reply.writeNoException();
                            reply.writeBoolean(_result9);
                            break;
                        case 10:
                            int _arg09 = data.readInt();
                            data.enforceNoDataAvail();
                            List<String> _result10 = getOplusFreezedPackageList(_arg09);
                            reply.writeNoException();
                            reply.writeStringList(_result10);
                            break;
                        case 11:
                            String _arg010 = data.readString();
                            int _arg16 = data.readInt();
                            data.enforceNoDataAvail();
                            int _result11 = getOplusPackageFreezeFlag(_arg010, _arg16);
                            reply.writeNoException();
                            reply.writeInt(_result11);
                            break;
                        case 12:
                            FeatureInfo[] _result12 = getOplusSystemAvailableFeatures();
                            reply.writeNoException();
                            reply.writeTypedArray(_result12, 1);
                            break;
                        case 13:
                            String _arg011 = data.readString();
                            data.enforceNoDataAvail();
                            boolean _result13 = isSecurePayApp(_arg011);
                            reply.writeNoException();
                            reply.writeBoolean(_result13);
                            break;
                        case 14:
                            String _arg012 = data.readString();
                            data.enforceNoDataAvail();
                            boolean _result14 = isSystemDataApp(_arg012);
                            reply.writeNoException();
                            reply.writeBoolean(_result14);
                            break;
                        case 15:
                            int _arg013 = data.readInt();
                            String _arg17 = data.readString();
                            List<String> _arg23 = data.createStringArrayList();
                            data.enforceNoDataAvail();
                            boolean _result15 = inPmsWhiteList(_arg013, _arg17, _arg23);
                            reply.writeNoException();
                            reply.writeBoolean(_result15);
                            break;
                        case 16:
                            break;
                        case 17:
                            break;
                        case 18:
                            List<String> _result18 = getRemovableAppList();
                            reply.writeNoException();
                            reply.writeStringList(_result18);
                            break;
                        case 19:
                            break;
                        case 20:
                            break;
                        case 21:
                            break;
                        case 22:
                            String _arg016 = data.readString();
                            IntentSender _arg18 = (IntentSender) data.readTypedObject(IntentSender.CREATOR);
                            Bundle _arg24 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                            data.enforceNoDataAvail();
                            boolean _result22 = restoreRemovableApp(_arg016, _arg18, _arg24);
                            reply.writeNoException();
                            reply.writeBoolean(_result22);
                            break;
                        case 23:
                            boolean _result23 = isSupportSessionWrite();
                            reply.writeNoException();
                            reply.writeBoolean(_result23);
                            break;
                        case 24:
                            int _arg017 = data.readInt();
                            data.enforceNoDataAvail();
                            List<String> _result24 = getCptListByType(_arg017);
                            reply.writeNoException();
                            reply.writeStringList(_result24);
                            break;
                        case 25:
                            int _arg018 = data.readInt();
                            String _arg19 = data.readString();
                            data.enforceNoDataAvail();
                            boolean _result25 = inCptWhiteList(_arg018, _arg19);
                            reply.writeNoException();
                            reply.writeBoolean(_result25);
                            break;
                        case 26:
                            String _arg019 = data.readString();
                            int _arg110 = data.readInt();
                            String _arg25 = data.readString();
                            data.enforceNoDataAvail();
                            boolean _result26 = inOplusStandardWhiteList(_arg019, _arg110, _arg25);
                            reply.writeNoException();
                            reply.writeBoolean(_result26);
                            break;
                        case 27:
                            String _arg020 = data.readString();
                            String _arg111 = data.readString();
                            ClassLoader cl = getClass().getClassLoader();
                            Map _arg26 = data.readHashMap(cl);
                            data.enforceNoDataAvail();
                            sendMapCommonDcsUpload(_arg020, _arg111, _arg26);
                            reply.writeNoException();
                            break;
                        case 28:
                            List<ApplicationInfo> _result27 = getIconPackList();
                            reply.writeNoException();
                            reply.writeTypedList(_result27);
                            break;
                        case 29:
                            break;
                        case 30:
                            String _arg022 = data.readString();
                            data.enforceNoDataAvail();
                            boolean _result28 = isDetectApp(_arg022);
                            reply.writeNoException();
                            reply.writeBoolean(_result28);
                            break;
                        case 31:
                            List<String> _result29 = getDetectAppList();
                            reply.writeNoException();
                            reply.writeStringList(_result29);
                            break;
                        case 32:
                            boolean _result30 = isCrossVersionUpdate();
                            reply.writeNoException();
                            reply.writeBoolean(_result30);
                            break;
                        case 33:
                            List<String> _result31 = getNotInstalledSystemApps();
                            reply.writeNoException();
                            reply.writeStringList(_result31);
                            break;
                        case 34:
                            List<String> _result32 = getValidAppList();
                            reply.writeNoException();
                            reply.writeStringList(_result32);
                            break;
                        case 35:
                            String _arg023 = data.readString();
                            data.enforceNoDataAvail();
                            List<String> _result33 = getAppListFromPartition(_arg023);
                            reply.writeNoException();
                            reply.writeStringList(_result33);
                            break;
                        case 36:
                            String _arg024 = data.readString();
                            int _arg112 = data.readInt();
                            int _arg27 = data.readInt();
                            int _arg33 = data.readInt();
                            int _arg43 = data.readInt();
                            IPackageDeleteObserver _arg5 = IPackageDeleteObserver.Stub.asInterface(data.readStrongBinder());
                            data.enforceNoDataAvail();
                            deletePackageDelegated(_arg024, _arg112, _arg27, _arg33, _arg43, _arg5);
                            reply.writeNoException();
                            break;
                        case 37:
                            break;
                        case 38:
                            String _arg025 = data.readString();
                            String _arg113 = data.readString();
                            data.enforceNoDataAvail();
                            boolean _result35 = setCustomizeDefaultApp(_arg025, _arg113);
                            reply.writeNoException();
                            reply.writeBoolean(_result35);
                            break;
                        case 39:
                            String _arg026 = data.readString();
                            data.enforceNoDataAvail();
                            removeCustomizeDefaultApp(_arg026);
                            reply.writeNoException();
                            break;
                        case 40:
                            String _arg027 = data.readString();
                            data.enforceNoDataAvail();
                            String _result36 = getCustomizeDefaultApp(_arg027);
                            reply.writeNoException();
                            reply.writeString(_result36);
                            break;
                        case 41:
                            String _arg028 = data.readString();
                            String _arg114 = data.readString();
                            int _arg28 = data.readInt();
                            data.enforceNoDataAvail();
                            boolean _result37 = fixupAppData(_arg028, _arg114, _arg28);
                            reply.writeNoException();
                            reply.writeBoolean(_result37);
                            break;
                        case 42:
                            boolean _arg029 = data.readBoolean();
                            String _arg115 = data.readString();
                            data.enforceNoDataAvail();
                            String _result38 = getMigMappingPkgName(_arg029, _arg115);
                            reply.writeNoException();
                            reply.writeString(_result38);
                            break;
                        case 43:
                            int _arg030 = data.readInt();
                            data.enforceNoDataAvail();
                            List<String> _result39 = getUninstallableAppConfig(_arg030);
                            reply.writeNoException();
                            reply.writeStringList(_result39);
                            break;
                        case 44:
                            int _arg031 = data.readInt();
                            String _arg116 = data.readString();
                            data.enforceNoDataAvail();
                            boolean _result40 = inUninstallableAppConfig(_arg031, _arg116);
                            reply.writeNoException();
                            reply.writeBoolean(_result40);
                            break;
                        case 45:
                            boolean _result41 = isFreezeEnabled();
                            reply.writeNoException();
                            reply.writeBoolean(_result41);
                            break;
                        case 46:
                            boolean _arg032 = data.readBoolean();
                            data.enforceNoDataAvail();
                            setFreezeEnable(_arg032);
                            reply.writeNoException();
                            break;
                        case 47:
                            String _arg033 = data.readString();
                            UserHandle _arg117 = (UserHandle) data.readTypedObject(UserHandle.CREATOR);
                            data.enforceNoDataAvail();
                            int _result42 = getPackageFreezeState(_arg033, _arg117);
                            reply.writeNoException();
                            reply.writeInt(_result42);
                            break;
                        case 48:
                            String _arg034 = data.readString();
                            UserHandle _arg118 = (UserHandle) data.readTypedObject(UserHandle.CREATOR);
                            data.enforceNoDataAvail();
                            int _result43 = getPackageFreezeUserSetting(_arg034, _arg118);
                            reply.writeNoException();
                            reply.writeInt(_result43);
                            break;
                        case 49:
                            String _arg035 = data.readString();
                            int _arg119 = data.readInt();
                            UserHandle _arg29 = (UserHandle) data.readTypedObject(UserHandle.CREATOR);
                            data.enforceNoDataAvail();
                            setPackageFreezeState(_arg035, _arg119, _arg29);
                            reply.writeNoException();
                            break;
                        case 50:
                            String _arg036 = data.readString();
                            int _arg120 = data.readInt();
                            UserHandle _arg210 = (UserHandle) data.readTypedObject(UserHandle.CREATOR);
                            data.enforceNoDataAvail();
                            setPackageFreezeUserSetting(_arg036, _arg120, _arg210);
                            reply.writeNoException();
                            break;
                        case 51:
                            UserHandle _arg037 = (UserHandle) data.readTypedObject(UserHandle.CREATOR);
                            data.enforceNoDataAvail();
                            List<String> _result44 = getFreezedApplicationList(_arg037);
                            reply.writeNoException();
                            reply.writeStringList(_result44);
                            break;
                        case 52:
                            UserHandle _arg038 = (UserHandle) data.readTypedObject(UserHandle.CREATOR);
                            data.enforceNoDataAvail();
                            List<String> _result45 = getUserSettingFreezeableApplicationList(_arg038);
                            reply.writeNoException();
                            reply.writeStringList(_result45);
                            break;
                        case 53:
                            String _arg039 = data.readString();
                            int _arg121 = data.readInt();
                            data.enforceNoDataAvail();
                            boolean _result46 = hasFeatureIPC(_arg039, _arg121);
                            reply.writeNoException();
                            reply.writeBoolean(_result46);
                            break;
                        case 54:
                            String _arg040 = data.readString();
                            data.enforceNoDataAvail();
                            boolean _result47 = enableFeature(_arg040);
                            reply.writeNoException();
                            reply.writeBoolean(_result47);
                            break;
                        case 55:
                            String _arg041 = data.readString();
                            data.enforceNoDataAvail();
                            boolean _result48 = disableFeature(_arg041);
                            reply.writeNoException();
                            reply.writeBoolean(_result48);
                            break;
                        case 56:
                            String _arg042 = data.readString();
                            int _arg122 = data.readInt();
                            data.enforceNoDataAvail();
                            boolean _result49 = enableFeatureMap(_arg042, _arg122);
                            reply.writeNoException();
                            reply.writeBoolean(_result49);
                            break;
                        case 57:
                            String _arg043 = data.readString();
                            int _arg123 = data.readInt();
                            data.enforceNoDataAvail();
                            boolean _result50 = disableFeatureMap(_arg043, _arg123);
                            reply.writeNoException();
                            reply.writeBoolean(_result50);
                            break;
                        case 58:
                            String _arg044 = data.readString();
                            String _arg124 = data.readString();
                            data.enforceNoDataAvail();
                            notifyFeaturesUpdate(_arg044, _arg124);
                            reply.writeNoException();
                            break;
                        case 59:
                            String _arg045 = data.readString();
                            String _arg125 = data.readString();
                            int _arg211 = data.readInt();
                            data.enforceNoDataAvail();
                            notifyFeaturesMapUpdate(_arg045, _arg125, _arg211);
                            reply.writeNoException();
                            break;
                        case 60:
                            break;
                        case 61:
                            break;
                        case 62:
                            break;
                        case 63:
                            break;
                        case 64:
                            break;
                        case 65:
                            break;
                        case 66:
                            int _arg052 = data.readInt();
                            Bundle _arg129 = (Bundle) data.readTypedObject(Bundle.CREATOR);
                            data.enforceNoDataAvail();
                            Bundle _result57 = appDetailsForwardToMarket(_arg052, _arg129);
                            reply.writeNoException();
                            reply.writeTypedObject(_result57, 1);
                            break;
                        case 67:
                            String _arg053 = data.readString();
                            data.enforceNoDataAvail();
                            boolean _result58 = markResolveIntentForMarket(_arg053);
                            reply.writeNoException();
                            reply.writeBoolean(_result58);
                            break;
                        case 68:
                            String _arg054 = data.readString();
                            data.enforceNoDataAvail();
                            int _result59 = getAbiCheckResult(_arg054);
                            reply.writeNoException();
                            reply.writeInt(_result59);
                            break;
                        case 69:
                            List<String> _result60 = queryIncompatibleApplist();
                            reply.writeNoException();
                            reply.writeStringList(_result60);
                            break;
                        default:
                            return super.onTransact(code, data, reply, flags);
                    }
                    return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IOplusPackageManager {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IOplusPackageManager.DESCRIPTOR;
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean isClosedSuperFirewall() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public Bitmap getAppIconBitmap(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    Bitmap _result = (Bitmap) _reply.readTypedObject(Bitmap.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public Map getAppIconsCache(boolean compress) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeBoolean(compress);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    ClassLoader cl = getClass().getClassLoader();
                    Map _result = _reply.readHashMap(cl);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public Map getActivityIconsCache(IPackageDeleteObserver observer) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeStrongInterface(observer);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    ClassLoader cl = getClass().getClassLoader();
                    Map _result = _reply.readHashMap(cl);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean prohibitChildInstallation(int userId, boolean isInstall) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeInt(userId);
                    _data.writeBoolean(isInstall);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public int oplusFreezePackage(String pkgName, int userId, int freezeFlag, int flag, String callingPkg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(userId);
                    _data.writeInt(freezeFlag);
                    _data.writeInt(flag);
                    _data.writeString(callingPkg);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public int oplusUnFreezePackage(String pkgName, int userId, int freezeFlag, int flag, String callingPkg) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(userId);
                    _data.writeInt(freezeFlag);
                    _data.writeInt(flag);
                    _data.writeString(callingPkg);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public int getOplusFreezePackageState(String pkgName, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(userId);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean inOplusFreezePackageList(String pkgName, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(userId);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getOplusFreezedPackageList(int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeInt(userId);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public int getOplusPackageFreezeFlag(String pkgName, int userId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeInt(userId);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public FeatureInfo[] getOplusSystemAvailableFeatures() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    FeatureInfo[] _result = (FeatureInfo[]) _reply.createTypedArray(FeatureInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean isSecurePayApp(String name) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(name);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean isSystemDataApp(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean inPmsWhiteList(int type, String verifyStr, List<String> defaultList) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(verifyStr);
                    _data.writeStringList(defaultList);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getRemovableAppList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean restoreRemovableApp(String packageName, IntentSender sender, Bundle bundle) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeTypedObject(sender, 0);
                    _data.writeTypedObject(bundle, 0);
                    this.mRemote.transact(22, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean isSupportSessionWrite() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(23, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getCptListByType(int tag) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeInt(tag);
                    this.mRemote.transact(24, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean inCptWhiteList(int type, String verifyStr) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(verifyStr);
                    this.mRemote.transact(25, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean inOplusStandardWhiteList(String filterName, int type, String verifyStr) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(filterName);
                    _data.writeInt(type);
                    _data.writeString(verifyStr);
                    this.mRemote.transact(26, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void sendMapCommonDcsUpload(String logTag, String eventId, Map map) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(logTag);
                    _data.writeString(eventId);
                    _data.writeMap(map);
                    this.mRemote.transact(27, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<ApplicationInfo> getIconPackList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(28, _data, _reply, 0);
                    _reply.readException();
                    List<ApplicationInfo> _result = _reply.createTypedArrayList(ApplicationInfo.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean isDetectApp(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(30, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getDetectAppList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(31, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean isCrossVersionUpdate() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(32, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getNotInstalledSystemApps() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(33, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getValidAppList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(34, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getAppListFromPartition(String partition) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(partition);
                    this.mRemote.transact(35, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void deletePackageDelegated(String packageName, int callUid, int callPid, int flags, int userId, IPackageDeleteObserver observer) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    _data.writeInt(callUid);
                    _data.writeInt(callPid);
                    _data.writeInt(flags);
                    _data.writeInt(userId);
                    _data.writeStrongInterface(observer);
                    this.mRemote.transact(36, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean setCustomizeDefaultApp(String roleName, String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(roleName);
                    _data.writeString(packageName);
                    this.mRemote.transact(38, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void removeCustomizeDefaultApp(String roleName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(roleName);
                    this.mRemote.transact(39, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public String getCustomizeDefaultApp(String roleName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(roleName);
                    this.mRemote.transact(40, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean fixupAppData(String pkgName, String relativePath, int flags) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(pkgName);
                    _data.writeString(relativePath);
                    _data.writeInt(flags);
                    this.mRemote.transact(41, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public String getMigMappingPkgName(boolean findOldNameByNew, String refPkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeBoolean(findOldNameByNew);
                    _data.writeString(refPkgName);
                    this.mRemote.transact(42, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getUninstallableAppConfig(int type) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeInt(type);
                    this.mRemote.transact(43, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean inUninstallableAppConfig(int type, String pkgName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeString(pkgName);
                    this.mRemote.transact(44, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean isFreezeEnabled() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(45, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void setFreezeEnable(boolean enabled) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeBoolean(enabled);
                    this.mRemote.transact(46, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public int getPackageFreezeState(String pkg, UserHandle userHandle) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeTypedObject(userHandle, 0);
                    this.mRemote.transact(47, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public int getPackageFreezeUserSetting(String pkg, UserHandle userHandle) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeTypedObject(userHandle, 0);
                    this.mRemote.transact(48, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void setPackageFreezeState(String pkg, int state, UserHandle userHandle) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeInt(state);
                    _data.writeTypedObject(userHandle, 0);
                    this.mRemote.transact(49, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void setPackageFreezeUserSetting(String pkg, int setting, UserHandle userHandle) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(pkg);
                    _data.writeInt(setting);
                    _data.writeTypedObject(userHandle, 0);
                    this.mRemote.transact(50, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getFreezedApplicationList(UserHandle userHandle) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeTypedObject(userHandle, 0);
                    this.mRemote.transact(51, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> getUserSettingFreezeableApplicationList(UserHandle userHandle) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeTypedObject(userHandle, 0);
                    this.mRemote.transact(52, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean hasFeatureIPC(String featureName, int featureID) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(featureName);
                    _data.writeInt(featureID);
                    this.mRemote.transact(53, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean enableFeature(String featureName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(featureName);
                    this.mRemote.transact(54, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean disableFeature(String featureName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(featureName);
                    this.mRemote.transact(55, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean enableFeatureMap(String featureName, int featureID) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(featureName);
                    _data.writeInt(featureID);
                    this.mRemote.transact(56, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean disableFeatureMap(String featureName, int featureID) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(featureName);
                    _data.writeInt(featureID);
                    this.mRemote.transact(57, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void notifyFeaturesUpdate(String action, String actionValue) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(action);
                    _data.writeString(actionValue);
                    this.mRemote.transact(58, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public void notifyFeaturesMapUpdate(String action, String actionValue, int featureID) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(action);
                    _data.writeString(actionValue);
                    _data.writeInt(featureID);
                    this.mRemote.transact(59, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public Bundle appDetailsForwardToMarket(int type, Bundle bundle) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeInt(type);
                    _data.writeTypedObject(bundle, 0);
                    this.mRemote.transact(66, _data, _reply, 0);
                    _reply.readException();
                    Bundle _result = (Bundle) _reply.readTypedObject(Bundle.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public boolean markResolveIntentForMarket(String token) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(token);
                    this.mRemote.transact(67, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readBoolean();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public int getAbiCheckResult(String packageName) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    _data.writeString(packageName);
                    this.mRemote.transact(68, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.content.pm.IOplusPackageManager
            public List<String> queryIncompatibleApplist() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(IOplusPackageManager.DESCRIPTOR);
                    this.mRemote.transact(69, _data, _reply, 0);
                    _reply.readException();
                    List<String> _result = _reply.createStringArrayList();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        @Override // android.os.Binder
        public int getMaxTransactionId() {
            return 68;
        }
    }
}
