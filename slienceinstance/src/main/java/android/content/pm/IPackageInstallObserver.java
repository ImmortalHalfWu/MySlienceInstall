package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IPackageInstallObserver
        extends IInterface
{
    public abstract void packageInstalled(String paramString, int paramInt)
            throws RemoteException;

    public static abstract class Stub
            extends Binder
            implements IPackageInstallObserver
    {
        private static final String DESCRIPTOR = "android.content.pm.IPackageInstallObserver";
        static final int TRANSACTION_packageInstalled = 1;

        public Stub()
        {
            attachInterface(this, "android.content.pm.IPackageInstallObserver");
        }

        public static IPackageInstallObserver asInterface(IBinder obj)
        {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface("android.content.pm.IPackageInstallObserver");
            if ((iin != null) && ((iin instanceof IPackageInstallObserver))) {
                return (IPackageInstallObserver)iin;
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
                    reply.writeString("android.content.pm.IPackageInstallObserver");
                    return true;
                case 1:
                    data.enforceInterface("android.content.pm.IPackageInstallObserver");

                    String _arg0 = data.readString();

                    int _arg1 = data.readInt();
                    packageInstalled(_arg0, _arg1);
                    return true;
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy
                implements IPackageInstallObserver
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
                return "android.content.pm.IPackageInstallObserver";
            }

            public void packageInstalled(String packageName, int returnCode)
                    throws RemoteException
            {
                Parcel _data = Parcel.obtain();
                try
                {
                    _data.writeInterfaceToken("android.content.pm.IPackageInstallObserver");
                    _data.writeString(packageName);
                    _data.writeInt(returnCode);
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
