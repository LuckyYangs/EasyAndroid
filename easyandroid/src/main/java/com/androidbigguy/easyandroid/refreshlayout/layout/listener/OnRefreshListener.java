package com.androidbigguy.easyandroid.refreshlayout.layout.listener;

import android.support.annotation.NonNull;

import com.androidbigguy.easyandroid.refreshlayout.layout.api.RefreshLayout;


/**
 * 刷新监听器
 * Created by SCWANG on 2017/5/26.
 */

public interface OnRefreshListener {
    void onRefresh(@NonNull RefreshLayout refreshLayout);
}
