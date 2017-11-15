package com.immortal.half.wu.slienceinstance.core;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import com.immortal.half.wu.slienceinstance.core.interfaces.DeleteApkInterface;
import com.immortal.half.wu.slienceinstance.core.interfaces.OperationApkCallBack;
import com.immortal.half.wu.slienceinstance.models.SimpleApkInfo;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/11/15  10:12
 */

class PMDeleteApkUtil implements DeleteApkInterface<SimpleApkInfo> {

    private static PMDeleteApkUtil pmDeleteApkUtil;
    private static final String PM_STRING = "pm uninstall -k ";

    public static PMDeleteApkUtil instance(){
        return pmDeleteApkUtil == null ? pmDeleteApkUtil = new PMDeleteApkUtil() : pmDeleteApkUtil;
    }

    @Override
    public void deleteApk(SimpleApkInfo paramApkInfo, PackageManager paramPackageManager, OperationApkCallBack paramOperationApkCallBack) {
        slienceDeleteApk(paramApkInfo,paramPackageManager,paramOperationApkCallBack);
    }

    @Override
    public void slienceDeleteApk(final SimpleApkInfo paramApkInfo, PackageManager paramPackageManager, final OperationApkCallBack paramOperationApkCallBack) {
        PMThreadScheduling.instance().sendPMString(
                PM_STRING + paramApkInfo.getPackageName(),
                new PMThreadScheduling.PmSendeCallBack() {
                    @Override
                    public void suc(@NonNull String pmString) {
                        paramOperationApkCallBack.callBack(paramApkInfo.getPackageName(),1);
                    }

                    @Override
                    public void erro(@NonNull Exception e) {
                        paramOperationApkCallBack.callBack(paramApkInfo.getPackageName(),-1);
                    }
                }
        );
    }
}
