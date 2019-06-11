package com.androidbigguy.easyandroid.utils;

import android.util.Log;

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
 * | 时  间：| 2019/1/18 13:57
 * -----------------------------------------------
 * | 类  名：| LogUtilx
 * -----------------------------------------------
 * | 简  述: | 日志工具类
 * -----------------------------------------------
 */
public class LogUtilx {
    public static  boolean LOGSWITCH =true;

    public static void e(String tag,String msg){
        if(LOGSWITCH&StringsUtil.isNotEmpty(msg)){
            Log.e(tag, msg);}
    }

    public static void w(String tag,String msg){
        if(LOGSWITCH&StringsUtil.isNotEmpty(msg)){
            Log.w(tag, msg);}
    }
    public static void i(String tag,String msg){
        if(LOGSWITCH&StringsUtil.isNotEmpty(msg)){
            Log.i(tag, msg);}
    }
    public static void d(String tag,String msg){
        if(LOGSWITCH&StringsUtil.isNotEmpty(msg)){
            Log.d(tag, msg);}
    }
    public static void v(String tag,String msg){
        if(LOGSWITCH&StringsUtil.isNotEmpty(msg)){
            Log.v(tag, msg);}
    }
}
