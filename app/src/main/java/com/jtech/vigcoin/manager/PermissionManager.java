package com.jtech.vigcoin.manager;

import android.Manifest;
import android.app.Activity;

import com.jtech.vigcoin.manager.base.BasePermissionManager;
import com.jtech.vigcoin.manager.base.PermissionListener;

/**
 * 权限管理
 */
public class PermissionManager extends BasePermissionManager {
    /**
     * 应用必须权限
     */
    private static String[] mustPermissions = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    /**
     * 检查必须权限
     *
     * @param activity activity
     * @param listener 回调
     */
    public static void checkMustPermission(Activity activity, PermissionListener listener) {
        checkMultiple(activity, mustPermissions, listener);
    }
}