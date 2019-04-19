package com.jtech.vigcoin.manager;

import android.app.Activity;

import com.jtech.vigcoin.util.ActivityGo;
import com.jtech.vigcoin.view.activity.MainActivity;

/**
 * activity页面跳转管理
 */
public class ActivityGoManager {
    /**
     * 跳转到首页
     *
     * @param activity
     */
    public static void goMain(Activity activity) {
        ActivityGo.build(activity, MainActivity.class)
                .go();
    }
}