package com.jtech.vigcoin.util;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.StringRes;

/**
 * toast工具类
 **/
// TODO: 2019/4/18 实现方法待定，需要进行修改，使用snack bar实现
public class ToastUtils {
    /**
     * 展示长时toast
     *
     * @param context
     * @param resId
     */
    public static void showLong(Context context, @StringRes int resId) {
        showLong(context, context.getText(resId));
    }

    /**
     * 展示长时toast
     *
     * @param context
     * @param content
     */
    public static void showLong(Context context, CharSequence content) {
        show(context, content, Toast.LENGTH_LONG);
    }

    /**
     * 展示短时toast
     *
     * @param context
     * @param resId
     */
    public static void showShort(Context context, @StringRes int resId) {
        showShort(context, context.getText(resId));
    }

    /**
     * 展示短时toast
     *
     * @param context
     * @param content
     */
    public static void showShort(Context context, CharSequence content) {
        show(context, content, Toast.LENGTH_SHORT);
    }

    /**
     * 基础方法
     *
     * @param context
     * @param content
     * @param duration
     */
    private static void show(Context context, CharSequence content, int duration) {
        Toast.makeText(context, content, duration).show();
    }
}