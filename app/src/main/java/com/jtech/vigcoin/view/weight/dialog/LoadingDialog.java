package com.jtech.vigcoin.view.weight.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.github.ybq.android.spinkit.SpinKitView;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ChasingDots;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.CubeGrid;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.FadingCircle;
import com.github.ybq.android.spinkit.style.FoldingCube;
import com.github.ybq.android.spinkit.style.Pulse;
import com.github.ybq.android.spinkit.style.RotatingCircle;
import com.github.ybq.android.spinkit.style.RotatingPlane;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.github.ybq.android.spinkit.style.Wave;
import com.jtech.vigcoin.R;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 加载dialog
 */
public class LoadingDialog extends Dialog {
    @BindView(R.id.spin_kit_loading_dialog)
    SpinKitView spinKitView;
    @BindView(R.id.text_view_loading_dialog_hint)
    TextView textViewHint;

    private Map<Class<?>, Sprite> animatorsMap;
    private Class<?>[] animators = {
            RotatingPlane.class,
            DoubleBounce.class,
            Wave.class,
            WanderingCubes.class,
            Pulse.class,
            ChasingDots.class,
            ThreeBounce.class,
            Circle.class,
            CubeGrid.class,
            FadingCircle.class,
            FoldingCube.class,
            RotatingCircle.class
    };

    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.LoadingDialogTheme);
        //设置主视图
        @SuppressLint("InflateParams") View contentView = LayoutInflater
                .from(context).inflate(R.layout.view_loading_dialog, null);
        ButterKnife.bind(this, contentView);
        setContentView(contentView);
    }

    /**
     * 设置加载文本
     *
     * @param text 加载文本
     * @return LoadingDialog
     */
    public LoadingDialog setLoadingText(String text) {
        if (!TextUtils.isEmpty(text)) {
            textViewHint.setText(text);
        }
        return this;
    }

    /**
     * 显示dialog
     */
    @Override
    public void show() {
        super.show();
        //设置随机动画
        spinKitView.setIndeterminateDrawable(getRandomSprite());
    }

    /**
     * 获取随机动画
     *
     * @return
     */
    private Sprite getRandomSprite() {
        if (null == animatorsMap) {
            animatorsMap = new HashMap<>();
        }
        //随机获取一个类
        Class<?> clazz = animators[new Random()
                .nextInt(animators.length - 1)];
        if (animatorsMap.containsKey(clazz)) {
            return animatorsMap.get(clazz);
        }
        try {
            Sprite sprite = (Sprite) clazz.newInstance();
            animatorsMap.put(clazz, sprite);
            return sprite;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        //返回默认值
        return new DoubleBounce();
    }
}