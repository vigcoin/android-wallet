package com.jtech.vigcoin.manager;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.annotation.NonNull;

import com.jtech.vigcoin.manager.base.BaseCacheManager;

/**
 * 常用参数缓存
 */
public class ParamsCacheManager extends BaseCacheManager {
    @SuppressLint("StaticFieldLeak")
    private static ParamsCacheManager manager;

    private ParamsCacheManager(@NonNull Context context) {
        super(context);
    }

    /**
     * 获取单利
     *
     * @param context
     * @return
     */
    public static ParamsCacheManager get(@NonNull Context context) {
        if (null == manager) {
            manager = new ParamsCacheManager(context);
        }
        return manager;
    }
}