package com.immortal.half.wu.slienceinstance.core;

import android.content.pm.IPackageDeleteObserver;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.support.annotation.NonNull;

import com.immortal.half.wu.slienceinstance.core.interfaces.DeleteApkInterface;
import com.immortal.half.wu.slienceinstance.core.interfaces.OperationApkCallBack;
import com.immortal.half.wu.slienceinstance.models.SimpleApkInfo;
import com.immortal.half.wu.slienceinstance.utils.Loger;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/11/15  9:57
 */

class DeleteApkUtil implements DeleteApkInterface<SimpleApkInfo>
{
    private static DeleteApkUtil deleteApkUtil;

    public static DeleteApkUtil instance()
    {
        return deleteApkUtil == null ? (deleteApkUtil = new DeleteApkUtil()) : deleteApkUtil;
    }

    @Override
    public void deleteApk(SimpleApkInfo simpleApkInfo, PackageManager packageManager, OperationApkCallBack<SimpleApkInfo> callBack)
    {
        slienceDeleteApk(simpleApkInfo, packageManager, callBack);
    }

    @Override
    public void slienceDeleteApk(SimpleApkInfo simpleApkInfo, PackageManager packageManager, OperationApkCallBack<SimpleApkInfo> callBack)
    {
        packageManager.deletePackage(simpleApkInfo
                .getPackageName(), new InstallObserver<>(simpleApkInfo,callBack), 0);
    }

    private static class InstallObserver<ApkInfo> extends IPackageDeleteObserver.Stub {
        private OperationApkCallBack<ApkInfo> callBack;
        private ApkInfo apkInfo;

        InstallObserver(@NonNull ApkInfo apkInfo, @NonNull OperationApkCallBack<ApkInfo> callBack)
        {
            this.apkInfo = apkInfo;
            this.callBack = callBack;
        }

        @Override
        public void packageDeleted(String packageName, int returnCode)
                throws RemoteException
        {
            Loger.d(InstallObserver.class.getName() + "\t" + "packageName : " + packageName + "\t" + "returnCode : " + returnCode);
            this.callBack.callBack(apkInfo, returnCode);
            this.callBack = null;
        }
    }
}
