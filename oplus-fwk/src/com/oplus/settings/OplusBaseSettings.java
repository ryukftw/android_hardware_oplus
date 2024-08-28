package com.oplus.settings;

import android.app.ActivityThread;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.SystemProperties;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* loaded from: classes4.dex */
public class OplusBaseSettings {
    private static final String BASE_URI = "content://OplusSettings";
    private static final boolean DEBUG = SystemProperties.getBoolean("persist.sys.assert.panic", false);
    private static final String TAG = "OplusBaseSettings";

    public static InputStream readConfigAsUser(Context context, String customPath, int userId, int type) throws IOException {
        if (isSystemProcess()) {
            String path = OplusSettingsConfig.getFilePath(type, userId, customPath);
            if (DEBUG) {
                Log.d(TAG, "readConfigAsUser systemUser path=" + path + " type=" + type + " userId=" + userId + " customPath=" + customPath);
            }
            return new FileInputStream(path);
        }
        Uri uri = OplusSettingsConfig.getUri(BASE_URI, customPath, userId, type);
        ContentResolver cr = context.getContentResolver();
        return cr.openInputStream(uri);
    }

    public static OutputStream writeConfigAsUser(Context context, String customPath, int userId, int type) throws IOException {
        Uri uri = OplusSettingsConfig.getUri(BASE_URI, customPath, userId, type);
        if (DEBUG) {
            Log.d(TAG, "writeConfigAsUser customPath=" + customPath + " userId=" + userId + " type=" + type + " uri=" + uri.toString());
        }
        if (isSystemProcess()) {
            String path = OplusSettingsConfig.getFilePath(type, userId, customPath);
            File file = new File(path);
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            return new OplusFileOutputStream(path, context.getContentResolver(), uri);
        }
        ContentResolver cr = context.getContentResolver();
        AssetFileDescriptor fd = cr.openAssetFileDescriptor(uri, "w", null);
        if (fd == null) {
            return null;
        }
        try {
            long len = fd.getDeclaredLength();
            if (len < 0) {
                return new ParcelFileAutoCloseOutputStream(fd.getParcelFileDescriptor(), context.getContentResolver(), uri);
            }
            return new AssertFileAutoCloseOutputStream(fd, context.getContentResolver(), uri);
        } catch (IOException e) {
            throw new FileNotFoundException("Unable to create stream");
        }
    }

    public static String readConfigStringAsUser(Context context, String customPath, int userId, int type) throws IOException {
        InputStream is = null;
        BufferedReader br = null;
        try {
            is = readConfigAsUser(context, customPath, userId, type);
            if (is == null) {
                Log.e(TAG, "readConfig error is is null");
                return null;
            }
            BufferedReader br2 = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String lineTxt = br2.readLine();
                if (lineTxt == null) {
                    break;
                }
                sb.append(lineTxt);
            }
            String sb2 = sb.toString();
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    Log.e(TAG, "readConfig close is error", e);
                }
            }
            try {
                br2.close();
            } catch (IOException e2) {
                Log.e(TAG, "readConfig close br error", e2);
            }
            return sb2;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e3) {
                    Log.e(TAG, "readConfig close is error", e3);
                }
            }
            if (0 != 0) {
                try {
                    br.close();
                } catch (IOException e4) {
                    Log.e(TAG, "readConfig close br error", e4);
                }
            }
        }
    }

    public static int writeConfigStringAsUser(Context context, String customPath, int userId, int type, String str) throws IOException {
        OutputStream os = null;
        BufferedWriter bw = null;
        try {
            os = writeConfigAsUser(context, customPath, userId, type);
            if (os == null) {
                Log.e(TAG, "writeConfig error os is null");
                return -2;
            }
            BufferedWriter bw2 = new BufferedWriter(new OutputStreamWriter(os));
            bw2.write(str);
            bw2.flush();
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    Log.e(TAG, "writeConfig close os error", e);
                }
            }
            try {
                bw2.close();
            } catch (IOException e2) {
                Log.e(TAG, "writeConfig close bw error", e2);
            }
            return 0;
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e3) {
                    Log.e(TAG, "writeConfig close os error", e3);
                }
            }
            if (0 != 0) {
                try {
                    bw.close();
                } catch (IOException e4) {
                    Log.e(TAG, "writeConfig close bw error", e4);
                }
            }
        }
    }

    public static void registerChangeListenerAsUser(Context context, String customPath, int userId, int type, OplusSettingsChangeListener listener) {
        Uri uri = OplusSettingsConfig.getUri(BASE_URI, customPath, userId, type);
        context.getContentResolver().registerContentObserver(uri, true, listener);
    }

    public static void registerChangeListenerForAll(Context context, String customPath, int type, OplusSettingsChangeListener listener) {
        Uri uri = OplusSettingsConfig.getUri(BASE_URI, customPath, -2, type);
        context.getContentResolver().registerContentObserver(uri, true, listener, -1);
    }

    public static boolean isSystemProcess() {
        return ActivityThread.isSystem();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class OplusFileOutputStream extends FileOutputStream {
        private int callCount;
        private final ContentResolver contentResolver;
        private final Uri uri;

        public OplusFileOutputStream(String s, ContentResolver cr, Uri uri) throws FileNotFoundException {
            super(s);
            this.callCount = 1;
            this.contentResolver = cr;
            this.uri = uri;
        }

        @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            int i;
            super.close();
            ContentResolver contentResolver = this.contentResolver;
            if (contentResolver != null && (i = this.callCount) >= 1) {
                this.callCount = i - 1;
                contentResolver.update(this.uri, new ContentValues(), null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class ParcelFileAutoCloseOutputStream extends ParcelFileDescriptor.AutoCloseOutputStream {
        private int callCount;
        private final ContentResolver contentResolver;
        private final Uri uri;

        ParcelFileAutoCloseOutputStream(ParcelFileDescriptor parcelFileDescriptor, ContentResolver cr, Uri uri) {
            super(parcelFileDescriptor);
            this.callCount = 1;
            this.contentResolver = cr;
            this.uri = uri;
        }

        @Override // android.os.ParcelFileDescriptor.AutoCloseOutputStream, java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            int i;
            super.close();
            ContentResolver contentResolver = this.contentResolver;
            if (contentResolver != null && (i = this.callCount) >= 1) {
                this.callCount = i - 1;
                contentResolver.update(this.uri, new ContentValues(), null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class AssertFileAutoCloseOutputStream extends AssetFileDescriptor.AutoCloseOutputStream {
        private int callCount;
        private final ContentResolver contentResolver;
        private final Uri uri;

        AssertFileAutoCloseOutputStream(AssetFileDescriptor assetFileDescriptor, ContentResolver cr, Uri uri) throws IOException {
            super(assetFileDescriptor);
            this.callCount = 1;
            this.contentResolver = cr;
            this.uri = uri;
        }

        @Override // android.os.ParcelFileDescriptor.AutoCloseOutputStream, java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            int i;
            super.close();
            ContentResolver contentResolver = this.contentResolver;
            if (contentResolver != null && (i = this.callCount) >= 1) {
                this.callCount = i - 1;
                contentResolver.update(this.uri, new ContentValues(), null, null);
            }
        }
    }
}
