package com.immortal.half.wu.myslienceinstall;

import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 文件操作类
 * Created by Administrator on 2016/11/22.
 */
public class FileUtil2 {

    /**
     * 单例
     */
    private static FileUtil2 mFileUtil;

    /**
     * 分隔符
     */
    private static String SEPARATOR = File.separator;

    /**
     * 项目文件夹地址
     */
    private static String APP_FILE_PATH;

    /**
     * 错误日志
     */
    private static String APP_ERRO_FILE_PATH;
    private final static String FILE_NAME_ERRO = "Erro";
    /**
     * 文档
     */
    private static String APP_WORD_FILE_PATH;
    private final static String FILE_NAME_WORD = "Word";

    /**
     * 图片
     */
    private static String APP_IMG_FILE_PATH;
    private final static String FILE_NAME_IMG = "Image";
    /**
     * 录像
     */
    private static String APP_VIDIO_FILE_PATH;
    private final static String FILE_NAME_VIDIO = "Vidio";

    /**
     * 缓存
     */
    private static String APP_CACHE_FILE_PATH;
    private final static String FILE_NAME_CACHE = "Cache";
    /**
     * 图像缓存
     */
    private static String APP_CACHE_IMG_PATH = "";
    private final static String FILE_NAME_CACHE_IMG = "ImageCache";


    private FileUtil2(Context context) {
        initPath(context);
        initDirs();
    }

    public static FileUtil2 getInstance() {
        return mFileUtil;
    }


    public static FileUtil2 instance(Context context) {

        if (mFileUtil == null) {
            mFileUtil = new FileUtil2(context);
        }
        return mFileUtil;
    }

    private void initPath(Context context) {

        StringBuilder mFilePathBf = new StringBuilder(
                Environment
                        .getExternalStorageDirectory()
                        .getAbsolutePath()
        );

        APP_FILE_PATH = mFilePathBf.append(SEPARATOR).append(context.getPackageName()).append(SEPARATOR).toString();

        APP_ERRO_FILE_PATH =
                mFilePathBf.append(FILE_NAME_ERRO).append(SEPARATOR).toString();

        APP_WORD_FILE_PATH =
                mFilePathBf.replace(APP_FILE_PATH.length(), APP_ERRO_FILE_PATH.length(), FILE_NAME_WORD)
                        .append(SEPARATOR)
                        .toString();

        APP_IMG_FILE_PATH =
                mFilePathBf.replace(APP_FILE_PATH.length(), APP_WORD_FILE_PATH.length(), FILE_NAME_IMG)
                        .append(SEPARATOR)
                        .toString();

        APP_VIDIO_FILE_PATH =
                mFilePathBf.replace(APP_FILE_PATH.length(), APP_IMG_FILE_PATH.length(), FILE_NAME_VIDIO)
                        .append(SEPARATOR)
                        .toString();

        APP_CACHE_FILE_PATH =
                mFilePathBf.replace(APP_FILE_PATH.length(), APP_IMG_FILE_PATH.length(), FILE_NAME_CACHE)
                        .append(SEPARATOR)
                        .toString();

        APP_CACHE_IMG_PATH =
                mFilePathBf.replace(APP_FILE_PATH.length(), APP_IMG_FILE_PATH.length(), FILE_NAME_CACHE_IMG)
                        .append(SEPARATOR)
                        .toString();

    }


    private void initDirs() {

        dirsMake(APP_ERRO_FILE_PATH);
        dirsMake(APP_WORD_FILE_PATH);
        dirsMake(APP_CACHE_FILE_PATH);
        dirsMake(APP_IMG_FILE_PATH);
        dirsMake(APP_VIDIO_FILE_PATH);
        dirsMake(APP_CACHE_IMG_PATH);

    }

    /**
     * 根据路径，创建文件夹
     *
     * @param dirPath 文件夹路径
     */
    public static boolean dirsMake(String dirPath) {
        File file = new File(dirPath);
        return !file.exists() && file.mkdirs();
    }

    /**
     * 根据路径，创建文件
     *
     * @param filePath 文件路径
     */
    public static boolean fileMake(String filePath) throws IOException {
        File file = new File(filePath);
        return !file.exists() && file.createNewFile();
    }

    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.delete();
    }

    public static void CopyAssets(Context context, String assetDir, String dir) {
        String[] files;
        try {
            files = context.getResources().getAssets().list(assetDir);
        } catch (IOException e1) {
            return;
        }
        File mWorkingPath = new File(dir);
        // if this directory does not exists, make one.
        if (!mWorkingPath.exists()) {
            if (!mWorkingPath.mkdirs()) {
            }
        }
        OutputStream out = null;
        InputStream in = null;
        for (String file : files) {
            try {
                File outFile = new File(mWorkingPath, file);
                boolean d = false;
                if (outFile.exists())
                    d = outFile.delete();

                if (0 != assetDir.length())
                    in = context.getAssets().open(assetDir + "/" + file);
                else
                    in = context.getAssets().open(file);
                out = new FileOutputStream(outFile);

                // Transfer bytes from in to out
                byte[] buf = new byte[1024];
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                in.close();
                out.close();
            } catch (IOException ignored) {
            } finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException ignored) {
                }
            }
        }
    }


    public static String getAppFilePath() {
        return APP_FILE_PATH;
    }

    public static String getAppErroFilePath() {
        return APP_ERRO_FILE_PATH;
    }

    public static String getAppWordFilePath() {
        return APP_WORD_FILE_PATH;
    }

    public static String getAppImgFilePath() {
        return APP_IMG_FILE_PATH;
    }

    public static String getAppVidioFilePath() {
        return APP_VIDIO_FILE_PATH;
    }

    public static String getAppCacheFilePath() {
        return APP_CACHE_FILE_PATH;
    }

    public static String getAppCacheImgPath() {
        return APP_CACHE_IMG_PATH;
    }

}
