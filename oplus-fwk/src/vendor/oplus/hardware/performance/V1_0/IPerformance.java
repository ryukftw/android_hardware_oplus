package vendor.oplus.hardware.performance.V1_0;

import android.internal.hidl.base.V1_0.DebugInfo;
import android.internal.hidl.base.V1_0.IBase;
import android.os.HidlSupport;
import android.os.HwBinder;
import android.os.HwBlob;
import android.os.HwParcel;
import android.os.IHwBinder;
import android.os.IHwInterface;
import android.os.NativeHandle;
import android.os.RemoteException;
import com.android.internal.midi.MidiConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
public interface IPerformance extends IBase {
    public static final String kInterfaceName = "vendor.oplus.hardware.performance@1.0::IPerformance";

    int addAcmDirName(String str, long j) throws RemoteException;

    int addAcmNomediaDirName(String str) throws RemoteException;

    int addAcmPkgName(String str, long j) throws RemoteException;

    @Override // android.internal.hidl.base.V1_0.IBase, android.os.IHwInterface
    IHwBinder asBinder();

    @Override // android.internal.hidl.base.V1_0.IBase
    void debug(NativeHandle nativeHandle, ArrayList<String> arrayList) throws RemoteException;

    int delAcmDirName(String str) throws RemoteException;

    int delAcmNomediaDirName(String str) throws RemoteException;

    int delAcmPkgName(String str) throws RemoteException;

    int disableKmallocDebug() throws RemoteException;

    int disableMultiThreadOptimize() throws RemoteException;

    int disableProcessReclaim() throws RemoteException;

    int disableTaskCpustats() throws RemoteException;

    int disableTaskPlacementDecision() throws RemoteException;

    int disableVmallocDebug() throws RemoteException;

    int enableKmallocDebug() throws RemoteException;

    int enableMultiThreadOptimize() throws RemoteException;

    int enableProcessReclaim() throws RemoteException;

    int enableTaskCpustats() throws RemoteException;

    int enableTaskPlacementDecision() throws RemoteException;

    int enableVmallocDebug() throws RemoteException;

    int existMemMonitor() throws RemoteException;

    long getAcmDirFlag(String str) throws RemoteException;

    int getAcmOpstat() throws RemoteException;

    long getAcmPkgFlag(String str) throws RemoteException;

    @Override // android.internal.hidl.base.V1_0.IBase
    DebugInfo getDebugInfo() throws RemoteException;

    String getExt4FragScore(String str) throws RemoteException;

    String getExt4FreefragInfo(String str) throws RemoteException;

    String getF2fsMovedBlks() throws RemoteException;

    ProcReqHal getHIAllocWait() throws RemoteException;

    String getHICpuInfo() throws RemoteException;

    String getHICpuLoading() throws RemoteException;

    ProcReqHal getHIDState() throws RemoteException;

    ProcReqHal getHIEmcdrvIowait() throws RemoteException;

    ProcReqHal getHIFsyncWait() throws RemoteException;

    ProcReqHal getHIIonWait() throws RemoteException;

    ProcReqHal getHIIowait() throws RemoteException;

    ProcReqHal getHIIowaitHung() throws RemoteException;

    ProcReqHal getHIKswapdLoading() throws RemoteException;

    ProcReqHal getHISchedLatency() throws RemoteException;

    ProcReqHal getHIScmCall() throws RemoteException;

    ProcReqHal getHIUfsFeature() throws RemoteException;

    @Override // android.internal.hidl.base.V1_0.IBase
    ArrayList<byte[]> getHashChain() throws RemoteException;

    int getKernelVersion() throws RemoteException;

    String getKmallocDebug() throws RemoteException;

    String getKmallocOrigin() throws RemoteException;

    String getKmallocUsed() throws RemoteException;

    String getMemMonitor() throws RemoteException;

    int getOswapVersion() throws RemoteException;

    String getVmallocDebug() throws RemoteException;

    String getVmallocHashCal() throws RemoteException;

    String getVmallocUsed() throws RemoteException;

    String getallocwait() throws RemoteException;

    String getdstate() throws RemoteException;

    String getfsyncwait() throws RemoteException;

    String getionwait() throws RemoteException;

    String getiowait() throws RemoteException;

    String getschedlatency() throws RemoteException;

    String hybridswap_memcg_para_read(int i, String str) throws RemoteException;

    int hybridswap_memcg_para_write(int i, String str, String str2) throws RemoteException;

    String hybridswap_zram_para_read(int i) throws RemoteException;

    int hybridswap_zram_para_write(int i, String str) throws RemoteException;

    @Override // android.internal.hidl.base.V1_0.IBase
    ArrayList<String> interfaceChain() throws RemoteException;

    @Override // android.internal.hidl.base.V1_0.IBase
    String interfaceDescriptor() throws RemoteException;

    @Override // android.internal.hidl.base.V1_0.IBase
    boolean linkToDeath(IHwBinder.DeathRecipient deathRecipient, long j) throws RemoteException;

    @Override // android.internal.hidl.base.V1_0.IBase
    void notifySyspropsChanged() throws RemoteException;

