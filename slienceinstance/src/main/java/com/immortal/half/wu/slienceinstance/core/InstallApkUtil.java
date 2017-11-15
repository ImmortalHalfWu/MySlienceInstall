package com.immortal.half.wu.slienceinstance.core;

import android.content.pm.IPackageInstallObserver;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.NonNull;

import com.immortal.half.wu.slienceinstance.core.interfaces.InstallApkInterface;
import com.immortal.half.wu.slienceinstance.core.interfaces.OperationApkCallBack;
import com.immortal.half.wu.slienceinstance.models.SimpleApkInfo;
import com.immortal.half.wu.slienceinstance.utils.Loger;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/11/15  10:00
 */

class InstallApkUtil   implements InstallApkInterface<SimpleApkInfo>
{
    private static InstallApkUtil installApkUtill;

    public static InstallApkUtil instance()
    {
        return installApkUtill == null ? (installApkUtill = new InstallApkUtil()) : installApkUtill;
    }

    public void installApk(SimpleApkInfo simpleApkInfo, PackageManager packageManager, OperationApkCallBack callBack)
    {
        slienceInstallApk(simpleApkInfo, packageManager, callBack);
    }

    public void slienceInstallApk(SimpleApkInfo simpleApkInfo, PackageManager packageManager, OperationApkCallBack callBack)
    {
        packageManager.installPackage(
                Uri.fromFile(simpleApkInfo.getApkFile()), new InstallObserver(callBack), 2, simpleApkInfo
                        .getPackageName());
    }

    private static class InstallObserver
            extends IPackageInstallObserver.Stub
    {
        private OperationApkCallBack callBack;

        public InstallObserver(@NonNull OperationApkCallBack callBack)
        {
            this.callBack = callBack;
        }

        @Override
        public void packageInstalled(String packageName, int returnCode)
                throws RemoteException
        {
            Loger.d(InstallObserver.class.getName() + "\t" + "packageName : " + packageName + "\t" + "returnCode : " + returnCode);
            this.callBack.callBack(packageName, returnCode);
            this.callBack = null;
        }
    }
}