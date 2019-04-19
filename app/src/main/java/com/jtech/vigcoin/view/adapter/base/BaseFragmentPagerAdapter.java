package com.jtech.vigcoin.view.adapter.base;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * fragmentviewpager适配器基类
 * Created by wuxubaiyang on 16/5/5.
 */
public class BaseFragmentPagerAdapter<T extends Fragment> extends FragmentPagerAdapter {
    private List<T> fragments = new ArrayList<>();

    public BaseFragmentPagerAdapter(FragmentManager fm, List<T> fragments) {
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