package com.immortal.half.wu.slienceinstance.core;

import com.immortal.half.wu.slienceinstance.core.interfaces.DeleteApkInterface;
import com.immortal.half.wu.slienceinstance.core.interfaces.InstallApkInterface;
import com.immortal.half.wu.slienceinstance.core.interfaces.OperationUtilFactoryInterface;
import com.immortal.half.wu.slienceinstance.models.SimpleApkInfo;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/11/15  11:02
 */

public class OperationUtilFactory implements OperationUtilFactoryInterface<SimpleApkInfo> {

    private static OperationUtilFactory operationUtilFactory;

    public static OperationUtilFactory instance(){
        return operationUtilFactory == null ? operationUtilFactory = new OperationUtilFactory() : operationUtilFactory;
    }

    @Override
    public DeleteApkInterface<SimpleApkInfo> createDeleteApkUtil(SimpleApkInfo apkInfo) {

        switch (apkInfo.getModelEnum()){
            case MODEL_PM:
                return PMDeleteApkUtil.instance();
            case MODEL_SYSTEM_APP:
                return DeleteApkUtil.instance();
            default:
                throw new IllegalArgumentException(apkInfo.getModelEnum().toString());
        }

    }

    @Override
    public InstallApkInterface<SimpleApkInfo> createInstallApkUtil(SimpleApkInfo apkInfo) {
        switch (apkInfo.getModelEnum()){
            case MODEL_PM:
                return InstallApkUtil.instance();
            case MODEL_SYSTEM_APP:
                return PMInstallApkUtil.instance();
            default:
                throw new IllegalArgumentException(apkInfo.getModelEnum().toString());
        }
    }
}
