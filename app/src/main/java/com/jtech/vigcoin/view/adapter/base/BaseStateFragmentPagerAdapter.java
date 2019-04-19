package com.jtech.vigcoin.view.adapter.base;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * fragmentviewpager适配器基类
 * Created by wuxubaiyang on 16/5/5.
 */
public class BaseStateFragmentPagerAdapter<T extends Fragment> extends FragmentStatePagerAdapter {
    private List<T> fragments = new ArrayList<>();

    public BaseStateFragmentPagerAdapter(FragmentManager fm, List<T> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return null != fragments ? fragments.size() : 0;
    }
}