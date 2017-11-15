package com.immortal.half.wu.myslienceinstall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.immortal.half.wu.slienceinstance.OperationApkUtil;
import com.immortal.half.wu.slienceinstance.core.interfaces.OperationApkCallBack;
import com.immortal.half.wu.slienceinstance.enums.OperationModelEnum;
import com.immortal.half.wu.slienceinstance.models.SimpleApkInfo;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private File apkFile;
    private static final String TAG = "myslienceinstall";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FileUtil2.instance(this);
        apkFile = new File(FileUtil2.getAppFilePath()+File.separator+"app-debug.apk");
        textView = findViewById(R.id.textView);
        textView.setText(apkFile.getAbsolutePath() + "_exists?_" + apkFile.exists());
        Log.i(TAG, "=====================================onCreate: "+apkFile.getAbsolutePath()+ "_exists?_" + apkFile.exists());
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!apkFile.exists()){
                    return;
                }
                SimpleApkInfo simpleApkInfo = new SimpleApkInfo(getPackageName(),apkFile.getAbsolutePath(), OperationModelEnum.MODEL_SYSTEM_APP);
                OperationApkUtil.slienceInstallApk(simpleApkInfo, getPackageManager(), new OperationApkCallBack() {
                    @Override
                    public void callBack(String s, int i) {
                        Toast.makeText(MainActivity.this, s + i, Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!apkFile.exists()){
                    return;
                }
                SimpleApkInfo simpleApkInfo = new SimpleApkInfo(getPackageName(),apkFile.getAbsolutePath(),OperationModelEnum.MODEL_PM);
                OperationApkUtil.installApk(simpleApkInfo, getPackageManager(), new OperationApkCallBack() {
                    @Override
                    public void callBack(String s, int i) {
                        Toast.makeText(MainActivity.this, s + i, Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }
}
