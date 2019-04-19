package com.jtech.vigcoin.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.jtech.vigcoin.common.Constants;
import com.jtech.vigcoin.net.base.BaseApi;

import java.util.Date;

import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 接口
 */
public class API extends BaseApi {
    private VigCoinApi vigCoinApi;
    private static API api;

    /**
     * 获取单利
     *
     * @return
     */
    public static API get() {
        if (null == api) {
            api = new API();
        }
        return api;
    }

    /**
     * 获取VigCoin网络接口实现
     *
     * @return
     */
    public VigCoinApi vigCoinApi() {
        if (null == vigCoinApi) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, new DateTypeAdapter())
                    .create();
            this.vigCoinApi = createRxApi(GsonConverterFactory.create(gson),
                    Constants.BASE_URL, VigCoinApi.class);
        }
        return vigCoinApi;
    }
}