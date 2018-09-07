package com.androidbigguy.easyandroid.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * 类  名：NetUtils
 * 描  述: 判断网络状态工具类
 */

public class NetUtils {
    /**
     * 没有连接网络
     */
    private static final String NETWORK_NONE = "无网络";
    /**
     * 移动网络
     */
    private static final String NETWORK_MOBILE = "移动数据";
    /**
     * WIFI网络
     */
    private static final String NETWORK_WIFI = "WIFI";


    /**
     *
     * @param context
     * @return 返回网络连接类型 ：-1=无网络，0=移动网络，1=WIFI；
     */

    public  static String getNetworkState(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            if (networkInfo.getType() == (ConnectivityManager.TYPE_WIFI)) {

                return NETWORK_WIFI;
            }
            if (networkInfo.getType() == (ConnectivityManager.TYPE_MOBILE)) {

                return NETWORK_MOBILE;
            }
        }else {
            return NETWORK_NONE;
        }
        return NETWORK_NONE;
    }



    public static boolean isAvailableByPing() {

        ShellUtils.CommandResult result = ShellUtils.execCommand("ping -c 1 -w 1  61.135.169.121", false);

        boolean ret = result.result==0;

        if (result.errorMsg != null) {

            Log.d("errorMsg", result.errorMsg);

        }

        if (result.successMsg != null) {

            Log.d("successMsg", result.successMsg);

        }

        return ret;

    }


}
