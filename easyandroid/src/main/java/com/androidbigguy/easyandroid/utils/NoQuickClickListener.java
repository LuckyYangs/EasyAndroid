package com.androidbigguy.easyandroid.utils;

import android.view.View;

/**
 * .---.          .-----------
 * /  /   \  __  /    ------
 * / /  //  \(  )/    -----
 * //////    ' \/ `   ---
 * //// /     :    : ---
 * // /        `    '--
 * //           //..\\
 * =============UU====UU================
 * '//||\\`
 * ''``
 * -----------------------------------------------
 * | 作  者：| AndroidBigGuy（QQ295803379）
 * -----------------------------------------------
 * | 时  间：| 2019/1/21 15:46
 * -----------------------------------------------
 * | 类  名：| $class$
 * -----------------------------------------------
 * | 简  述: | <功能简述>
 * -----------------------------------------------
 */
 public abstract class NoQuickClickListener implements View.OnClickListener {
    // 两次点击按钮之间的点击间隔不能少于800毫秒
    private static final int MIN_CLICK_DELAY_TIME = 800;
    private static long lastClickTime=0;
    public abstract void NoQuickClick(View v);
    @Override
    public void onClick(View v) {
        long curClickTime = System.currentTimeMillis();
        if((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
            // 超过点击间隔后再将lastClickTime重置为当前点击时间
            lastClickTime = curClickTime;
            NoQuickClick(v);
        }else {
            LogUtilx.i("XXX","太快了");
        }
    }


}
