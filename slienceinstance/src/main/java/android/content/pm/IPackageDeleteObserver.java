package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IPackageDeleteObserver
        extends IInterface
{
    public abstract void packageDeleted(String paramString, int paramInt)
            throws RemoteException;

    public static abstract class Stub
            extends Binder
            implements IPackageDeleteObserver
    {
        private static final String DESCRIPTOR = "android.content.pm.IPackageDeleteObserver";
        static final int TRANSACTION_packageDeleted = 1;

        public Stub()
        {
            attachInterface(this, "android.content.pm.IPackageDeleteObserver");
        }

        public static IPackageDeleteObserver asInterface(IBinder obj)
        {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface("android.content.pm.IPackageDeleteObserver");
            if ((iin != null) && ((iin instanceof IPackageDeleteObserver))) {
                return (IPackageDeleteObserver)iin;
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
                    reply.writeString("android.content.pm.IPackageDeleteObserver");
                    return true;
                case 1:
                    data.enforceInterface("android.content.pm.IPackageDeleteObserver");

                    String _arg0 = data.readString();

                    int _arg1 = data.readInt();
                    packageDeleted(_arg0, _arg1);
                    return true;
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy
                implements IPackageDeleteObserver
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
                return "android.content.pm.IPackageDeleteObserver";
            }

            public void packageDeleted(String packageName, int returnCode)
                    throws RemoteException
            {
                Parcel _data = Parcel.obtain();
                try
                {
                    _data.writeInterfaceToken("android.content.pm.IPackageDeleteObserver");
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
