package com.immortal.half.wu.slienceinstance;

import android.content.pm.PackageManager;

import com.immortal.half.wu.slienceinstance.core.OperationUtilFactory;
import com.immortal.half.wu.slienceinstance.core.interfaces.DeleteApkInterface;
import com.immortal.half.wu.slienceinstance.core.interfaces.InstallApkInterface;
import com.immortal.half.wu.slienceinstance.core.interfaces.OperationApkCallBack;
import com.immortal.half.wu.slienceinstance.core.interfaces.OperationUtilFactoryInterface;
import com.immortal.half.wu.slienceinstance.models.SimpleApkInfo;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/11/15  10:01
 * @author immortalHalfWu
 */

class OperationApkManager implements DeleteApkInterface<SimpleApkInfo>, InstallApkInterface<SimpleApkInfo>
{
    private OperationUtilFactoryInterface<SimpleApkInfo> operationUtilFactoryInterface;
    private static OperationApkManager operationApkManager;

    private OperationApkManager()
    {
        operationUtilFactoryInterface = OperationUtilFactory.instance();
    }

    public static OperationApkManager getInstance()
    {
        return operationApkManager == null ? (operationApkManager = new OperationApkManager()) : operationApkManager;
    }

    @Override
    public void deleteApk(SimpleApkInfo simpleApkInfo, PackageManager packageManager, OperationApkCallBack callBack)
    {
        operationUtilFactoryInterface.createDeleteApkUtil(simpleApkInfo).deleteApk(simpleApkInfo, packageManager, callBack);
    }

    @Override
    public void slienceDeleteApk(SimpleApkInfo simpleApkInfo, PackageManager packageManager, OperationApkCallBack callBack)
    {
        operationUtilFactoryInterface.createDeleteApkUtil(simpleApkInfo).slienceDeleteApk(simpleApkInfo, packageManager, callBack);
    }

    @Override
    public void installApk(SimpleApkInfo simpleApkInfo, PackageManager packageManager, OperationApkCallBack<SimpleApkInfo> callBack)
    {
        operationUtilFactoryInterface.createInstallApkUtil(simpleApkInfo).installApk(simpleApkInfo, packageManager, callBack);
    }

    @Override
    public void slienceInstallApk(SimpleApkInfo simpleApkInfo, PackageManager packageManager, OperationApkCallBack<SimpleApkInfo> callBack)
    {
        operationUtilFactoryInterface.createInstallApkUtil(simpleApkInfo).installApk(simpleApkInfo, packageManager, callBack);
    }
}
