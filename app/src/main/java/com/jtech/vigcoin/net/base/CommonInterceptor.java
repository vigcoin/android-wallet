package com.jtech.vigcoin.net.base;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * 通用拦截器
 */
class CommonInterceptor implements Interceptor {
    private Map<String, String> headerMap;

    CommonInterceptor(Map<String, String> headerMap) {
        this.headerMap = headerMap;
    }

    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request()
                .newBuilder();
        if (null != headerMap) {
            for (String key : headerMap.keySet()) {
                if (headerMap.containsKey(key)) {
                    String value = headerMap.get(key);
                    if (null == value) continue;
                    builder.addHeader(key, value);
                }
            }
        }
        return chain.proceed(builder.build());
    }
}