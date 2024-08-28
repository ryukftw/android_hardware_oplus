package vendor.oplus.hardware.cammidasservice.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class ExplorerModeInfo {
    public int HDRRunTimes = 0;
    public int AINRRunTimes = 0;
    public int HDR_AINRRunTimes = 0;
    public int OtherModeRunTimes = 0;
    public double HDRDuration = 0.0d;
    public double AINRDuration = 0.0d;
    public double HDR_AINRDuration = 0.0d;
    public double OtherModeDuration = 0.0d;

    public final boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || otherObject.getClass() != ExplorerModeInfo.class) {
            return false;
        }
        ExplorerModeInfo other = (ExplorerModeInfo) otherObject;
        if (this.HDRRunTimes == other.HDRRunTimes && this.AINRRunTimes == other.AINRRunTimes && this.HDR_AINRRunTimes == other.HDR_AINRRunTimes && this.OtherModeRunTimes == other.OtherModeRunTimes && this.HDRDuration == other.HDRDuration && this.AINRDuration == other.AINRDuration && this.HDR_AINRDuration == other.HDR_AINRDuration && this.OtherModeDuration == other.OtherModeDuration) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.HDRRunTimes))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.AINRRunTimes))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.HDR_AINRRunTimes))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.OtherModeRunTimes))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.HDRDuration))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.AINRDuration))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.HDR_AINRDuration))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.OtherModeDuration))));
    }

    public final String toString() {
        return "{.HDRRunTimes = " + this.HDRRunTimes + ", .AINRRunTimes = " + this.AINRRunTimes + ", .HDR_AINRRunTimes = " + this.HDR_AINRRunTimes + ", .OtherModeRunTimes = " + this.OtherModeRunTimes + ", .HDRDuration = " + this.HDRDuration + ", .AINRDuration = " + this.AINRDuration + ", .HDR_AINRDuration = " + this.HDR_AINRDuration + ", .OtherModeDuration = " + this.OtherModeDuration + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(48L);
        readEmbeddedFromParcel(parcel, blob, 0L);
    }

    public static final ArrayList<ExplorerModeInfo> readVectorFromParcel(HwParcel parcel) {
        ArrayList<ExplorerModeInfo> _hidl_vec = new ArrayList<>();
        HwBlob _hidl_blob = parcel.readBuffer(16L);
        int _hidl_vec_size = _hidl_blob.getInt32(8L);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 48, _hidl_blob.handle(), 0L, true);
        _hidl_vec.clear();
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            ExplorerModeInfo _hidl_vec_element = new ExplorerModeInfo();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 48);
            _hidl_vec.add(_hidl_vec_element);
        }
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.HDRRunTimes = _hidl_blob.getInt32(0 + _hidl_offset);
        this.AINRRunTimes = _hidl_blob.getInt32(4 + _hidl_offset);
        this.HDR_AINRRunTimes = _hidl_blob.getInt32(8 + _hidl_offset);
        this.OtherModeRunTimes = _hidl_blob.getInt32(12 + _hidl_offset);
        this.HDRDuration = _hidl_blob.getDouble(16 + _hidl_offset);
        this.AINRDuration = _hidl_blob.getDouble(24 + _hidl_offset);
        this.HDR_AINRDuration = _hidl_blob.getDouble(32 + _hidl_offset);
        this.OtherModeDuration = _hidl_blob.getDouble(40 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(48);
        writeEmbeddedToBlob(_hidl_blob, 0L);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<ExplorerModeInfo> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8L, _hidl_vec_size);
        _hidl_blob.putBool(12L, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 48);
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 48);
        }
        _hidl_blob.putBlob(0L, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt32(0 + _hidl_offset, this.HDRRunTimes);
        _hidl_blob.putInt32(4 + _hidl_offset, this.AINRRunTimes);
        _hidl_blob.putInt32(8 + _hidl_offset, this.HDR_AINRRunTimes);
        _hidl_blob.putInt32(12 + _hidl_offset, this.OtherModeRunTimes);
        _hidl_blob.putDouble(16 + _hidl_offset, this.HDRDuration);
        _hidl_blob.putDouble(24 + _hidl_offset, this.AINRDuration);
        _hidl_blob.putDouble(32 + _hidl_offset, this.HDR_AINRDuration);
        _hidl_blob.putDouble(40 + _hidl_offset, this.OtherModeDuration);
    }
}
