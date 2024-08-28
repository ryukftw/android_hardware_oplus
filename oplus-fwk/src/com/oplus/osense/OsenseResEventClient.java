package com.oplus.osense;

public class OsenseResEventClient {

    private static volatile OsenseResEventClient sInstance;

    private OsenseResEventClient() {
    }

    public static OsenseResEventClient getInstance() {
        if (sInstance == null) {
            synchronized (OsenseResEventClient.class) {
                if (sInstance == null) {
                    sInstance = new OsenseResEventClient();
                }
            }
        }
        return sInstance;
    }
}
