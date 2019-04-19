package com.jtech.vigcoin.manager.base;

/**
 * 权限检查监听
 */
public interface PermissionListener {
    void result(boolean allGranted);
}