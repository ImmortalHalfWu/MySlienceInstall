package com.immortal.half.wu.slienceinstance;

import android.content.pm.PackageManager;

import com.immortal.half.wu.slienceinstance.core.interfaces.DeleteApkInterface;
import com.immortal.half.wu.slienceinstance.core.interfaces.InstallApkInterface;
import com.immortal.half.wu.slienceinstance.core.interfaces.OperationApkCallBack;
import com.immortal.half.wu.slienceinstance.models.SimpleApkInfo;
import com.immortal.half.wu.slienceinstance.utils.Loger;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/11/15  10:01
 */

public class OperationApkUtil {
    private OperationApkUtil()
    {
        Loger.d("OperationApkUtil() : 初始化");
    }

    public static void installApk(SimpleApkInfo simpleApkInfo, PackageManager packageManager, OperationApkCallBack<SimpleApkInfo> callBack)
    {
        Loger.d("installApk():\t" + simpleApkInfo.toString());
        getInstallApkInterface().installApk(simpleApkInfo, packageManager, callBack);
    }

    public static void slienceInstallApk(SimpleApkInfo simpleApkInfo, PackageManager packageManager, OperationApkCallBack<SimpleApkInfo> callBack)
    {
        Loger.d("slienceInstallApk():\t" + simpleApkInfo.toString());
        getInstallApkInterface().slienceInstallApk(simpleApkInfo, packageManager, callBack);
    }

    public static void deleteApk(SimpleApkInfo simpleApkInfo, PackageManager packageManager, OperationApkCallBack callBack)
    {
        Loger.d("deleteApk():\t" + simpleApkInfo.toString());
        getDeleteApkInterface().deleteApk(simpleApkInfo, packageManager, callBack);
    }

    public static void slienceDeleteApk(SimpleApkInfo simpleApkInfo, PackageManager packageManager, OperationApkCallBack callBack)
    {
        Loger.d("slienceDeleteApk():\t" + simpleApkInfo.toString());
        getDeleteApkInterface().deleteApk(simpleApkInfo, packageManager, callBack);
    }

    private static DeleteApkInterface<SimpleApkInfo> getDeleteApkInterface()
    {
        return OperationApkManager.getInstance();
    }

    private static InstallApkInterface<SimpleApkInfo> getInstallApkInterface()
    {
        return OperationApkManager.getInstance();
    }

}
