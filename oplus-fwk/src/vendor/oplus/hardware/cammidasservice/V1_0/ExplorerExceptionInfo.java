package vendor.oplus.hardware.cammidasservice.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class ExplorerExceptionInfo {
    public int moduleId = 0;
    public int majorType = 0;
    public int minorType = 0;
    public int level = 0;
    public int action = 0;

    public final boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || otherObject.getClass() != ExplorerExceptionInfo.class) {
            return false;
        }
        ExplorerExceptionInfo other = (ExplorerExceptionInfo) otherObject;
        if (this.moduleId == other.moduleId && this.majorType == other.majorType && this.minorType == other.minorType && this.level == other.level && this.action == other.action) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.moduleId))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.majorType))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.minorType))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.level))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.action))));
    }

    public final String toString() {
        return "{.moduleId = " + this.moduleId + ", .majorType = " + this.majorType + ", .minorType = " + this.minorType + ", .level = " + this.level + ", .action = " + this.action + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(20L);
        readEmbeddedFromParcel(parcel, blob, 0L);
    }

    public static final ArrayList<ExplorerExceptionInfo> readVectorFromParcel(HwParcel parcel) {
        ArrayList<ExplorerExceptionInfo> _hidl_vec = new ArrayList<>();
        HwBlob _hidl_blob = parcel.readBuffer(16L);
        int _hidl_vec_size = _hidl_blob.getInt32(8L);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 20, _hidl_blob.handle(), 0L, true);
        _hidl_vec.clear();
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            ExplorerExceptionInfo _hidl_vec_element = new ExplorerExceptionInfo();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 20);
            _hidl_vec.add(_hidl_vec_element);
        }
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.moduleId = _hidl_blob.getInt32(0 + _hidl_offset);
        this.majorType = _hidl_blob.getInt32(4 + _hidl_offset);
        this.minorType = _hidl_blob.getInt32(8 + _hidl_offset);
        this.level = _hidl_blob.getInt32(12 + _hidl_offset);
        this.action = _hidl_blob.getInt32(16 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(20);
        writeEmbeddedToBlob(_hidl_blob, 0L);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<ExplorerExceptionInfo> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8L, _hidl_vec_size);
        _hidl_blob.putBool(12L, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 20);
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 20);
        }
        _hidl_blob.putBlob(0L, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt32(0 + _hidl_offset, this.moduleId);
        _hidl_blob.putInt32(4 + _hidl_offset, this.majorType);
        _hidl_blob.putInt32(8 + _hidl_offset, this.minorType);
        _hidl_blob.putInt32(12 + _hidl_offset, this.level);
        _hidl_blob.putInt32(16 + _hidl_offset, this.action);
    }
}
