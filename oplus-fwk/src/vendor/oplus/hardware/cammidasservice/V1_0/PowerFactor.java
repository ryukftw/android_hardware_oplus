package vendor.oplus.hardware.cammidasservice.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class PowerFactor {
    public String packageName = new String();
    public int numOfCameras = 0;
    public ArrayList<CameraInfo> cameraInfoSet = new ArrayList<>();
    public double frameRate = 0.0d;
    public double startTime = 0.0d;
    public double duration = 0.0d;
    public boolean isLaserOpen = false;
    public double[] flashTime = new double[2];
    public boolean isOISEnable = false;
    public double[] motorTime = new double[3];

    public final boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || otherObject.getClass() != PowerFactor.class) {
            return false;
        }
        PowerFactor other = (PowerFactor) otherObject;
        if (HidlSupport.deepEquals(this.packageName, other.packageName) && this.numOfCameras == other.numOfCameras && HidlSupport.deepEquals(this.cameraInfoSet, other.cameraInfoSet) && this.frameRate == other.frameRate && this.startTime == other.startTime && this.duration == other.duration && this.isLaserOpen == other.isLaserOpen && HidlSupport.deepEquals(this.flashTime, other.flashTime) && this.isOISEnable == other.isOISEnable && HidlSupport.deepEquals(this.motorTime, other.motorTime)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(this.packageName)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.numOfCameras))), Integer.valueOf(HidlSupport.deepHashCode(this.cameraInfoSet)), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.frameRate))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.startTime))), Integer.valueOf(HidlSupport.deepHashCode(Double.valueOf(this.duration))), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.isLaserOpen))), Integer.valueOf(HidlSupport.deepHashCode(this.flashTime)), Integer.valueOf(HidlSupport.deepHashCode(Boolean.valueOf(this.isOISEnable))), Integer.valueOf(HidlSupport.deepHashCode(this.motorTime)));
    }

    public final String toString() {
        return "{.packageName = " + this.packageName + ", .numOfCameras = " + this.numOfCameras + ", .cameraInfoSet = " + this.cameraInfoSet + ", .frameRate = " + this.frameRate + ", .startTime = " + this.startTime + ", .duration = " + this.duration + ", .isLaserOpen = " + this.isLaserOpen + ", .flashTime = " + Arrays.toString(this.flashTime) + ", .isOISEnable = " + this.isOISEnable + ", .motorTime = " + Arrays.toString(this.motorTime) + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(120L);
        readEmbeddedFromParcel(parcel, blob, 0L);
    }

    public static final ArrayList<PowerFactor> readVectorFromParcel(HwParcel parcel) {
        ArrayList<PowerFactor> _hidl_vec = new ArrayList<>();
        HwBlob _hidl_blob = parcel.readBuffer(16L);
        int _hidl_vec_size = _hidl_blob.getInt32(8L);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 120, _hidl_blob.handle(), 0L, true);
        _hidl_vec.clear();
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            PowerFactor _hidl_vec_element = new PowerFactor();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 120);
            _hidl_vec.add(_hidl_vec_element);
        }
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        String string = _hidl_blob.getString(_hidl_offset + 0);
        this.packageName = string;
        parcel.readEmbeddedBuffer(string.getBytes().length + 1, _hidl_blob.handle(), _hidl_offset + 0 + 0, false);
        this.numOfCameras = _hidl_blob.getInt32(_hidl_offset + 16);
        int _hidl_vec_size = _hidl_blob.getInt32(_hidl_offset + 24 + 8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 16, _hidl_blob.handle(), _hidl_offset + 24 + 0, true);
        this.cameraInfoSet.clear();
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            CameraInfo _hidl_vec_element = new CameraInfo();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 16);
            this.cameraInfoSet.add(_hidl_vec_element);
        }
        this.frameRate = _hidl_blob.getDouble(_hidl_offset + 40);
        this.startTime = _hidl_blob.getDouble(_hidl_offset + 48);
        this.duration = _hidl_blob.getDouble(_hidl_offset + 56);
        this.isLaserOpen = _hidl_blob.getBool(_hidl_offset + 64);
        long _hidl_array_offset_0 = _hidl_offset + 72;
        _hidl_blob.copyToDoubleArray(_hidl_array_offset_0, this.flashTime, 2);
        this.isOISEnable = _hidl_blob.getBool(_hidl_offset + 88);
        long _hidl_array_offset_02 = _hidl_offset + 96;
        _hidl_blob.copyToDoubleArray(_hidl_array_offset_02, this.motorTime, 3);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(120);
        writeEmbeddedToBlob(_hidl_blob, 0L);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<PowerFactor> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8L, _hidl_vec_size);
        _hidl_blob.putBool(12L, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 120);
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 120);
        }
        _hidl_blob.putBlob(0L, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putString(_hidl_offset + 0, this.packageName);
        _hidl_blob.putInt32(16 + _hidl_offset, this.numOfCameras);
        int _hidl_vec_size = this.cameraInfoSet.size();
        _hidl_blob.putInt32(_hidl_offset + 24 + 8, _hidl_vec_size);
        _hidl_blob.putBool(_hidl_offset + 24 + 12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 16);
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            this.cameraInfoSet.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 16);
        }
        _hidl_blob.putBlob(24 + _hidl_offset + 0, childBlob);
        _hidl_blob.putDouble(40 + _hidl_offset, this.frameRate);
        _hidl_blob.putDouble(48 + _hidl_offset, this.startTime);
        _hidl_blob.putDouble(56 + _hidl_offset, this.duration);
        _hidl_blob.putBool(64 + _hidl_offset, this.isLaserOpen);
        long _hidl_array_offset_0 = 72 + _hidl_offset;
        double[] _hidl_array_item_0 = this.flashTime;
        if (_hidl_array_item_0 == null || _hidl_array_item_0.length != 2) {
            throw new IllegalArgumentException("Array element is not of the expected length");
        }
        _hidl_blob.putDoubleArray(_hidl_array_offset_0, _hidl_array_item_0);
        _hidl_blob.putBool(88 + _hidl_offset, this.isOISEnable);
        long _hidl_array_offset_02 = 96 + _hidl_offset;
        double[] _hidl_array_item_02 = this.motorTime;
        if (_hidl_array_item_02 == null || _hidl_array_item_02.length != 3) {
            throw new IllegalArgumentException("Array element is not of the expected length");
        }
        _hidl_blob.putDoubleArray(_hidl_array_offset_02, _hidl_array_item_02);
    }
}
