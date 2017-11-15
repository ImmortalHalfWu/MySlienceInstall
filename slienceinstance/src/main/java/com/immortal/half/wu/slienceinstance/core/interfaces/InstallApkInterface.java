package com.immortal.half.wu.slienceinstance.core.interfaces;

import android.content.pm.PackageManager;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/11/15  9:55
 */

public interface InstallApkInterface<ApkInfo>
{
    void installApk(ApkInfo paramApkInfo, PackageManager paramPackageManager, OperationApkCallBack paramOperationApkCallBack);

    void slienceInstallApk(ApkInfo paramApkInfo, PackageManager paramPackageManager, OperationApkCallBack paramOperationApkCallBack);
}