    int perProcessMemReadahead(int i, int i2, int i3) throws RemoteException;

    int perProcessMemReclaim(int i, int i2, int i3) throws RemoteException;

    @Override // android.internal.hidl.base.V1_0.IBase
    void ping() throws RemoteException;

    String readCpuTaskstats() throws RemoteException;

    String readDConvert() throws RemoteException;

    String readIomonitorInfo(String str) throws RemoteException;

    String readKmallocDebugCreate() throws RemoteException;

    String readMemleakDetectThread() throws RemoteException;

    String readNandswapProc(String str) throws RemoteException;

    String readNormalizeRealTime() throws RemoteException;

    String readNormalizeRunningTime() throws RemoteException;

    String readPidsSet() throws RemoteException;

    String readRealTime() throws RemoteException;

    String readRunningTime() throws RemoteException;

    String readSchedInfoThreshold() throws RemoteException;

    String readSgeFreqInfo() throws RemoteException;

    String readSgeInfo() throws RemoteException;

    String readTargetProcess(String str) throws RemoteException;

    String readTaskCpustatsEnable() throws RemoteException;

    String readTaskSchedInfo() throws RemoteException;

    String readVaFeature() throws RemoteException;

    int searchAcmNomediaDirName(String str) throws RemoteException;

    int setAcmOpstat(int i) throws RemoteException;

    void setFgUids(String str) throws RemoteException;

    void setFrameRate(String str) throws RemoteException;

    @Override // android.internal.hidl.base.V1_0.IBase
    void setHALInstrumentation() throws RemoteException;

    void setImFlag(String str, String str2) throws RemoteException;

    int setProcessReclaim(String str) throws RemoteException;

    void setSchedAssistImptTask(String str) throws RemoteException;

    void setSchedAssistScene(String str) throws RemoteException;

    void setSlideboost(String str) throws RemoteException;

    int setTpdID(String str) throws RemoteException;

    int setTpdSerialParams(String str) throws RemoteException;

    @Override // android.internal.hidl.base.V1_0.IBase
    boolean unlinkToDeath(IHwBinder.DeathRecipient deathRecipient) throws RemoteException;

    int writeKmallocDebugCreate(int i) throws RemoteException;

    int writeKmallocDebugCreateWithType(String str) throws RemoteException;

    int writeMemMonitor(String str) throws RemoteException;

    int writeMemleakDetectThread(int i) throws RemoteException;

    int writeMonitorStatus(String str) throws RemoteException;

    int writeNandswapProc(String str, String str2) throws RemoteException;

    void writePidsSet(String str) throws RemoteException;

    void writeSchedInfoThreshold(String str) throws RemoteException;

    void writeTaskSchedInfo(String str) throws RemoteException;

    int writeUxState(String str, String str2, String str3) throws RemoteException;

    int writeVaFeature(int i) throws RemoteException;

    static IPerformance asInterface(IHwBinder binder) {
        if (binder == null) {
            return null;
        }
        IHwInterface iface = binder.queryLocalInterface(kInterfaceName);
        if (iface != null && (iface instanceof IPerformance)) {
            return (IPerformance) iface;
        }
        IPerformance proxy = new Proxy(binder);
        try {
            Iterator<String> it = proxy.interfaceChain().iterator();
            while (it.hasNext()) {
                String descriptor = it.next();
                if (descriptor.equals(kInterfaceName)) {
                    return proxy;
                }
            }
        } catch (RemoteException e) {
        }
        return null;
    }

    static IPerformance castFrom(IHwInterface iface) {
        if (iface == null) {
            return null;
        }
        return asInterface(iface.asBinder());
    }

