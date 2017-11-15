package android.content.pm;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract interface IPackageMoveObserver
        extends IInterface
{
    public abstract void packageMoved(String paramString, int paramInt)
            throws RemoteException;

    public static abstract class Stub
            extends Binder
            implements IPackageMoveObserver
    {
        private static final String DESCRIPTOR = "android.content.pm.IPackageMoveObserver";
        static final int TRANSACTION_packageMoved = 1;

        public Stub()
        {
            attachInterface(this, "android.content.pm.IPackageMoveObserver");
        }

        public static IPackageMoveObserver asInterface(IBinder obj)
        {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface("android.content.pm.IPackageMoveObserver");
            if ((iin != null) && ((iin instanceof IPackageMoveObserver))) {
                return (IPackageMoveObserver)iin;
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
                    reply.writeString("android.content.pm.IPackageMoveObserver");
                    return true;
                case 1:
                    data.enforceInterface("android.content.pm.IPackageMoveObserver");

                    String _arg0 = data.readString();

                    int _arg1 = data.readInt();
                    packageMoved(_arg0, _arg1);
                    return true;
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy
                implements IPackageMoveObserver
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
                return "android.content.pm.IPackageMoveObserver";
            }

            public void packageMoved(String packageName, int returnCode)
                    throws RemoteException
            {
                Parcel _data = Parcel.obtain();
                try
                {
                    _data.writeInterfaceToken("android.content.pm.IPackageMoveObserver");
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
