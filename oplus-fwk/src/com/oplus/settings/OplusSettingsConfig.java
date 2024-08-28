package com.oplus.settings;

import android.net.Uri;
import android.os.UserHandle;
import java.io.File;

/* loaded from: classes4.dex */
public final class OplusSettingsConfig {
    private static final String CONFIG_PATH = "/data/oplus";
    public static final String PARAMS_TYPE = "ParamsType";
    public static final String PARAMS_USER_ID = "ParamsUserId";
    private static final String TAG = "CSConfig";
    protected static final int TYPE_OPLUS = 0;

    private static String transferTypeToStr(int type) {
        switch (type) {
            case 0:
                return "os";
            default:
                throw new IllegalArgumentException("Error type=" + type);
        }
    }

    public static String getFilePath(int type, int userId, String customPath) {
        String typeStr = transferTypeToStr(type);
        if (userId == 0) {
            String path = CONFIG_PATH + File.separator + typeStr + File.separator + customPath;
            return path;
        } else if (userId == -2) {
            int userId2 = UserHandle.myUserId();
            if (userId2 == 0) {
                String path2 = CONFIG_PATH + File.separator + typeStr + File.separator + customPath;
                return path2;
            }
            String path3 = CONFIG_PATH + File.separator + typeStr + File.separator + userId2 + File.separator + customPath;
            return path3;
        } else if (userId < 0) {
            throw new IllegalArgumentException("Error userId=" + userId);
        } else {
            String path4 = CONFIG_PATH + File.separator + typeStr + File.separator + userId + File.separator + customPath;
            return path4;
        }
    }

    public static Uri getUri(String base, String path, int userId, int type) {
        Uri uri = Uri.parse(base);
        Uri.Builder builder = uri.buildUpon();
        builder.appendQueryParameter(PARAMS_TYPE, String.valueOf(type));
        if (userId == -2) {
            userId = UserHandle.myUserId();
        }
        builder.appendQueryParameter(PARAMS_USER_ID, String.valueOf(userId));
        builder.encodedPath(path);
        Uri uri2 = builder.build();
        return uri2;
    }
}
