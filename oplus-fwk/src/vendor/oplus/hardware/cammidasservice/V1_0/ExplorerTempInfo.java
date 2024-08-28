package vendor.oplus.hardware.cammidasservice.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class ExplorerTempInfo {
    public float[] DDRTemp = new float[2];
    public float[] NPUTemp = new float[2];
    public float[] ISPTemp = new float[2];
    public float[] MAXCPUTemp = new float[2];
    public float[] surfaceTemp = new float[2];

    public final boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || otherObject.getClass() != ExplorerTempInfo.class) {
            return false;
        }
        ExplorerTempInfo other = (ExplorerTempInfo) otherObject;
        if (HidlSupport.deepEquals(this.DDRTemp, other.DDRTemp) && HidlSupport.deepEquals(this.NPUTemp, other.NPUTemp) && HidlSupport.deepEquals(this.ISPTemp, other.ISPTemp) && HidlSupport.deepEquals(this.MAXCPUTemp, other.MAXCPUTemp) && HidlSupport.deepEquals(this.surfaceTemp, other.surfaceTemp)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(this.DDRTemp)), Integer.valueOf(HidlSupport.deepHashCode(this.NPUTemp)), Integer.valueOf(HidlSupport.deepHashCode(this.ISPTemp)), Integer.valueOf(HidlSupport.deepHashCode(this.MAXCPUTemp)), Integer.valueOf(HidlSupport.deepHashCode(this.surfaceTemp)));
    }

    public final String toString() {
        return "{.DDRTemp = " + Arrays.toString(this.DDRTemp) + ", .NPUTemp = " + Arrays.toString(this.NPUTemp) + ", .ISPTemp = " + Arrays.toString(this.ISPTemp) + ", .MAXCPUTemp = " + Arrays.toString(this.MAXCPUTemp) + ", .surfaceTemp = " + Arrays.toString(this.surfaceTemp) + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(40L);
        readEmbeddedFromParcel(parcel, blob, 0L);
    }

    public static final ArrayList<ExplorerTempInfo> readVectorFromParcel(HwParcel parcel) {
        ArrayList<ExplorerTempInfo> _hidl_vec = new ArrayList<>();
        HwBlob _hidl_blob = parcel.readBuffer(16L);
        int _hidl_vec_size = _hidl_blob.getInt32(8L);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 40, _hidl_blob.handle(), 0L, true);
        _hidl_vec.clear();
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            ExplorerTempInfo _hidl_vec_element = new ExplorerTempInfo();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 40);
            _hidl_vec.add(_hidl_vec_element);
        }
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        long _hidl_array_offset_0 = 0 + _hidl_offset;
        _hidl_blob.copyToFloatArray(_hidl_array_offset_0, this.DDRTemp, 2);
        long _hidl_array_offset_02 = 8 + _hidl_offset;
        _hidl_blob.copyToFloatArray(_hidl_array_offset_02, this.NPUTemp, 2);
        long _hidl_array_offset_03 = 16 + _hidl_offset;
        _hidl_blob.copyToFloatArray(_hidl_array_offset_03, this.ISPTemp, 2);
        long _hidl_array_offset_04 = 24 + _hidl_offset;
        _hidl_blob.copyToFloatArray(_hidl_array_offset_04, this.MAXCPUTemp, 2);
        long _hidl_array_offset_05 = 32 + _hidl_offset;
        _hidl_blob.copyToFloatArray(_hidl_array_offset_05, this.surfaceTemp, 2);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(40);
        writeEmbeddedToBlob(_hidl_blob, 0L);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<ExplorerTempInfo> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8L, _hidl_vec_size);
        _hidl_blob.putBool(12L, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 40);
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 40);
        }
        _hidl_blob.putBlob(0L, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        long _hidl_array_offset_0 = 0 + _hidl_offset;
        float[] _hidl_array_item_0 = this.DDRTemp;
        if (_hidl_array_item_0 == null || _hidl_array_item_0.length != 2) {
            throw new IllegalArgumentException("Array element is not of the expected length");
        }
        _hidl_blob.putFloatArray(_hidl_array_offset_0, _hidl_array_item_0);
        long _hidl_array_offset_02 = 8 + _hidl_offset;
        float[] _hidl_array_item_02 = this.NPUTemp;
        if (_hidl_array_item_02 == null || _hidl_array_item_02.length != 2) {
            throw new IllegalArgumentException("Array element is not of the expected length");
        }
        _hidl_blob.putFloatArray(_hidl_array_offset_02, _hidl_array_item_02);
        long _hidl_array_offset_03 = 16 + _hidl_offset;
        float[] _hidl_array_item_03 = this.ISPTemp;
        if (_hidl_array_item_03 == null || _hidl_array_item_03.length != 2) {
            throw new IllegalArgumentException("Array element is not of the expected length");
        }
        _hidl_blob.putFloatArray(_hidl_array_offset_03, _hidl_array_item_03);
        long _hidl_array_offset_04 = 24 + _hidl_offset;
        float[] _hidl_array_item_04 = this.MAXCPUTemp;
        if (_hidl_array_item_04 == null || _hidl_array_item_04.length != 2) {
            throw new IllegalArgumentException("Array element is not of the expected length");
        }
        _hidl_blob.putFloatArray(_hidl_array_offset_04, _hidl_array_item_04);
        long _hidl_array_offset_05 = 32 + _hidl_offset;
        float[] _hidl_array_item_05 = this.surfaceTemp;
        if (_hidl_array_item_05 == null || _hidl_array_item_05.length != 2) {
            throw new IllegalArgumentException("Array element is not of the expected length");
        }
        _hidl_blob.putFloatArray(_hidl_array_offset_05, _hidl_array_item_05);
    }
}
