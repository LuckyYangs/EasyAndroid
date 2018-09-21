package com.androidbigguy.easyandroid.versionchecklib.v2.callback;

import android.app.Dialog;
import android.content.Context;

import com.androidbigguy.easyandroid.versionchecklib.v2.builder.UIData;

/**
 * Created by androidbigguy.easyandroid on 2018/1/18.
 */

public interface CustomVersionDialogListener {
    Dialog getCustomVersionDialog(Context context, UIData versionBundle);
}
