package com.jtech.vigcoin.common;

import android.annotation.SuppressLint;

/**
 * 全局参数
 */
public class Constants {
    //debug状态
    public final static boolean DEBUG = true;
    //本地缓存路径
    public final static String FILE_CACHE_PATH = "VigCoinCache";
    //sd卡根目录
    @SuppressLint("SdCardPath")
    public final static String SD_CACHE_PATH = "/sdcard/";
    //https
    public final static String HTTPS = "https://";
    //http
    public final static String HTTP = "http://";
    //正式服务器地址
    public final static String OFFICIAL_SERVER_URL = "0.0.0.0:80";
    //测试服务器地址
    public final static String TEST_SERVER_URL = "0.0.0.0:80/";
    //api基础地址
    public final static String BASE_URL = HTTPS + (DEBUG ? TEST_SERVER_URL : OFFICIAL_SERVER_URL);
}