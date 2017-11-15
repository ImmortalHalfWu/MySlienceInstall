package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IPackageStatsObserver
        extends IInterface
{
    public abstract void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean)
            throws RemoteException;

    public static abstract class Stub
            extends Binder
            implements IPackageStatsObserver
    {
        private static final String DESCRIPTOR = "android.content.pm.IPackageStatsObserver";
        static final int TRANSACTION_onGetStatsCompleted = 1;

        public Stub()
        {
            attachInterface(this, "android.content.pm.IPackageStatsObserver");
        }

        public static IPackageStatsObserver asInterface(IBinder obj)
        {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface("android.content.pm.IPackageStatsObserver");
            if ((iin != null) && ((iin instanceof IPackageStatsObserver))) {
                return (IPackageStatsObserver)iin;
            }
            return new Proxy(obj);
        }

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
                throws RemoteException
        {
            switch (code)
            {
                case 1598968902:
                    reply.writeString("android.content.pm.IPackageStatsObserver");
                    return true;
                case 1:
                    data.enforceInterface("android.content.pm.IPackageStatsObserver");
                    PackageStats _arg0;
                    if (0 != data.readInt()) {
                        _arg0 = (PackageStats)PackageStats.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    boolean _arg1 = 0 != data.readInt();
                    onGetStatsCompleted(_arg0, _arg1);
                    return true;
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy
                implements IPackageStatsObserver
        {
            private IBinder mRemote;

            Proxy(IBinder remote)
            {
                this.mRemote = remote;
            }

            public IBinder asBinder()
            {
                return this.mRemote;
            }

            public String getInterfaceDescriptor()
            {
                return "android.content.pm.IPackageStatsObserver";
            }

            public void onGetStatsCompleted(PackageStats pStats, boolean succeeded)
                    throws RemoteException
            {
                Parcel _data = Parcel.obtain();
                try
                {
                    _data.writeInterfaceToken("android.content.pm.IPackageStatsObserver");
                    if (pStats != null)
                    {
                        _data.writeInt(1);
                        pStats.writeToParcel(_data, 0);
                    }
                    else
                    {
                        _data.writeInt(0);
                    }
                    _data.writeInt(succeeded ? 1 : 0);
                    this.mRemote.transact(1, _data, null, 1);
                }
                finally
                {
                    _data.recycle();
                }
            }
        }
    }
}
