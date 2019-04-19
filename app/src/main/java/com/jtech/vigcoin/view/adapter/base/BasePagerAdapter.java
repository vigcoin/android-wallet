package com.jtech.vigcoin.view.adapter.base;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

/**
 * 视图viewpager适配器基类
 * Created by wuxubaiyang on 16/5/6.
 */
public class BasePagerAdapter<T extends View> extends PagerAdapter {
    private List<T> views;

    public BasePagerAdapter(List<T> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return null != views ? views.size() : 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(views.get(position));
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(views.get(position));
        return views.get(position);
    }
}