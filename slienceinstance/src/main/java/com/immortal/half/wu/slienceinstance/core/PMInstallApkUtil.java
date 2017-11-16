package com.immortal.half.wu.slienceinstance.core;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import com.immortal.half.wu.slienceinstance.core.interfaces.InstallApkInterface;
import com.immortal.half.wu.slienceinstance.core.interfaces.OperationApkCallBack;
import com.immortal.half.wu.slienceinstance.models.SimpleApkInfo;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/11/15  10:13
 */

class PMInstallApkUtil implements InstallApkInterface<SimpleApkInfo> {

    private static PMInstallApkUtil pmInstallApkUtil;
    private static final String PM_STRING = "pm install -r ";

    public static PMInstallApkUtil instance(){
        return pmInstallApkUtil == null ? pmInstallApkUtil = new PMInstallApkUtil() : pmInstallApkUtil;
    }

    @Override
    public void installApk(SimpleApkInfo paramApkInfo, PackageManager paramPackageManager, OperationApkCallBack<SimpleApkInfo> paramOperationApkCallBack) {
        slienceInstallApk(paramApkInfo,paramPackageManager,paramOperationApkCallBack);
    }

    @Override
    public void slienceInstallApk(final SimpleApkInfo paramApkInfo, PackageManager paramPackageManager, final OperationApkCallBack<SimpleApkInfo> paramOperationApkCallBack) {
        PMThreadScheduling.instance().sendPMString(
                PM_STRING + paramApkInfo.getApkFilePath(),
                new PMThreadScheduling.PmSendeCallBack() {
                    @Override
                    public void suc(@NonNull String pmString) {
                        paramOperationApkCallBack.callBack(paramApkInfo,1);
                    }

                    @Override
                    public void erro(@NonNull Exception e) {
                        paramOperationApkCallBack.callBack(paramApkInfo,-1);
                    }
                }
        );
    }
}
