package com.oplus.util;

import android.content.Context;
import android.content.pm.Signature;

/* loaded from: classes.dex */
public class OplusSignatureVerifier {
    private static final String TAG = "SignatureVerifier";
    private static OplusSignatureUpdater mColorSignatureUpdater;

    public static void initUpdater(OplusSignatureUpdater updater) {
        mColorSignatureUpdater = updater;
    }

    public static boolean verificaionPass(Context context) {
        return true;
    }

    private static boolean isSystemApp(Context context, String packageName) {
        return true;
    }

    public static String getMD5Signature(Context context, String packageName) {
        return "";
    }
}
