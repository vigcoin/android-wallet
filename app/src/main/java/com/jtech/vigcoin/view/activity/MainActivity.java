package com.jtech.vigcoin.view.activity;

import android.os.Bundle;

import com.jtech.vigcoin.R;
import com.jtech.vigcoin.mvp.contract.MainContract;
import com.jtech.vigcoin.mvp.presenter.MainPresenter;

/**
 * 主页
 */
public class MainActivity extends BaseActivity implements MainContract.View {
    private MainContract.Presenter presenter;

    @Override
    protected void initVariables(Bundle bundle) {
        //绑定P类
        presenter = new MainPresenter(getActivity(), this, bundle);
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void loadData() {
    }
}