package com.jtech.vigcoin.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.jtech.vigcoin.util.Bus;
import com.jtech.vigcoin.view.weight.dialog.LoadingDialog;

import java.util.Objects;

import butterknife.ButterKnife;

/**
 * Fragment基类
 * Created by wuxubaiyang on 16/4/16.
 */
public abstract class BaseFragment extends Fragment {
    public static String TAG = BaseFragment.class.getSimpleName();
    private LoadingDialog loadingDialog;
    private View contentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null == contentView) {
            //赋值TAG
            TAG = this.getClass().getSimpleName();
            //创建视图
            contentView = createView(inflater, container);
            //绑定注解框架
            ButterKnife.bind(this, contentView);
            //初始化变量(用户传递进来的参数)
            initVariables(getArguments());
            //初始化视图
            initViews(savedInstanceState);
            //加载数据
            loadData();
        }
        //返回视图
        return contentView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //基类中注册消息总线
        Bus.getOnWithBase(this);
    }

    /**
     * 创建视图
     *
     * @param inflater  inflater
     * @param container container
     * @return 视图
     */
    public abstract View createView(LayoutInflater inflater, ViewGroup container);

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

    /**
     * 展示loadingDialog
     *
     * @param resId      loadingTextResId
     * @param cancelable 是否可取消
     */
    public void showLoading(@StringRes int resId, boolean cancelable) {
        showLoading(getString(resId), cancelable);
    }

    /**
     * 展示loadingDialog
     *
     * @param text       loadingText
     * @param cancelable 是否可取消
     */
    public void showLoading(String text, boolean cancelable) {
        if (null == loadingDialog) {
            loadingDialog = new LoadingDialog(
                    Objects.requireNonNull(getActivity()));
        }
        loadingDialog
                .setLoadingText(text)
                .setCancelable(cancelable);
        loadingDialog.show();
    }

    /**
     * 更新loadingDialog文本
     *
     * @param text loadingText
     */
    public void updateLoadingText(String text) {
        if (null != loadingDialog && loadingDialog.isShowing()) {
            loadingDialog.setLoadingText(text);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //基类中反注册
        Bus.getOffWithBase(this);
    }
}