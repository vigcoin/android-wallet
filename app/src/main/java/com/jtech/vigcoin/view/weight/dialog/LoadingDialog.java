package com.jtech.vigcoin.view.weight.dialog;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.jtech.vigcoin.R;

/**
 * 加载dialog
 */
// TODO: 2019/4/19 代完善样式
public class LoadingDialog extends Dialog {
    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.LoadingDialogTheme);
    }

    /**
     * 设置加载文本
     *
     * @param text 加载文本
     * @return LoadingDialog
     */
    public LoadingDialog setLoadingText(String text) {
        // TODO: 2019/4/19 需要判断是否展示文本
        return this;
    }
}