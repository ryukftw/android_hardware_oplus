package com.oplus.wrapper.view;

import android.app.IApplicationThread;
import android.app.IAssistDataReceiver;
import android.content.ComponentName;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.IRemoteCallback;
import android.os.RemoteException;
import android.view.IAppTransitionAnimationSpecsFuture;
import android.view.ICrossWindowBlurEnabledListener;
import android.view.IDecorViewGestureListener;
import android.view.IDisplayChangeWindowController;
import android.view.IDisplayFoldListener;
import android.view.IDisplayWindowInsetsController;
import android.view.IDisplayWindowListener;
import android.view.IOnKeyguardExitResult;
import android.view.IPinnedTaskListener;
import android.view.IRotationWatcher;
import android.view.IScrollCaptureResponseListener;
import android.view.ISystemGestureExclusionListener;
import android.view.IWallpaperVisibilityListener;
import android.view.IWindow;
import android.view.IWindowSession;
import android.view.IWindowSessionCallback;
import android.view.InputChannel;
import android.view.InsetsState;
import android.view.TaskTransitionSpec;
import android.view.WindowContentFrameStats;
import android.view.displayhash.DisplayHash;
import android.view.displayhash.VerifiedDisplayHash;
import android.window.AddToSurfaceSyncGroupResult;
import android.window.IGlobalDragListener;
import android.window.IScreenRecordingCallback;
import android.window.ISurfaceSyncGroupCompletedListener;
import android.window.ITaskFpsCallback;
import android.window.ITrustedPresentationListener;
import android.window.InputTransferToken;
import android.window.TrustedPresentationThresholds;
import android.window.ScreenCapture;
import android.window.WindowContextInfo;
import com.android.internal.os.IResultReceiver;
import com.android.internal.policy.IKeyguardDismissCallback;
import com.android.internal.policy.IKeyguardLockedStateListener;
import com.android.internal.policy.IShortcutService;
import com.oplus.wrapper.view.IWindowManager;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* loaded from: classes.dex */
public interface IWindowManager {
    int getBaseDisplayDensity(int i) throws RemoteException;

    void getBaseDisplaySize(int i, Point point) throws RemoteException;

    int getDockedStackSide() throws RemoteException;

    int getInitialDisplayDensity(int i) throws RemoteException;

    boolean hasNavigationBar(int i) throws RemoteException;

    void removeRotationWatcher(IRotationWatcher iRotationWatcher) throws RemoteException;

    void setForcedDisplayDensityForUser(int i, int i2, int i3) throws RemoteException;

    int watchRotation(IRotationWatcher iRotationWatcher, int i) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub implements android.os.IInterface, android.view.IWindowManager {

        private final android.view.IWindowManager mIWindowManager;

        public Stub(android.view.IWindowManager windowManager) {
            this.mIWindowManager = windowManager;
        }

        public static IWindowManager asInterface(IBinder obj) {
            return new Proxy(android.view.IWindowManager.Stub.asInterface(obj));
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.mIWindowManager.asBinder();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IWindowManager {
            private static Map<IRotationWatcher, android.view.IRotationWatcher> sRotationWatcherMap = new ConcurrentHashMap();
            private final android.view.IWindowManager mIWindowManager;

            Proxy(android.view.IWindowManager iWindowManager) {
                this.mIWindowManager = iWindowManager;
            }

            @Override // com.oplus.wrapper.view.IWindowManager
            public int getDockedStackSide() throws RemoteException {
                return this.mIWindowManager.getDockedStackSide();
            }

            @Override // com.oplus.wrapper.view.IWindowManager
            public int getInitialDisplayDensity(int displayId) throws RemoteException {
                return this.mIWindowManager.getInitialDisplayDensity(displayId);
            }

            @Override // com.oplus.wrapper.view.IWindowManager
            public boolean hasNavigationBar(int displayId) throws RemoteException {
                return this.mIWindowManager.hasNavigationBar(displayId);
            }

            @Override // com.oplus.wrapper.view.IWindowManager
            public int watchRotation(IRotationWatcher watcher, int displayId) throws RemoteException {
                android.view.IRotationWatcher rotationWatcher = sRotationWatcherMap.computeIfAbsent(watcher, new Function() { // from class: com.oplus.wrapper.view.IWindowManager$Stub$Proxy$$ExternalSyntheticLambda0
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        android.view.IRotationWatcher lambda$watchRotation$0;
                        lambda$watchRotation$0 = IWindowManager.Stub.Proxy.this.lambda$watchRotation$0((IRotationWatcher) obj);
                        return lambda$watchRotation$0;
                    }
                });
                return this.mIWindowManager.watchRotation(rotationWatcher, displayId);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ android.view.IRotationWatcher lambda$watchRotation$0(final IRotationWatcher observer) {
                return new IRotationWatcher.Stub() { // from class: com.oplus.wrapper.view.IWindowManager.Stub.Proxy.1
                    public void onRotationChanged(int rotation) throws RemoteException {
                        observer.onRotationChanged(rotation);
                    }
                };
            }

            @Override // com.oplus.wrapper.view.IWindowManager
            public void removeRotationWatcher(IRotationWatcher watcher) throws RemoteException {
                android.view.IRotationWatcher rotationWatcher = sRotationWatcherMap.get(watcher);
                if (rotationWatcher == null) {
                    return;
                }
                sRotationWatcherMap.remove(watcher);
                this.mIWindowManager.removeRotationWatcher(rotationWatcher);
            }

            @Override // com.oplus.wrapper.view.IWindowManager
            public void setForcedDisplayDensityForUser(int displayId, int density, int userId) throws RemoteException {
                this.mIWindowManager.setForcedDisplayDensityForUser(displayId, density, userId);
            }

            @Override // com.oplus.wrapper.view.IWindowManager
            public int getBaseDisplayDensity(int displayId) throws RemoteException {
                return this.mIWindowManager.getBaseDisplayDensity(displayId);
            }

            @Override // com.oplus.wrapper.view.IWindowManager
            public void getBaseDisplaySize(int displayId, Point size) throws RemoteException {
                this.mIWindowManager.getBaseDisplaySize(displayId, size);
            }
        }
    }
}

