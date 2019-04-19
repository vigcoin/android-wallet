package com.jtech.vigcoin.common;

/**
 * 全局参数
 */
public class Constants {
    //debug状态
    public final static boolean DEBUG = true;
    //本地缓存路径
    public final static String FILE_CACHE_PATH = "VigCoinCache";
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