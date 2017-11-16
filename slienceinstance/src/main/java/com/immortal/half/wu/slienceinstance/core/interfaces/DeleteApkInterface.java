package com.immortal.half.wu.slienceinstance.core.interfaces;

import android.content.pm.PackageManager;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/11/15  9:54
 */

public interface DeleteApkInterface<ApkInfo>
{
    void deleteApk(ApkInfo paramApkInfo, PackageManager paramPackageManager, OperationApkCallBack<ApkInfo> paramOperationApkCallBack);

    void slienceDeleteApk(ApkInfo paramApkInfo, PackageManager paramPackageManager, OperationApkCallBack<ApkInfo> paramOperationApkCallBack);
}
