package com.jtech.vigcoin.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.jtech.vigcoin.common.Constants;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 常见工具类
 */
public class Utils {
    /**
     * 获取屏幕宽度
     *
     * @param activity activity
     * @return 屏幕宽度
     */
    public static int getScreenWidth(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @param activity activity
     * @return 屏幕高度
     */
    public static int getScreenHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param context context
     * @param dpValue dp
     * @return 返回px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param context context
     * @param pxValue px
     * @return 返回dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 获取当前应用版本号
     *
     * @param context context
     * @return 版本号
     */
    public static int getPackageCode(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 版本名
     *
     * @param context context
     * @return 版本名
     */
    public static String getPackageName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 显示软键盘
     *
     * @param context
     * @param view
     * @return
     */
    public static boolean showSoftInput(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)
                context.getSystemService(Context.INPUT_METHOD_SERVICE);
        return inputMethodManager.showSoftInput(
                view, InputMethodManager.RESULT_UNCHANGED_SHOWN);
    }

    /**
     * 隐藏软键盘
     *
     * @param context
     * @param view
     * @return
     */
    public static boolean hideSoftInput(Context context, View view) {
        InputMethodManager inputMethodManager = (InputMethodManager)
                context.getSystemService(Context.INPUT_METHOD_SERVICE);
        return inputMethodManager.hideSoftInputFromWindow(
                view.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
    }

    /**
     * 清空缓存
     *
     * @param context
     * @return
     */
    public static Observable<Boolean> clearCache(Context context) {
        //异步清空缓存
        return Observable.just(context)
                .subscribeOn(Schedulers.io())
                .map(context1 -> FileUtils.deleteFolder(getFilesDir(context1).getPath())
                        && FileUtils.deleteFolder(getCacheDir(context1).getPath())
                        && FileUtils.deleteFolder(getExternalStorageDir().getPath()))
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 计算缓存大小
     *
     * @param context
     * @return
     */
    public static Observable<String> getCacheSize(Context context) {
        return Observable.just(context)
                .subscribeOn(Schedulers.io())
                .map(context1 -> FileUtils.getFileOrFilesSize(getFilesDir(context1).getPath(), FileUtils.SIZETYPE_MB)
                        + FileUtils.getFileOrFilesSize(getCacheDir(context1).getPath(), FileUtils.SIZETYPE_MB)
                        + FileUtils.getFileOrFilesSize(getExternalStorageDir().getPath(), FileUtils.SIZETYPE_MB)
                        + "MB")
                .observeOn(AndroidSchedulers.mainThread());
    }

    /**
     * 获取临时缓存目录
     *
     * @param context
     * @return
     */
    public static File getCacheDir(Context context) {
        File cacheDir = new File(context.getCacheDir(), Constants.FILE_CACHE_PATH);
        if (!cacheDir.exists()
                && cacheDir.mkdirs()) {
            return cacheDir;
        }
        return getExternalStorageDir();
    }

    /**
     * 获取永久缓存目录
     *
     * @param context
     * @return
     */
    public static File getFilesDir(Context context) {
        File filesDir = new File(context.getFilesDir(), Constants.FILE_CACHE_PATH);
        if (!filesDir.exists()
                && filesDir.mkdirs()) {
            return filesDir;
        }
        return getExternalStorageDir();
    }

    /**
     * 获取外部存储路径
     *
     * @return
     */
    public static File getExternalStorageDir() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            File externalStorageFiles = new File(Environment
                    .getExternalStorageDirectory(), Constants.FILE_CACHE_PATH);
            if (!externalStorageFiles.exists()
                    && externalStorageFiles.mkdirs()) {
                return externalStorageFiles;
            }
        }
        return new File(Constants.SD_CACHE_PATH);
    }
}