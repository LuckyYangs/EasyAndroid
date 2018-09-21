package com.androidbigguy.easyandroid.versionchecklib.utils;

import android.util.Log;

import com.androidbigguy.easyandroid.versionchecklib.core.AllenChecker;

/**
 * Created by androidbigguy.easyandroid on 2017/8/16.
 */

public class ALog {
    public static void e(String msg) {
        if (AllenChecker.isDebug()) {
            if (msg != null && !msg.isEmpty()){
                Log.e("Allen Checker", msg);}
        }
    }
}
