package com.jtech.vigcoin.view.activity;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jtech.vigcoin.util.Bus;

import butterknife.ButterKnife;

/**
 * activity基类
 * Created by wuxubaiyang on 16/4/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    public static String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //赋值TAG
        TAG = this.getClass().getSimpleName();
        //初始化变量(用户传递进来的参数)
        if (null != getIntent()) {
            initVariables(getIntent().getExtras());
        } else {
            initVariables(null);
        }
        //基类中注册消息总线
        Bus.getOnWithBase(this);
        //初始化视图
        initViews(savedInstanceState);
        //加载数据
        loadData();
    }

    /**
     * 初始化变量
     *
     * @param bundle bundle
     */
    protected abstract void initVariables(Bundle bundle);

    /**
     * 初始化视图
     *
     * @param savedInstanceState savedInstanceState
     */
    protected abstract void initViews(Bundle savedInstanceState);

    /**
     * 请求数据
     */
    protected abstract void loadData();

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        //绑定注解
        ButterKnife.bind(this);
    }

    /**
     * 获取activity对象
     *
     * @return 当前activity对象
     */
    public BaseActivity getActivity() {
        return this;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //基类中反注册
        Bus.getOffWithBase(this);
    }
}