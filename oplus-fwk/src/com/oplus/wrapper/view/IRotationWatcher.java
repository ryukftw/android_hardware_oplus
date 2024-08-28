package com.oplus.wrapper.view;

import android.os.IInterface;
import android.os.RemoteException;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because "blocks" is null
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:977)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:379)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:128)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:51)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:47)
    */
/* loaded from: classes.dex */
public interface IRotationWatcher {
    void onRotationChanged(int i) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub implements IInterface, IRotationWatcher {
        private final android.view.IRotationWatcher mRotationWatcher;

        public Stub(android.view.IRotationWatcher rotationWatcher) {
            // Initialize mRotationWatcher in the constructor
            this.mRotationWatcher = rotationWatcher;
        }

        /*  JADX ERROR: NullPointerException in pass: InlineMethods
            java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.nodes.MethodNode.getBasicBlocks()" is null
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:48)
            */
        public static com.oplus.wrapper.view.IRotationWatcher asInterface(android.os.IBinder r2) {
            /*
                com.oplus.wrapper.view.IRotationWatcher$Stub$Proxy r0 = new com.oplus.wrapper.view.IRotationWatcher$Stub$Proxy
                android.view.IRotationWatcher r1 = android.view.IRotationWatcher.Stub.asInterface(r2)
                r0.<init>(r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.wrapper.view.IRotationWatcher.Stub.asInterface(android.os.IBinder):com.oplus.wrapper.view.IRotationWatcher");
        }

        /*  JADX ERROR: NullPointerException in pass: InlineMethods
            java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.nodes.MethodNode.getBasicBlocks()" is null
            	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:48)
            */
        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            /*
                r1 = this;
                android.view.IRotationWatcher r0 = r1.mRotationWatcher
                android.os.IBinder r0 = r0.asBinder()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.oplus.wrapper.view.IRotationWatcher.Stub.asBinder():android.os.IBinder");
        }

        /* loaded from: classes.dex */
        private static class Proxy implements IRotationWatcher {
            private final android.view.IRotationWatcher mRotationWatcher;

            /*  JADX ERROR: NullPointerException in pass: InlineMethods
                java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.nodes.MethodNode.getBasicBlocks()" is null
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:48)
                */
            Proxy(android.view.IRotationWatcher r1) {
                /*
                    r0 = this;
                    r0.<init>()
                    r0.mRotationWatcher = r1
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.wrapper.view.IRotationWatcher.Stub.Proxy.<init>(android.view.IRotationWatcher):void");
            }

            /*  JADX ERROR: NullPointerException in pass: InlineMethods
                java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.nodes.MethodNode.getBasicBlocks()" is null
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:48)
                */
            @Override // com.oplus.wrapper.view.IRotationWatcher
            public void onRotationChanged(int r2) throws android.os.RemoteException {
                /*
                    r1 = this;
                    android.view.IRotationWatcher r0 = r1.mRotationWatcher
                    r0.onRotationChanged(r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.wrapper.view.IRotationWatcher.Stub.Proxy.onRotationChanged(int):void");
            }
        }
    }
}
