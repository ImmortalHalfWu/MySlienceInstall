package com.immortal.half.wu.slienceinstance.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;


/**
 * Do :
 * Created : immortalHalfWu
 * Time : 2017/11/15  14:32
 */

public class PMThreadScheduling {

    private static PMThreadScheduling threadScheduling;
    private Handler workHandle;

    private PMThreadScheduling(){
        HandlerThread handlerThread = new HandlerThread(getClass().getCanonicalName());
        handlerThread.start();
        workHandle = new Handler(handlerThread.getLooper());
    }

    public static PMThreadScheduling instance(){
        return threadScheduling == null ? threadScheduling = new PMThreadScheduling() : threadScheduling;
    }

    public void sendPMString(@NonNull String pmstring, @NonNull PmSendeCallBack pmSendeCallBack){
        workHandle.post(WorkRunnable.newInstance(pmstring,pmSendeCallBack));
    }

    private static class WorkRunnable implements Runnable{

        private WorkRunnable(@NonNull String pmString,@NonNull PmSendeCallBack mPmSendeCallBack){
            this.mPmSendeCallBack = mPmSendeCallBack;
            this.pmString = pmString;
        }

        private PmSendeCallBack mPmSendeCallBack;
        private String pmString;

        static WorkRunnable newInstance(@NonNull String pmString,@NonNull PmSendeCallBack pmSendeCallBack){
            return new WorkRunnable(pmString, pmSendeCallBack);
        }

        @Override
        public void run() {
            Process process = null;
            DataOutputStream os = null;
            BufferedReader successResult = null;
            BufferedReader errorResult = null;
            StringBuilder successMsg = null;
            StringBuilder errorMsg;
            try {
                process = Runtime.getRuntime().exec("su");
                os = new DataOutputStream(process.getOutputStream());
                os.write(pmString.getBytes());
                os.writeBytes("\n");
                os.writeBytes("exit\n");
                os.flush();
                process.waitFor();
                successMsg = new StringBuilder();
                errorMsg = new StringBuilder();
                successResult = new BufferedReader(new InputStreamReader(process.getInputStream()));
                errorResult = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                String s;
                while ((s = successResult.readLine()) != null) {
                    successMsg.append(s);
                }
                while ((s = errorResult.readLine()) != null) {
                    errorMsg.append(s);
                }

                if (successMsg.toString().contains("Success") || successMsg.toString().contains("success")){
                    mPmSendeCallBack.suc(pmString);
                }else {
                    mPmSendeCallBack.erro(new IllegalStateException("pm string send erro : " + pmString));
                }

            } catch (Exception e) {
                e.printStackTrace();
                mPmSendeCallBack.erro(e);
            } finally {
                try {
                    if (os != null) {
                        os.close();
                    }
                    if (process != null) {
                        process.destroy();
                    }
                    if (successResult != null) {
                        successResult.close();
                    }
                    if (errorResult != null) {
                        errorResult.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public interface PmSendeCallBack {
        void suc(@NonNull String pmString);
        void erro(@NonNull Exception e);
    }


}