    static IPerformance getService(String serviceName, boolean retry) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName, retry));
    }

    static IPerformance getService(boolean retry) throws RemoteException {
        return getService("default", retry);
    }

    @Deprecated
    static IPerformance getService(String serviceName) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName));
    }

    @Deprecated
    static IPerformance getService() throws RemoteException {
        return getService("default");
    }

    /* loaded from: classes4.dex */
    public static final class Proxy implements IPerformance {
        private IHwBinder mRemote;

        public Proxy(IHwBinder remote) {
            Objects.requireNonNull(remote);
            this.mRemote = remote;
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase, android.os.IHwInterface
        public IHwBinder asBinder() {
            return this.mRemote;
        }

        public String toString() {
            try {
                return interfaceDescriptor() + "@Proxy";
            } catch (RemoteException e) {
                return "[class or subclass of vendor.oplus.hardware.performance@1.0::IPerformance]@Proxy";
            }
        }

        public final boolean equals(Object other) {
            return HidlSupport.interfacesEqual(this, other);
        }

        public final int hashCode() {
            return asBinder().hashCode();
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int enableMultiThreadOptimize() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(1, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int disableMultiThreadOptimize() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(2, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int enableTaskCpustats() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(3, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int disableTaskCpustats() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(4, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int enableKmallocDebug() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(5, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int disableKmallocDebug() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(6, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int enableVmallocDebug() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(7, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int disableVmallocDebug() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(8, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int enableProcessReclaim() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(9, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int disableProcessReclaim() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(10, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getKmallocDebug() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(11, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_info = _hidl_reply.readString();
                return _hidl_out_info;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getKmallocOrigin() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(12, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_info = _hidl_reply.readString();
                return _hidl_out_info;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getKmallocUsed() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(13, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_info = _hidl_reply.readString();
                return _hidl_out_info;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int existMemMonitor() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(14, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int writeMemleakDetectThread(int memdect) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeInt32(memdect);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(15, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readMemleakDetectThread() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(16, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getschedlatency() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(17, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getiowait() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(18, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getfsyncwait() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(19, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getionwait() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(20, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getallocwait() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(21, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getdstate() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(22, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int writeVaFeature(int vafeature) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeInt32(vafeature);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(23, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readVaFeature() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(24, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int writeKmallocDebugCreate(int kcreate) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeInt32(kcreate);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(25, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int writeKmallocDebugCreateWithType(String type) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(type);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(26, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readKmallocDebugCreate() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(27, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getVmallocDebug() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(28, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_info = _hidl_reply.readString();
                return _hidl_out_info;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getVmallocUsed() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(29, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_info = _hidl_reply.readString();
                return _hidl_out_info;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getVmallocHashCal() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(30, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_info = _hidl_reply.readString();
                return _hidl_out_info;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readCpuTaskstats() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(31, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readSgeInfo() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(32, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readIomonitorInfo(String procname) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(procname);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(33, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getHICpuLoading() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(34, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public ProcReqHal getHIEmcdrvIowait() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(35, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ProcReqHal _hidl_out_items = new ProcReqHal();
                _hidl_out_items.readFromParcel(_hidl_reply);
                return _hidl_out_items;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public ProcReqHal getHIIowaitHung() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(36, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ProcReqHal _hidl_out_items = new ProcReqHal();
                _hidl_out_items.readFromParcel(_hidl_reply);
                return _hidl_out_items;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public ProcReqHal getHISchedLatency() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(37, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ProcReqHal _hidl_out_items = new ProcReqHal();
                _hidl_out_items.readFromParcel(_hidl_reply);
                return _hidl_out_items;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public ProcReqHal getHIFsyncWait() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(38, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ProcReqHal _hidl_out_items = new ProcReqHal();
                _hidl_out_items.readFromParcel(_hidl_reply);
                return _hidl_out_items;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public ProcReqHal getHIIowait() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(39, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ProcReqHal _hidl_out_items = new ProcReqHal();
                _hidl_out_items.readFromParcel(_hidl_reply);
                return _hidl_out_items;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public ProcReqHal getHIUfsFeature() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(40, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ProcReqHal _hidl_out_items = new ProcReqHal();
                _hidl_out_items.readFromParcel(_hidl_reply);
                return _hidl_out_items;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public ProcReqHal getHIIonWait() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(41, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ProcReqHal _hidl_out_items = new ProcReqHal();
                _hidl_out_items.readFromParcel(_hidl_reply);
                return _hidl_out_items;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public ProcReqHal getHIAllocWait() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(42, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ProcReqHal _hidl_out_items = new ProcReqHal();
                _hidl_out_items.readFromParcel(_hidl_reply);
                return _hidl_out_items;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public ProcReqHal getHIDState() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(43, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ProcReqHal _hidl_out_items = new ProcReqHal();
                _hidl_out_items.readFromParcel(_hidl_reply);
                return _hidl_out_items;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public ProcReqHal getHIKswapdLoading() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(44, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ProcReqHal _hidl_out_items = new ProcReqHal();
                _hidl_out_items.readFromParcel(_hidl_reply);
                return _hidl_out_items;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public ProcReqHal getHIScmCall() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(45, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ProcReqHal _hidl_out_items = new ProcReqHal();
                _hidl_out_items.readFromParcel(_hidl_reply);
                return _hidl_out_items;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getHICpuInfo() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(46, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getExt4FreefragInfo(String devpath) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(devpath);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(47, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getExt4FragScore(String devpath) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(devpath);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(48, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getF2fsMovedBlks() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(49, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public void setSchedAssistScene(String scene_id) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(scene_id);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(50, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public void setFrameRate(String frame_rate) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(frame_rate);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(51, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public void setFgUids(String fg_uid) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(fg_uid);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(52, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int setProcessReclaim(String info) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(info);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(53, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int perProcessMemReclaim(int uid, int pid, int type) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeInt32(uid);
            _hidl_request.writeInt32(pid);
            _hidl_request.writeInt32(type);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(54, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int perProcessMemReadahead(int uid, int pid, int type) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeInt32(uid);
            _hidl_request.writeInt32(pid);
            _hidl_request.writeInt32(type);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(55, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int setTpdSerialParams(String params) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(params);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(56, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int setTpdID(String param) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(param);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(57, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int enableTaskPlacementDecision() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(58, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int disableTaskPlacementDecision() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(59, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int getKernelVersion() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(60, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String getMemMonitor() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(61, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int writeMemMonitor(String buffer) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(buffer);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(62, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int writeUxState(String ux_state, String pid, String tid) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(ux_state);
            _hidl_request.writeString(pid);
            _hidl_request.writeString(tid);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(63, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int setAcmOpstat(int flag) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeInt32(flag);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(64, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int getAcmOpstat() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(65, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int addAcmPkgName(String pkgname, long flag) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(pkgname);
            _hidl_request.writeInt64(flag);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(66, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int delAcmPkgName(String pkgname) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(pkgname);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(67, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public long getAcmPkgFlag(String pkgname) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(pkgname);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(68, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                long _hidl_out_result = _hidl_reply.readInt64();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int addAcmDirName(String dirname, long flag) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(dirname);
            _hidl_request.writeInt64(flag);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(69, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int delAcmDirName(String dirname) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(dirname);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(70, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public long getAcmDirFlag(String dirname) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(dirname);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(71, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                long _hidl_out_result = _hidl_reply.readInt64();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int addAcmNomediaDirName(String dirname) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(dirname);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(72, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int delAcmNomediaDirName(String dirname) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(dirname);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(73, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int searchAcmNomediaDirName(String dirname) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(dirname);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(74, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readNandswapProc(String inProc) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(inProc);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(75, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int writeNandswapProc(String inProc, String cmd) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(inProc);
            _hidl_request.writeString(cmd);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(76, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public void setImFlag(String pid, String im_flag) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(pid);
            _hidl_request.writeString(im_flag);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(77, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readTaskCpustatsEnable() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(78, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readSgeFreqInfo() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(79, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public void setSlideboost(String boost) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(boost);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(80, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public void setSchedAssistImptTask(String impt_info) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(impt_info);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(81, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public void writeTaskSchedInfo(String buffer) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(buffer);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(82, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readTaskSchedInfo() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(83, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readPidsSet() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(84, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readSchedInfoThreshold() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(85, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public void writePidsSet(String buffer) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(buffer);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(86, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public void writeSchedInfoThreshold(String buffer) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(buffer);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(87, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int writeMonitorStatus(String buffer) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(buffer);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(88, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readRealTime() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(89, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readNormalizeRealTime() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(90, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readRunningTime() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(91, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readNormalizeRunningTime() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(92, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readTargetProcess(String buffer) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeString(buffer);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(93, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int getOswapVersion() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(94, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int hybridswap_zram_para_write(int action, String str) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeInt32(action);
            _hidl_request.writeString(str);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(95, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String hybridswap_zram_para_read(int action) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeInt32(action);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(96, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public int hybridswap_memcg_para_write(int action, String cgroup, String str) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeInt32(action);
            _hidl_request.writeString(cgroup);
            _hidl_request.writeString(str);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(97, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_result = _hidl_reply.readInt32();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String hybridswap_memcg_para_read(int action, String cgroup) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            _hidl_request.writeInt32(action);
            _hidl_request.writeString(cgroup);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(98, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance
        public String readDConvert() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IPerformance.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(99, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_result = _hidl_reply.readString();
                return _hidl_out_result;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public ArrayList<String> interfaceChain() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256067662, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ArrayList<String> _hidl_out_descriptors = _hidl_reply.readStringVector();
                return _hidl_out_descriptors;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public void debug(NativeHandle fd, ArrayList<String> options) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            _hidl_request.writeNativeHandle(fd);
            _hidl_request.writeStringVector(options);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256131655, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public String interfaceDescriptor() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256136003, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_descriptor = _hidl_reply.readString();
                return _hidl_out_descriptor;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public ArrayList<byte[]> getHashChain() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256398152, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ArrayList<byte[]> _hidl_out_hashchain = new ArrayList<>();
                HwBlob _hidl_blob = _hidl_reply.readBuffer(16L);
                int _hidl_vec_size = _hidl_blob.getInt32(8L);
                HwBlob childBlob = _hidl_reply.readEmbeddedBuffer(_hidl_vec_size * 32, _hidl_blob.handle(), 0L, true);
                _hidl_out_hashchain.clear();
                for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
                    byte[] _hidl_vec_element = new byte[32];
                    long _hidl_array_offset_1 = _hidl_index_0 * 32;
                    childBlob.copyToInt8Array(_hidl_array_offset_1, _hidl_vec_element, 32);
                    _hidl_out_hashchain.add(_hidl_vec_element);
                }
                return _hidl_out_hashchain;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public void setHALInstrumentation() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256462420, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) throws RemoteException {
            return this.mRemote.linkToDeath(recipient, cookie);
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public void ping() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256921159, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public DebugInfo getDebugInfo() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(257049926, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                DebugInfo _hidl_out_info = new DebugInfo();
                _hidl_out_info.readFromParcel(_hidl_reply);
                return _hidl_out_info;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public void notifySyspropsChanged() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(257120595, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) throws RemoteException {
            return this.mRemote.unlinkToDeath(recipient);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class Stub extends HwBinder implements IPerformance {
        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase, android.os.IHwInterface
        public IHwBinder asBinder() {
            return this;
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public final ArrayList<String> interfaceChain() {
            return new ArrayList<>(Arrays.asList(IPerformance.kInterfaceName, IBase.kInterfaceName));
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public void debug(NativeHandle fd, ArrayList<String> options) {
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public final String interfaceDescriptor() {
            return IPerformance.kInterfaceName;
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList<>(Arrays.asList(new byte[]{-30, 11, -47, 113, -71, 109, 30, 68, -84, -93, -4, Byte.MIN_VALUE, MidiConstants.STATUS_MIDI_TIME_CODE, -44, 109, 77, -42, 57, 1, -74, MidiConstants.STATUS_SONG_POSITION, 71, -122, MidiConstants.STATUS_NOTE_ON, -79, 96, 57, -30, 56, 18, -86, -94}, new byte[]{-20, Byte.MAX_VALUE, -41, -98, MidiConstants.STATUS_CHANNEL_PRESSURE, 45, -6, -123, -68, 73, -108, 38, -83, -82, 62, -66, 35, -17, 5, 36, MidiConstants.STATUS_SONG_SELECT, -51, 105, 87, 19, -109, 36, -72, 59, 24, -54, 76}));
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public final void setHALInstrumentation() {
        }

        @Override // android.os.IHwBinder, android.hardware.cas.V1_0.ICas, android.internal.hidl.base.V1_0.IBase
        public final boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) {
            return true;
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public final void ping() {
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public final DebugInfo getDebugInfo() {
            DebugInfo info = new DebugInfo();
            info.pid = HidlSupport.getPidIfSharable();
            info.ptr = 0L;
            info.arch = 0;
            return info;
        }

        @Override // vendor.oplus.hardware.performance.V1_0.IPerformance, android.internal.hidl.base.V1_0.IBase
        public final void notifySyspropsChanged() {
            HwBinder.enableInstrumentation();
        }

        @Override // android.os.IHwBinder, android.hardware.cas.V1_0.ICas, android.internal.hidl.base.V1_0.IBase
        public final boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) {
            return true;
        }

        @Override // android.os.IHwBinder
        public IHwInterface queryLocalInterface(String descriptor) {
            if (IPerformance.kInterfaceName.equals(descriptor)) {
                return this;
            }
            return null;
        }

        public void registerAsService(String serviceName) throws RemoteException {
            registerService(serviceName);
        }

        public String toString() {
            return interfaceDescriptor() + "@Stub";
        }

        @Override // android.os.HwBinder
        public void onTransact(int _hidl_code, HwParcel _hidl_request, HwParcel _hidl_reply, int _hidl_flags) throws RemoteException {
            switch (_hidl_code) {
                case 1:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result = enableMultiThreadOptimize();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result);
                    _hidl_reply.send();
                    return;
                case 2:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result2 = disableMultiThreadOptimize();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result2);
                    _hidl_reply.send();
                    return;
                case 3:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result3 = enableTaskCpustats();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result3);
                    _hidl_reply.send();
                    return;
                case 4:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result4 = disableTaskCpustats();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result4);
                    _hidl_reply.send();
                    return;
                case 5:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result5 = enableKmallocDebug();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result5);
                    _hidl_reply.send();
                    return;
                case 6:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result6 = disableKmallocDebug();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result6);
                    _hidl_reply.send();
                    return;
                case 7:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result7 = enableVmallocDebug();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result7);
                    _hidl_reply.send();
                    return;
                case 8:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result8 = disableVmallocDebug();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result8);
                    _hidl_reply.send();
                    return;
                case 9:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result9 = enableProcessReclaim();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result9);
                    _hidl_reply.send();
                    return;
                case 10:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result10 = disableProcessReclaim();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result10);
                    _hidl_reply.send();
                    return;
                case 11:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_info = getKmallocDebug();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_info);
                    _hidl_reply.send();
                    return;
                case 12:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_info2 = getKmallocOrigin();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_info2);
                    _hidl_reply.send();
                    return;
                case 13:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_info3 = getKmallocUsed();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_info3);
                    _hidl_reply.send();
                    return;
                case 14:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result11 = existMemMonitor();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result11);
                    _hidl_reply.send();
                    return;
                case 15:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int memdect = _hidl_request.readInt32();
                    int _hidl_out_result12 = writeMemleakDetectThread(memdect);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result12);
                    _hidl_reply.send();
                    return;
                case 16:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result13 = readMemleakDetectThread();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result13);
                    _hidl_reply.send();
                    return;
                case 17:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result14 = getschedlatency();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result14);
                    _hidl_reply.send();
                    return;
                case 18:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result15 = getiowait();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result15);
                    _hidl_reply.send();
                    return;
                case 19:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result16 = getfsyncwait();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result16);
                    _hidl_reply.send();
                    return;
                case 20:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result17 = getionwait();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result17);
                    _hidl_reply.send();
                    return;
                case 21:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result18 = getallocwait();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result18);
                    _hidl_reply.send();
                    return;
                case 22:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result19 = getdstate();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result19);
                    _hidl_reply.send();
                    return;
                case 23:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int vafeature = _hidl_request.readInt32();
                    int _hidl_out_result20 = writeVaFeature(vafeature);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result20);
                    _hidl_reply.send();
                    return;
                case 24:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result21 = readVaFeature();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result21);
                    _hidl_reply.send();
                    return;
                case 25:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int kcreate = _hidl_request.readInt32();
                    int _hidl_out_result22 = writeKmallocDebugCreate(kcreate);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result22);
                    _hidl_reply.send();
                    return;
                case 26:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String type = _hidl_request.readString();
                    int _hidl_out_result23 = writeKmallocDebugCreateWithType(type);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result23);
                    _hidl_reply.send();
                    return;
                case 27:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result24 = readKmallocDebugCreate();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result24);
                    _hidl_reply.send();
                    return;
                case 28:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_info4 = getVmallocDebug();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_info4);
                    _hidl_reply.send();
                    return;
                case 29:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_info5 = getVmallocUsed();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_info5);
                    _hidl_reply.send();
                    return;
                case 30:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_info6 = getVmallocHashCal();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_info6);
                    _hidl_reply.send();
                    return;
                case 31:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result25 = readCpuTaskstats();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result25);
                    _hidl_reply.send();
                    return;
                case 32:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result26 = readSgeInfo();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result26);
                    _hidl_reply.send();
                    return;
                case 33:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String procname = _hidl_request.readString();
                    String _hidl_out_result27 = readIomonitorInfo(procname);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result27);
                    _hidl_reply.send();
                    return;
                case 34:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result28 = getHICpuLoading();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result28);
                    _hidl_reply.send();
                    return;
                case 35:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    ProcReqHal _hidl_out_items = getHIEmcdrvIowait();
                    _hidl_reply.writeStatus(0);
                    _hidl_out_items.writeToParcel(_hidl_reply);
                    _hidl_reply.send();
                    return;
                case 36:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    ProcReqHal _hidl_out_items2 = getHIIowaitHung();
                    _hidl_reply.writeStatus(0);
                    _hidl_out_items2.writeToParcel(_hidl_reply);
                    _hidl_reply.send();
                    return;
                case 37:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    ProcReqHal _hidl_out_items3 = getHISchedLatency();
                    _hidl_reply.writeStatus(0);
                    _hidl_out_items3.writeToParcel(_hidl_reply);
                    _hidl_reply.send();
                    return;
                case 38:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    ProcReqHal _hidl_out_items4 = getHIFsyncWait();
                    _hidl_reply.writeStatus(0);
                    _hidl_out_items4.writeToParcel(_hidl_reply);
                    _hidl_reply.send();
                    return;
                case 39:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    ProcReqHal _hidl_out_items5 = getHIIowait();
                    _hidl_reply.writeStatus(0);
                    _hidl_out_items5.writeToParcel(_hidl_reply);
                    _hidl_reply.send();
                    return;
                case 40:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    ProcReqHal _hidl_out_items6 = getHIUfsFeature();
                    _hidl_reply.writeStatus(0);
                    _hidl_out_items6.writeToParcel(_hidl_reply);
                    _hidl_reply.send();
                    return;
                case 41:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    ProcReqHal _hidl_out_items7 = getHIIonWait();
                    _hidl_reply.writeStatus(0);
                    _hidl_out_items7.writeToParcel(_hidl_reply);
                    _hidl_reply.send();
                    return;
                case 42:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    ProcReqHal _hidl_out_items8 = getHIAllocWait();
                    _hidl_reply.writeStatus(0);
                    _hidl_out_items8.writeToParcel(_hidl_reply);
                    _hidl_reply.send();
                    return;
                case 43:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    ProcReqHal _hidl_out_items9 = getHIDState();
                    _hidl_reply.writeStatus(0);
                    _hidl_out_items9.writeToParcel(_hidl_reply);
                    _hidl_reply.send();
                    return;
                case 44:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    ProcReqHal _hidl_out_items10 = getHIKswapdLoading();
                    _hidl_reply.writeStatus(0);
                    _hidl_out_items10.writeToParcel(_hidl_reply);
                    _hidl_reply.send();
                    return;
                case 45:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    ProcReqHal _hidl_out_items11 = getHIScmCall();
                    _hidl_reply.writeStatus(0);
                    _hidl_out_items11.writeToParcel(_hidl_reply);
                    _hidl_reply.send();
                    return;
                case 46:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result29 = getHICpuInfo();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result29);
                    _hidl_reply.send();
                    return;
                case 47:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String devpath = _hidl_request.readString();
                    String _hidl_out_result30 = getExt4FreefragInfo(devpath);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result30);
                    _hidl_reply.send();
                    return;
                case 48:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String devpath2 = _hidl_request.readString();
                    String _hidl_out_result31 = getExt4FragScore(devpath2);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result31);
                    _hidl_reply.send();
                    return;
                case 49:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result32 = getF2fsMovedBlks();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result32);
                    _hidl_reply.send();
                    return;
                case 50:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String scene_id = _hidl_request.readString();
                    setSchedAssistScene(scene_id);
                    return;
                case 51:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String frame_rate = _hidl_request.readString();
                    setFrameRate(frame_rate);
                    return;
                case 52:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String fg_uid = _hidl_request.readString();
                    setFgUids(fg_uid);
                    return;
                case 53:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String info = _hidl_request.readString();
                    int _hidl_out_result33 = setProcessReclaim(info);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result33);
                    _hidl_reply.send();
                    return;
                case 54:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int uid = _hidl_request.readInt32();
                    int pid = _hidl_request.readInt32();
                    int type2 = _hidl_request.readInt32();
                    int _hidl_out_result34 = perProcessMemReclaim(uid, pid, type2);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result34);
                    _hidl_reply.send();
                    return;
                case 55:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int uid2 = _hidl_request.readInt32();
                    int pid2 = _hidl_request.readInt32();
                    int type3 = _hidl_request.readInt32();
                    int _hidl_out_result35 = perProcessMemReadahead(uid2, pid2, type3);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result35);
                    _hidl_reply.send();
                    return;
                case 56:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String params = _hidl_request.readString();
                    int _hidl_out_result36 = setTpdSerialParams(params);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result36);
                    _hidl_reply.send();
                    return;
                case 57:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String param = _hidl_request.readString();
                    int _hidl_out_result37 = setTpdID(param);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result37);
                    _hidl_reply.send();
                    return;
                case 58:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result38 = enableTaskPlacementDecision();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result38);
                    _hidl_reply.send();
                    return;
                case 59:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result39 = disableTaskPlacementDecision();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result39);
                    _hidl_reply.send();
                    return;
                case 60:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result40 = getKernelVersion();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result40);
                    _hidl_reply.send();
                    return;
                case 61:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result41 = getMemMonitor();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result41);
                    _hidl_reply.send();
                    return;
                case 62:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String buffer = _hidl_request.readString();
                    int _hidl_out_result42 = writeMemMonitor(buffer);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result42);
                    _hidl_reply.send();
                    return;
                case 63:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String ux_state = _hidl_request.readString();
                    String pid3 = _hidl_request.readString();
                    String tid = _hidl_request.readString();
                    int _hidl_out_result43 = writeUxState(ux_state, pid3, tid);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result43);
                    _hidl_reply.send();
                    return;
                case 64:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int flag = _hidl_request.readInt32();
                    int _hidl_out_result44 = setAcmOpstat(flag);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result44);
                    _hidl_reply.send();
                    return;
                case 65:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result45 = getAcmOpstat();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result45);
                    _hidl_reply.send();
                    return;
                case 66:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String pkgname = _hidl_request.readString();
                    long flag2 = _hidl_request.readInt64();
                    int _hidl_out_result46 = addAcmPkgName(pkgname, flag2);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result46);
                    _hidl_reply.send();
                    return;
                case 67:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String pkgname2 = _hidl_request.readString();
                    int _hidl_out_result47 = delAcmPkgName(pkgname2);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result47);
                    _hidl_reply.send();
                    return;
                case 68:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String pkgname3 = _hidl_request.readString();
                    long _hidl_out_result48 = getAcmPkgFlag(pkgname3);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt64(_hidl_out_result48);
                    _hidl_reply.send();
                    return;
                case 69:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String dirname = _hidl_request.readString();
                    long flag3 = _hidl_request.readInt64();
                    int _hidl_out_result49 = addAcmDirName(dirname, flag3);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result49);
                    _hidl_reply.send();
                    return;
                case 70:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String dirname2 = _hidl_request.readString();
                    int _hidl_out_result50 = delAcmDirName(dirname2);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result50);
                    _hidl_reply.send();
                    return;
                case 71:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String dirname3 = _hidl_request.readString();
                    long _hidl_out_result51 = getAcmDirFlag(dirname3);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt64(_hidl_out_result51);
                    _hidl_reply.send();
                    return;
                case 72:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String dirname4 = _hidl_request.readString();
                    int _hidl_out_result52 = addAcmNomediaDirName(dirname4);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result52);
                    _hidl_reply.send();
                    return;
                case 73:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String dirname5 = _hidl_request.readString();
                    int _hidl_out_result53 = delAcmNomediaDirName(dirname5);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result53);
                    _hidl_reply.send();
                    return;
                case 74:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String dirname6 = _hidl_request.readString();
                    int _hidl_out_result54 = searchAcmNomediaDirName(dirname6);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result54);
                    _hidl_reply.send();
                    return;
                case 75:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String inProc = _hidl_request.readString();
                    String _hidl_out_result55 = readNandswapProc(inProc);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result55);
                    _hidl_reply.send();
                    return;
                case 76:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String inProc2 = _hidl_request.readString();
                    String cmd = _hidl_request.readString();
                    int _hidl_out_result56 = writeNandswapProc(inProc2, cmd);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result56);
                    _hidl_reply.send();
                    return;
                case 77:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String pid4 = _hidl_request.readString();
                    String im_flag = _hidl_request.readString();
                    setImFlag(pid4, im_flag);
                    return;
                case 78:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result57 = readTaskCpustatsEnable();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result57);
                    _hidl_reply.send();
                    return;
                case 79:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result58 = readSgeFreqInfo();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result58);
                    _hidl_reply.send();
                    return;
                case 80:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String boost = _hidl_request.readString();
                    setSlideboost(boost);
                    return;
                case 81:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String impt_info = _hidl_request.readString();
                    setSchedAssistImptTask(impt_info);
                    return;
                case 82:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String buffer2 = _hidl_request.readString();
                    writeTaskSchedInfo(buffer2);
                    return;
                case 83:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result59 = readTaskSchedInfo();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result59);
                    _hidl_reply.send();
                    return;
                case 84:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result60 = readPidsSet();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result60);
                    _hidl_reply.send();
                    return;
                case 85:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result61 = readSchedInfoThreshold();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result61);
                    _hidl_reply.send();
                    return;
                case 86:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String buffer3 = _hidl_request.readString();
                    writePidsSet(buffer3);
                    return;
                case 87:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String buffer4 = _hidl_request.readString();
                    writeSchedInfoThreshold(buffer4);
                    return;
                case 88:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String buffer5 = _hidl_request.readString();
                    int _hidl_out_result62 = writeMonitorStatus(buffer5);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result62);
                    _hidl_reply.send();
                    return;
                case 89:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result63 = readRealTime();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result63);
                    _hidl_reply.send();
                    return;
                case 90:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result64 = readNormalizeRealTime();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result64);
                    _hidl_reply.send();
                    return;
                case 91:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result65 = readRunningTime();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result65);
                    _hidl_reply.send();
                    return;
                case 92:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result66 = readNormalizeRunningTime();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result66);
                    _hidl_reply.send();
                    return;
                case 93:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String buffer6 = _hidl_request.readString();
                    String _hidl_out_result67 = readTargetProcess(buffer6);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result67);
                    _hidl_reply.send();
                    return;
                case 94:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int _hidl_out_result68 = getOswapVersion();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result68);
                    _hidl_reply.send();
                    return;
                case 95:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int action = _hidl_request.readInt32();
                    String str = _hidl_request.readString();
                    int _hidl_out_result69 = hybridswap_zram_para_write(action, str);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result69);
                    _hidl_reply.send();
                    return;
                case 96:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int action2 = _hidl_request.readInt32();
                    String _hidl_out_result70 = hybridswap_zram_para_read(action2);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result70);
                    _hidl_reply.send();
                    return;
                case 97:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int action3 = _hidl_request.readInt32();
                    String cgroup = _hidl_request.readString();
                    String str2 = _hidl_request.readString();
                    int _hidl_out_result71 = hybridswap_memcg_para_write(action3, cgroup, str2);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeInt32(_hidl_out_result71);
                    _hidl_reply.send();
                    return;
                case 98:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    int action4 = _hidl_request.readInt32();
                    String cgroup2 = _hidl_request.readString();
                    String _hidl_out_result72 = hybridswap_memcg_para_read(action4, cgroup2);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result72);
                    _hidl_reply.send();
                    return;
                case 99:
                    _hidl_request.enforceInterface(IPerformance.kInterfaceName);
                    String _hidl_out_result73 = readDConvert();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_result73);
                    _hidl_reply.send();
                    return;
                case 256067662:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    ArrayList<String> _hidl_out_descriptors = interfaceChain();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeStringVector(_hidl_out_descriptors);
                    _hidl_reply.send();
                    return;
                case 256131655:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    NativeHandle fd = _hidl_request.readNativeHandle();
                    ArrayList<String> options = _hidl_request.readStringVector();
                    debug(fd, options);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.send();
                    return;
                case 256136003:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    String _hidl_out_descriptor = interfaceDescriptor();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_descriptor);
                    _hidl_reply.send();
                    return;
                case 256398152:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    ArrayList<byte[]> _hidl_out_hashchain = getHashChain();
                    _hidl_reply.writeStatus(0);
                    HwBlob _hidl_blob = new HwBlob(16);
                    int _hidl_vec_size = _hidl_out_hashchain.size();
                    _hidl_blob.putInt32(8L, _hidl_vec_size);
                    _hidl_blob.putBool(12L, false);
                    HwBlob childBlob = new HwBlob(_hidl_vec_size * 32);
                    for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
                        long _hidl_array_offset_1 = _hidl_index_0 * 32;
                        byte[] _hidl_array_item_1 = _hidl_out_hashchain.get(_hidl_index_0);
                        if (_hidl_array_item_1 == null || _hidl_array_item_1.length != 32) {
                            throw new IllegalArgumentException("Array element is not of the expected length");
                        }
                        childBlob.putInt8Array(_hidl_array_offset_1, _hidl_array_item_1);
                    }
                    _hidl_blob.putBlob(0L, childBlob);
                    _hidl_reply.writeBuffer(_hidl_blob);
                    _hidl_reply.send();
                    return;
                case 256462420:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    setHALInstrumentation();
                    return;
                case 256660548:
                default:
                    return;
                case 256921159:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    ping();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.send();
                    return;
                case 257049926:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    DebugInfo _hidl_out_info7 = getDebugInfo();
                    _hidl_reply.writeStatus(0);
                    _hidl_out_info7.writeToParcel(_hidl_reply);
                    _hidl_reply.send();
                    return;
                case 257120595:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    notifySyspropsChanged();
                    return;
            }
        }
    }
}