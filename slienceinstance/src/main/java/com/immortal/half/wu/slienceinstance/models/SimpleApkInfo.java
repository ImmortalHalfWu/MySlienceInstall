package com.immortal.half.wu.slienceinstance.models;

import android.support.annotation.NonNull;

import com.immortal.half.wu.slienceinstance.enums.OperationModelEnum;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/11/15  9:54
 */

public class SimpleApkInfo {
    private String packageName;
    private String apkFilePath;
    private OperationModelEnum modelEnum;
    private File apkFile;

    public SimpleApkInfo(@NonNull String packageName, @NonNull String apkFilePath, @NonNull OperationModelEnum modelEnum)
    {
        this.packageName = packageName;
        this.apkFilePath = apkFilePath;
        this.modelEnum = modelEnum;
        this.apkFile = new File(apkFilePath);
    }

    public String getPackageName()
    {
        return this.packageName;
    }

    public void setPackageName(@NonNull String packageName)
    {
        this.packageName = packageName;
    }

    public String getApkFilePath()
    {
        return this.apkFilePath;
    }

    public void setApkFilePath(@NonNull String apkFilePath)
            throws FileNotFoundException
    {
        this.apkFile = new File(apkFilePath);
        if (!this.apkFile.exists()) {
            throw new FileNotFoundException("not found apk path");
        }
        this.apkFilePath = apkFilePath;
    }

    public File getApkFile()
    {
        return this.apkFile;
    }

    public OperationModelEnum getModelEnum() {
        return modelEnum;
    }

    @Override
    public String toString() {
        return "SimpleApkInfo{" +
                "packageName='" + packageName + '\'' +
                ", apkFilePath='" + apkFilePath + '\'' +
                ", modelEnum=" + modelEnum +
                ", apkFile=" + apkFile +
                '}';
    }
}
