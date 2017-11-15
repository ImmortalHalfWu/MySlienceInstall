package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IPackageDataObserver
        extends IInterface
{
    public abstract void onRemoveCompleted(String paramString, boolean paramBoolean)
            throws RemoteException;

    public static abstract class Stub
            extends Binder
            implements IPackageDataObserver
    {
        private static final String DESCRIPTOR = "android.content.pm.IPackageDataObserver";
        static final int TRANSACTION_onRemoveCompleted = 1;

        public Stub()
        {
            attachInterface(this, "android.content.pm.IPackageDataObserver");
        }

        public static IPackageDataObserver asInterface(IBinder obj)
        {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface("android.content.pm.IPackageDataObserver");
            if ((iin != null) && ((iin instanceof IPackageDataObserver))) {
                return (IPackageDataObserver)iin;
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
                    reply.writeString("android.content.pm.IPackageDataObserver");
                    return true;
                case 1:
                    data.enforceInterface("android.content.pm.IPackageDataObserver");

                    String _arg0 = data.readString();

                    boolean _arg1 = 0 != data.readInt();
                    onRemoveCompleted(_arg0, _arg1);
                    return true;
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy
                implements IPackageDataObserver
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
                return "android.content.pm.IPackageDataObserver";
            }

            public void onRemoveCompleted(String packageName, boolean succeeded)
                    throws RemoteException
            {
                Parcel _data = Parcel.obtain();
                try
                {
                    _data.writeInterfaceToken("android.content.pm.IPackageDataObserver");
                    _data.writeString(packageName);
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
