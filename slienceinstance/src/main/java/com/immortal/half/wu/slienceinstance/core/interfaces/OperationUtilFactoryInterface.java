package com.immortal.half.wu.slienceinstance.core.interfaces;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/11/15  11:00
 */

public interface OperationUtilFactoryInterface<T> {

    DeleteApkInterface<T> createDeleteApkUtil(T apkInfo);
    InstallApkInterface<T> createInstallApkUtil(T apkInfo);

}
