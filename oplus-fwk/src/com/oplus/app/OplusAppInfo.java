package com.oplus.app;

import android.content.ComponentName;
import android.content.pm.ApplicationInfo;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class OplusAppInfo implements Parcelable {
    public static final int ACTIVITY_TYPE_ASSISTANT = 4;
    public static final int ACTIVITY_TYPE_HOME = 2;
    public static final int ACTIVITY_TYPE_RECENTS = 3;
    public static final int ACTIVITY_TYPE_STANDARD = 1;
    public static final int ACTIVITY_TYPE_UNDEFINED = 0;
    public static final Parcelable.Creator<OplusAppInfo> CREATOR = new Parcelable.Creator<OplusAppInfo>() { // from class: com.oplus.app.OplusAppInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OplusAppInfo createFromParcel(Parcel source) {
            return new OplusAppInfo(source);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OplusAppInfo[] newArray(int size) {
            return new OplusAppInfo[size];
        }
    };
    public static final int WINDOWING_MODE_FREEFORM = 5;
    public static final int WINDOWING_MODE_FULLSCREEN = 1;
    public static final int WINDOWING_MODE_PINNED = 2;
    public static final int WINDOWING_MODE_SPLIT_SCREEN_PRIMARY = 3;
    public static final int WINDOWING_MODE_SPLIT_SCREEN_SECONDARY = 4;
    public static final int WINDOWING_MODE_UNDEFINED = 0;
    public int activityType;
    public Rect appBounds;
    public ApplicationInfo appInfo;
    public int displayId;
    public Bundle extension;
    public boolean isRootActivity;
    public String launchedFromPackage;
    public int orientation;
    public int taskId;
    public ComponentName topActivity;
    public int userId;
    public int windowingMode;

    public OplusAppInfo() {
        this.appBounds = new Rect();
        this.orientation = -1;
        this.isRootActivity = false;
        this.extension = new Bundle();
    }

    public OplusAppInfo(OplusAppInfo info) {
        this.appBounds = new Rect();
        this.orientation = -1;
        this.isRootActivity = false;
        this.extension = new Bundle();
        if (info != null) {
            this.windowingMode = info.windowingMode;
            this.activityType = info.activityType;
            this.appBounds = info.appBounds;
            this.taskId = info.taskId;
            this.topActivity = info.topActivity;
            this.displayId = info.displayId;
            this.orientation = info.orientation;
            this.userId = info.userId;
            this.launchedFromPackage = info.launchedFromPackage;
            this.isRootActivity = info.isRootActivity;
            this.extension = info.extension;
        }
    }

    public OplusAppInfo(Parcel source) {
        this.appBounds = new Rect();
        this.orientation = -1;
        this.isRootActivity = false;
        this.extension = new Bundle();
        readFromParcel(source);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel source) {
        this.windowingMode = source.readInt();
        this.activityType = source.readInt();
        this.taskId = source.readInt();
        this.appBounds = (Rect) source.readParcelable(Rect.class.getClassLoader());
        if (source.readInt() != 0) {
            this.appInfo = ApplicationInfo.CREATOR.createFromParcel(source);
        }
        if (source.readInt() != 0) {
            this.topActivity = ComponentName.CREATOR.createFromParcel(source);
        }
        this.displayId = source.readInt();
        this.orientation = source.readInt();
        this.userId = source.readInt();
        this.launchedFromPackage = source.readString();
        this.isRootActivity = source.readBoolean();
        this.extension = source.readBundle();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.windowingMode);
        dest.writeInt(this.activityType);
        dest.writeInt(this.taskId);
        dest.writeParcelable(this.appBounds, flags);
        if (this.appInfo != null) {
            dest.writeInt(1);
            this.appInfo.writeToParcel(dest, flags);
        } else {
            dest.writeInt(0);
        }
        if (this.topActivity != null) {
            dest.writeInt(1);
            this.topActivity.writeToParcel(dest, flags);
        } else {
            dest.writeInt(0);
        }
        dest.writeInt(this.displayId);
        dest.writeInt(this.orientation);
        dest.writeInt(this.userId);
        dest.writeString(this.launchedFromPackage);
        dest.writeBoolean(this.isRootActivity);
        dest.writeBundle(this.extension);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OplusAppInfo{");
        sb.append("windowingMode=" + this.windowingMode);
        sb.append(", activityType=" + this.activityType);
        sb.append(", taskId=" + this.taskId);
        sb.append(", appBounds=" + this.appBounds);
        sb.append(", appInfo=" + this.appInfo);
        sb.append(", topActivity=" + this.topActivity);
        sb.append(", displayId=" + this.displayId);
        sb.append(", orientation=" + this.orientation);
        sb.append(", userId=" + this.userId);
        sb.append(", launchedFromPackage=" + this.launchedFromPackage);
        sb.append(", isRootActivity=" + this.isRootActivity);
        sb.append(", extension=" + this.extension);
        sb.append("}");
        return sb.toString();
    }
}
