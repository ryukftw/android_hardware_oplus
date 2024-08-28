package android.hardware.camera2;

import android.common.IOplusCommonFeature;
import android.common.OplusFeatureList;
import android.content.Context;
import android.os.IBinder;

public interface IOplusCameraManager extends IOplusCommonFeature {
    public static final IOplusCameraManager DEFAULT = new IOplusCameraManager() {
    };
    public static final String NAME = "IOplusCameraManager";

    @Override
    default OplusFeatureList.OplusIndex index() {
        return OplusFeatureList.OplusIndex.IOplusCameraManager;
    }

    @Override
    default IOplusCommonFeature getDefault() {
        return DEFAULT;
    }

    default void addAuthResultInfo(Context context, int uid, int pid, int permBits, String packageName) {
    }

    default void setDeathRecipient(IBinder client) {
    }

    default boolean isAuthedClient(Context context) {
        return false;
    }

    default void setCallInfo() {
    }

    default void saveOpPackageName(String packageName) {
    }

    default void setPackageName() {
    }

    default boolean isPrivilegedApp(String packageName) {
        return false;
    }

    default boolean isCameraUnitSession() {
        return false;
    }

    default void parseSessionParameters(CaptureRequest sessionParams) {
    }
}
