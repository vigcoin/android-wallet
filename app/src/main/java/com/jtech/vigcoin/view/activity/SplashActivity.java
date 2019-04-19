package com.jtech.vigcoin.view.activity;

import android.os.Bundle;

import com.jtech.vigcoin.R;
import com.jtech.vigcoin.mvp.contract.SplashContract;
import com.jtech.vigcoin.mvp.presenter.SplashPresenter;

/**
 * 起始页
 */
public class SplashActivity extends BaseActivity implements SplashContract.View {
    private SplashContract.Presenter presenter;

    @Override
    protected void initVariables(Bundle bundle) {
        //绑定P类
        presenter = new SplashPresenter(getActivity(), this, bundle);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void loadData() {
    }
}