package com.androidbigguy.easyandroid.refreshlayout.layout.impl;

import android.annotation.SuppressLint;
import android.view.View;

import com.androidbigguy.easyandroid.refreshlayout.layout.api.RefreshHeader;
import com.androidbigguy.easyandroid.refreshlayout.layout.internal.InternalAbstract;


/**
 * 刷新头部包装
 * Created by SCWANG on 2017/5/26.
 */
@SuppressLint("ViewConstructor")
public class RefreshHeaderWrapper extends InternalAbstract implements RefreshHeader/*, InvocationHandler*/ {

    public RefreshHeaderWrapper(View wrapper) {
        super(wrapper);
    }

}
