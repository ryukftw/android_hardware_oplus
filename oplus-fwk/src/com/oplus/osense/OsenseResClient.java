package com.oplus.osense;

import android.util.Log;
import java.util.HashMap;

/* loaded from: classes.dex */
public class OsenseResClient {
    private static HashMap<String, OsenseResClient> sOsenseResClientMap = new HashMap<>();
    private static final String TAG = OsenseResClient.class.getSimpleName();

    public static OsenseResClient get(Class cls) {
        OsenseResClient resClient;
        if (cls == null) {
            Log.e(TAG, "the parameter class is null!!!");
            return null;
        }
        String className = cls.getSimpleName();
        synchronized (sOsenseResClientMap) {
            resClient = sOsenseResClientMap.get(className);
        }
        return resClient;
    }
}
