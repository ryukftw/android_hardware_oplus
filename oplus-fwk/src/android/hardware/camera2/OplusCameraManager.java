package android.hardware.camera2;

import android.content.Context;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.impl.CameraMetadataNative;
import android.media.Image;
import android.media.ImageReader;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class OplusCameraManager implements IOplusCameraManager {
    private static final String TAG = "OplusCameraManager";
    private static final CaptureRequest.Key<byte[]> KEY_OPLUS_PACKAGE = new CaptureRequest.Key<>("com.oplus.is.sdk.camera.package", byte[].class);
    private static OplusCameraManager mInstance = new OplusCameraManager();
    private String mOpPackageName = "";
    private boolean mIsCameraUnitSession = false;
    private boolean mbLoad = false;

    public native int nativeSendToAttachHWBufToBufQEvent(long j);

    public native int nativeSendToBufQAllocEnableEvent(long j);

    public native int nativeSendToExchgHWBufBtwBufQEvent(long j);

    public native void nativtSendToProcessHeif(long j);

    private OplusCameraManager() {
    }

    private void checkLoadLibrary() {
        Log.i(TAG, "checkLoadHeifLibbrary, mbLoad: " + this.mbLoad);
        if (this.mbLoad) {
            return;
        }
        try {
            System.loadLibrary("HeifWinBufExchg-jni");
            this.mbLoad = true;
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "checkLoadHeifLibbrary, error");
        }
    }

    public void sendToProcessHeif(long ptr) {
        checkLoadLibrary();
        nativtSendToProcessHeif(ptr);
    }

    public int sendToBufQAllocEnableEvent(long ptr) {
        checkLoadLibrary();
        return nativeSendToBufQAllocEnableEvent(ptr);
    }

    public int sendToExchgHWBufBtwBufQEvent(long ptr) {
        checkLoadLibrary();
        return nativeSendToExchgHWBufBtwBufQEvent(ptr);
    }

    public int sendToAttachHWBufToBufQEvent(long ptr) {
        checkLoadLibrary();
        return nativeSendToAttachHWBufToBufQEvent(ptr);
    }

    public static synchronized OplusCameraManager getInstance() {
        OplusCameraManager oplusCameraManager;
        synchronized (OplusCameraManager.class) {
            oplusCameraManager = mInstance;
        }
        return oplusCameraManager;
    }

    public static Object getEmptyCameraMetadataNative(long[] metadataPtr) {
        CameraMetadataNative meta = new CameraMetadataNative();
        if (metadataPtr != null && metadataPtr.length > 0) {
            metadataPtr[0] = meta.getMetadataPtr();
        }
        return meta;
    }

    public static TotalCaptureResult generateTotalCaptureResult(Object meta, long frameId) {
        if (meta == null || !(meta instanceof CameraMetadataNative)) {
            return null;
        }
        TotalCaptureResult r = new TotalCaptureResult((CameraMetadataNative) meta, 0);
        try {
            Field numField = CaptureResult.class.getDeclaredField("mFrameNumber");
            numField.setAccessible(true);
            numField.setLong(r, frameId);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public void addAuthResultInfo(Context context, int uid, int pid, int permBits, String packageName) {
        context.enforceCallingOrSelfPermission("com.oplus.permission.safe.CAMERA", TAG);
        if (uid == 0) {
            throw new IllegalArgumentException("uid was 0, which is illegal.");
        }
        if (pid == 0) {
            throw new IllegalArgumentException("pid was 0, which is illegal.");
        }
        if (packageName == null) {
            throw new IllegalArgumentException("packageName was null, which is illegal.");
        }
        try {
            OplusCameraManagerGlobal.get().addAuthResultInfo(uid, pid, permBits, packageName);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public void setDeathRecipient(IBinder client) {
        if (client == null) {
            throw new IllegalArgumentException("client was null");
        }
        try {
            OplusCameraManagerGlobal.get().setDeathRecipient(client);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public boolean isAuthedClient(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context was null");
        }
        try {
            return OplusCameraManagerGlobal.get().isAuthedClient(context.getOpPackageName());
        } catch (CameraAccessException e) {
            e.printStackTrace();
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override
    public void setCallInfo() {
        try {
            OplusCameraManagerGlobal.get().setCallInfo();
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override
    public void saveOpPackageName(String packageName) {
        this.mOpPackageName = packageName;
        Log.i(TAG, "saveOpPackageName, mOpPackageName: " + this.mOpPackageName);
    }

    @Override // android.hardware.camera2.IOplusCameraManager
    public void setPackageName() {
        try {
            OplusCameraManagerGlobal.get().setClientInfo(this.mOpPackageName, Binder.getCallingUid(), Binder.getCallingPid());
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public void setRIOClientInfo() throws CameraAccessException {
        Log.i(TAG, "uid = " + Binder.getCallingUid() + ", pid = " + Binder.getCallingPid());
        try {
            OplusCameraManagerGlobal.get().setRIOClientInfo(Binder.getCallingUid(), Binder.getCallingPid());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isPrivilegedApp(String packageName) {
        return true;
    }

    public void setTorchIntensity(int torchIntensity) {
        if (torchIntensity < 0) {
            throw new IllegalArgumentException("torchIntensity was less than 0, which is illegal.");
        }
        try {
            OplusCameraManagerGlobal.get().setTorchIntensity(torchIntensity);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public void disconnectClients() {
        try {
            OplusCameraManagerGlobal.get().disconnectClients();
        } catch (CameraAccessException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public boolean isClientConnected() {
        try {
            return OplusCameraManagerGlobal.get().isClientConnected();
        } catch (CameraAccessException e) {
            e.printStackTrace();
            return false;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isCameraUnitSession() {
        return this.mIsCameraUnitSession;
    }

    @Override
    public void parseSessionParameters(CaptureRequest sessionParams) {
        if (sessionParams == null) {
            this.mIsCameraUnitSession = false;
            return;
        }
        byte[] result = (byte[]) sessionParams.get(KEY_OPLUS_PACKAGE);
        if (result == null || result.length == 0) {
            this.mIsCameraUnitSession = false;
            return;
        }
        if (1 == result[0]) {
            this.mIsCameraUnitSession = true;
        }
        Log.i(TAG, "parseSessionParameters mIsCameraUnitSession: " + this.mIsCameraUnitSession);
    }

    public void oplusDetachImage(Image image, ImageReader imgreader) {
        try {
            Method method = ImageReader.class.getDeclaredMethod("detachImage", Image.class);
            method.setAccessible(true);
            method.invoke(imgreader, image);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        Log.i(TAG, "using reflection to visit detachImage method in ImageReader");
    }

    public static void setOmojiJson(String jsonInfo) {
        Log.i(TAG, "setOmojiJson called.");
        if (jsonInfo == null || "".equals(jsonInfo)) {
            Log.i(TAG, "jsonInfo is null");
            return;
        }
        try {
            OplusCameraManagerGlobal.get().setOmojiJson(jsonInfo);
        } catch (CameraAccessException e) {
            Log.i(TAG, "setOmojiJson :" + e.getMessage());
        } catch (RemoteException e2) {
            Log.i(TAG, "setOmojiJson :" + e2.getMessage());
        }
    }

    /* loaded from: classes.dex */
    private static final class OplusCameraManagerGlobal implements IBinder.DeathRecipient {
        private static final int ADD_AUTH_RESULT = 10001;
        private static final String CAMERA_SERVICE_BINDER_NAME = "media.camera";
        private static final int CLIENT_IS_AUTHED = 10004;
        private static final int CONNECT_STATUS = 10011;
        private static final String DESCRIPTOR = "android.hardware.camera";
        private static final int DISCONNECT_CLIENTS = 10009;
        private static final int OPLUS_CAMERA_FIRST_CALL_TRANSACTION = 10000;
        private static final int SET_CALL_INFO = 10006;
        private static final int SET_CLIENT_INFO = 10005;
        private static final int SET_DEATH_RECIPIENT = 10002;
        private static final int SET_OMOJI_JSON = 10010;
        private static final int SET_PACKAGE_NAME = 10003;
        private static final int SET_RIO_CLIENT_INFO = 10007;
        private static final int SET_TORCH_INTENSITY = 10008;
        private static final String TAG = "OplusCameraManagerGlobal";
        private static final OplusCameraManagerGlobal gCameraManager = new OplusCameraManagerGlobal();
        public static final boolean sCameraServiceDisabled = SystemProperties.getBoolean("config.disable_cameraservice", false);
        private final boolean DEBUG = false;
        private final Object mLock = new Object();
        private IBinder mRemote = null;

        private OplusCameraManagerGlobal() {
        }

        public static OplusCameraManagerGlobal get() {
            return gCameraManager;
        }

        private void connectCameraServiceLocked() {
            if (this.mRemote != null || sCameraServiceDisabled) {
                return;
            }
            Log.i(TAG, "Connecting to camera service");
            IBinder service = ServiceManager.getService(CAMERA_SERVICE_BINDER_NAME);
            this.mRemote = service;
            if (service == null) {
                return;
            }
            try {
                service.linkToDeath(this, 0);
            } catch (RemoteException e) {
            }
        }

        public IBinder getCameraServiceRemote() {
            IBinder iBinder;
            synchronized (this.mLock) {
                connectCameraServiceLocked();
                if (this.mRemote == null && !sCameraServiceDisabled) {
                    Log.e(TAG, "Camera service is unavailable");
                }
                iBinder = this.mRemote;
            }
            return iBinder;
        }

        public void addAuthResultInfo(int uid, int pid, int permBits, String packageName) throws CameraAccessException, RemoteException {
            Log.e(TAG, "addAuthResultInfo");
            IBinder remote = getCameraServiceRemote();
            if (remote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken("android.hardware.camera");
                data.writeInt(uid);
                data.writeInt(pid);
                data.writeInt(permBits);
                data.writeString(packageName);
                this.mRemote.transact(10001, data, reply, 0);
                reply.readException();
            } finally {
                data.recycle();
                reply.recycle();
            }
        }

        public void setDeathRecipient(IBinder client) throws CameraAccessException, RemoteException {
            Log.e(TAG, "setDeathRecipient");
            IBinder remote = getCameraServiceRemote();
            if (remote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken("android.hardware.camera");
                data.writeStrongBinder(client);
                this.mRemote.transact(10002, data, reply, 0);
                reply.readException();
            } finally {
                data.recycle();
                reply.recycle();
            }
        }

        public boolean isAuthedClient(String packageName) throws CameraAccessException, RemoteException {
            Log.e(TAG, "isAuthedClient, need check packageName: " + packageName);
            IBinder remote = getCameraServiceRemote();
            if (remote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken("android.hardware.camera");
                data.writeString(packageName);
                this.mRemote.transact(10004, data, reply, 0);
                reply.readException();
                boolean isAuthed = reply.readBoolean();
                data.recycle();
                reply.recycle();
                Log.e(TAG, "isAuthedClient, the " + packageName + " is Authed " + isAuthed);
                return isAuthed;
            } catch (Throwable th) {
                data.recycle();
                reply.recycle();
                throw th;
            }
        }

        public void setCallInfo() throws CameraAccessException, RemoteException {
            Log.e(TAG, "setCallInfo");
            IBinder remote = getCameraServiceRemote();
            if (remote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken("android.hardware.camera");
                this.mRemote.transact(10006, data, reply, 0);
                reply.readException();
            } finally {
                data.recycle();
                reply.recycle();
            }
        }

        public void setPackageName(String packageName) throws CameraAccessException, RemoteException {
            Log.i(TAG, "setPackageName");
            IBinder remote = getCameraServiceRemote();
            if (remote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken("android.hardware.camera");
                data.writeString(packageName);
                remote.transact(10003, data, reply, 0);
                reply.readException();
            } finally {
                data.recycle();
                reply.recycle();
            }
        }

        public void setClientInfo(String packageName, int uid, int pid) throws CameraAccessException, RemoteException {
            Log.i(TAG, "setClientInfo, packageName: " + packageName + ", uid: " + uid + ", pid: " + pid);
            IBinder remote = getCameraServiceRemote();
            if (remote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken("android.hardware.camera");
                data.writeString(packageName);
                data.writeInt(uid);
                data.writeInt(pid);
                remote.transact(10005, data, reply, 0);
                reply.readException();
            } finally {
                data.recycle();
                reply.recycle();
            }
        }

        public void setRIOClientInfo(int uid, int pid) throws CameraAccessException, RemoteException {
            Log.i(TAG, "uid: " + uid + ", pid: " + pid);
            IBinder remote = getCameraServiceRemote();
            if (remote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken("android.hardware.camera");
                data.writeInt(uid);
                data.writeInt(pid);
                remote.transact(10007, data, reply, 0);
                reply.readException();
            } finally {
                data.recycle();
                reply.recycle();
            }
        }

        public void setOmojiJson(String atavatarInfo) throws CameraAccessException, RemoteException {
            Log.i(TAG, "setOmojiJson E");
            IBinder remote = getCameraServiceRemote();
            if (remote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken("android.hardware.camera");
                data.writeString(atavatarInfo);
                Log.i(TAG, "setOmojiJson process E");
                this.mRemote.transact(10010, data, reply, 0);
                Log.i(TAG, "setOmojiJson process X");
                reply.readException();
                data.recycle();
                reply.recycle();
                Log.i(TAG, "setOmojiJson X");
            } catch (Throwable th) {
                data.recycle();
                reply.recycle();
                throw th;
            }
        }

        public void setTorchIntensity(int torchIntensity) throws CameraAccessException, RemoteException {
            Log.d(TAG, "setTorchIntensity: " + torchIntensity);
            IBinder remote = getCameraServiceRemote();
            if (remote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken("android.hardware.camera");
                data.writeInt(torchIntensity);
                remote.transact(10008, data, reply, 0);
                reply.readException();
            } finally {
                data.recycle();
                reply.recycle();
            }
        }

        public void disconnectClients() throws CameraAccessException, RemoteException {
            Log.e(TAG, "disconnectClients");
            IBinder remote = getCameraServiceRemote();
            if (remote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken("android.hardware.camera");
                this.mRemote.transact(10009, data, reply, 0);
                reply.readException();
            } finally {
                data.recycle();
                reply.recycle();
            }
        }

        public boolean isClientConnected() throws CameraAccessException, RemoteException {
            Log.e(TAG, "isClientConnected");
            IBinder remote = getCameraServiceRemote();
            if (remote == null) {
                throw new CameraAccessException(2, "Camera service is currently unavailable");
            }
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            try {
                data.writeInterfaceToken("android.hardware.camera");
                this.mRemote.transact(10011, data, reply, 0);
                reply.readException();
                boolean isConnected = reply.readBoolean();
                data.recycle();
                reply.recycle();
                Log.e(TAG, "isClientConnected: " + isConnected);
                return isConnected;
            } catch (Throwable th) {
                data.recycle();
                reply.recycle();
                throw th;
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            this.mRemote = null;
        }
    }
}
