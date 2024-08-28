package vendor.oplus.hardware.cammidasservice.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class ExplorerInfo {
    public int operationMode = 0;
    public double startTime = 0.0d;
    public double endTime = 0.0d;
    public double[] sensorDuration = new double[8];
    public ExplorerExceptionInfo exceptionInfo = new ExplorerExceptionInfo();
    public ExplorerModeInfo modeInfo = new ExplorerModeInfo();
    public ExplorerTempInfo tempInfo = new ExplorerTempInfo();

    public final boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || otherObject.getClass() != ExplorerInfo.class) {
            return false;
        }
        ExplorerInfo other = (ExplorerInfo) otherObject;
        if (this.operationMode == other.operationMode && this.startTime == other.startTime && this.endTime == other.endTime && HidlSupport.deepEquals(this.sensorDuration, other.sensorDuration) && HidlSupport.deepEquals(this.exceptionInfo, other.exceptionInfo) && HidlSupport.deepEquals(this.modeInfo, other.modeInfo) && HidlSupport.deepEquals(this.tempInfo, other.tempInfo)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.operationMode))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.startTime))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.endTime))), Integer.valueOf(HidlSupport.deepHashCode(this.sensorDuration)), Integer.valueOf(HidlSupport.deepHashCode(this.exceptionInfo)), Integer.valueOf(HidlSupport.deepHashCode(this.modeInfo)), Integer.valueOf(HidlSupport.deepHashCode(this.tempInfo)));
    }

    public final String toString() {
        return "{.operationMode = " + this.operationMode + ", .startTime = " + this.startTime + ", .endTime = " + this.endTime + ", .sensorDuration = " + Arrays.toString(this.sensorDuration) + ", .exceptionInfo = " + this.exceptionInfo + ", .modeInfo = " + this.modeInfo + ", .tempInfo = " + this.tempInfo + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(200L);
        readEmbeddedFromParcel(parcel, blob, 0L);
    }

    public static final ArrayList<ExplorerInfo> readVectorFromParcel(HwParcel parcel) {
        ArrayList<ExplorerInfo> _hidl_vec = new ArrayList<>();
        HwBlob _hidl_blob = parcel.readBuffer(16L);
        int _hidl_vec_size = _hidl_blob.getInt32(8L);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 200, _hidl_blob.handle(), 0L, true);
        _hidl_vec.clear();
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            ExplorerInfo _hidl_vec_element = new ExplorerInfo();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 200);
            _hidl_vec.add(_hidl_vec_element);
        }
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.operationMode = _hidl_blob.getInt32(0 + _hidl_offset);
        this.startTime = _hidl_blob.getDouble(8 + _hidl_offset);
        this.endTime = _hidl_blob.getDouble(16 + _hidl_offset);
        long _hidl_array_offset_0 = 24 + _hidl_offset;
        _hidl_blob.copyToDoubleArray(_hidl_array_offset_0, this.sensorDuration, 8);
        this.exceptionInfo.readEmbeddedFromParcel(parcel, _hidl_blob, 88 + _hidl_offset);
        this.modeInfo.readEmbeddedFromParcel(parcel, _hidl_blob, 112 + _hidl_offset);
        this.tempInfo.readEmbeddedFromParcel(parcel, _hidl_blob, 160 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(200);
        writeEmbeddedToBlob(_hidl_blob, 0L);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<ExplorerInfo> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8L, _hidl_vec_size);
        _hidl_blob.putBool(12L, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 200);
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 200);
        }
        _hidl_blob.putBlob(0L, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt32(0 + _hidl_offset, this.operationMode);
        _hidl_blob.putDouble(8 + _hidl_offset, this.startTime);
        _hidl_blob.putDouble(16 + _hidl_offset, this.endTime);
        long _hidl_array_offset_0 = 24 + _hidl_offset;
        double[] _hidl_array_item_0 = this.sensorDuration;
        if (_hidl_array_item_0 == null || _hidl_array_item_0.length != 8) {
            throw new IllegalArgumentException("Array element is not of the expected length");
        }
        _hidl_blob.putDoubleArray(_hidl_array_offset_0, _hidl_array_item_0);
        this.exceptionInfo.writeEmbeddedToBlob(_hidl_blob, 88 + _hidl_offset);
        this.modeInfo.writeEmbeddedToBlob(_hidl_blob, 112 + _hidl_offset);
        this.tempInfo.writeEmbeddedToBlob(_hidl_blob, 160 + _hidl_offset);
    }
}
