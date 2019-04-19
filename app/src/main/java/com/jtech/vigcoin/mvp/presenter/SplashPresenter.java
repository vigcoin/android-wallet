package com.jtech.vigcoin.mvp.presenter;

import android.content.Context;
import android.os.Bundle;

import com.jtech.vigcoin.mvp.contract.SplashContract;

/**
 * 起始页
 */
public class SplashPresenter implements SplashContract.Presenter {
    private Context context;
    private SplashContract.View view;

    public SplashPresenter(Context context, SplashContract.View view, Bundle bundle) {
        this.context = context;
        this.view = view;
    }
}