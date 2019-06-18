package com.androidbigguy.easyandroid.refreshlayout.layout.impl;

import android.annotation.SuppressLint;
import android.view.View;

import com.androidbigguy.easyandroid.refreshlayout.layout.api.RefreshFooter;
import com.androidbigguy.easyandroid.refreshlayout.layout.internal.InternalAbstract;


/**
 * 刷新底部包装
 * Created by SCWANG on 2017/5/26.
 */
@SuppressLint("ViewConstructor")
public class RefreshFooterWrapper extends InternalAbstract implements RefreshFooter/*, InvocationHandler */{

    public RefreshFooterWrapper(View wrapper) {
        super(wrapper);
    }

//    @Override
//    public boolean setNoMoreData(boolean noMoreData) {
//        return mWrappedInternal instanceof RefreshFooter && ((RefreshFooter) mWrappedInternal).setNoMoreData(noMoreData);
//    }

}
