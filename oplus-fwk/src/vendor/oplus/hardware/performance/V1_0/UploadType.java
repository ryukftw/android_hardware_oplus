package vendor.oplus.hardware.performance.V1_0;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class UploadType {
    public static final int DELTA = 1;
    public static final int PRIMITIVE = 0;
    public static final int SKIP = 2;

    public static final String toString(int o) {
        if (o == 0) {
            return "PRIMITIVE";
        }
        if (o == 1) {
            return "DELTA";
        }
        if (o == 2) {
            return "SKIP";
        }
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        int flipped = 0;
        list.add("PRIMITIVE");
        if ((o & 1) == 1) {
            list.add("DELTA");
            flipped = 0 | 1;
        }
        if ((o & 2) == 2) {
            list.add("SKIP");
            flipped |= 2;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((~flipped) & o));
        }
        return String.join(" | ", list);
    }
}