package com.androidbigguy.easyandroid.versionchecklib.v2;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by Allen Liu on 2017/2/23.
 */
public class CustUpdataAppBaseDialog extends Dialog {
    private int res;

    public CustUpdataAppBaseDialog(Context context, int theme, int res) {
        super(context, theme);
        // TODO 自动生成的构造函数存根
        setContentView(res);
        this.res = res;
        setCanceledOnTouchOutside(false);
    }

}