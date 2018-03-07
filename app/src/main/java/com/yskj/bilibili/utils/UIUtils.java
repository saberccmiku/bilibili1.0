package com.yskj.bilibili.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.Window;
import android.view.WindowManager;

import com.yskj.bilibili.widget.SystemBarTintManager;

/**
 * Created by saber on 2018/3/6
 * 界面工具
 */

public class UIUtils {

    /**
     * 设置通知栏状态
     * @param activity activity
     * @param flag 是否设置
     *  需要API 19
     */
    public static void setTranslucentStatus(Activity activity,boolean flag){
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT) {
            Window window = activity.getWindow();
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (flag) {
                layoutParams.flags |= bits;
            } else {
                layoutParams.flags &= ~bits;
            }
            window.setAttributes(layoutParams);
        }
    }

    /**
     * 设置通知栏颜色
     * @param activity activity
     * @param flag 是否设置
     * @param color 颜色代码
     */
    public static void setNotificationColor(Activity activity , boolean flag,int color){
        setTranslucentStatus(activity,flag);
        SystemBarTintManager manager = new SystemBarTintManager(activity);
        manager.setStatusBarTintEnabled(true);
        manager.setStatusBarTintColor(color);
    }
}
