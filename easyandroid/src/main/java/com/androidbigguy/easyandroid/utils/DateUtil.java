package com.androidbigguy.easyandroid.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 作  者：@author李 洋（295803379）
 * 时  间：2018/7/26 17:45
 * 项目名：CompanyProject
 * 包  名：com.md.personnelfiles.utils
 * 类  名： $class$
 * 描  述: {描述这个类}
 */
public class DateUtil {
    private static String mYear;
    private static String mMonth;
    private static String mDay;
    private static String mWay;
    private static String mHour;
    private static String mMinute;
    private static String mSecond;

    /**
     *
     * @return 获取年月日时分秒 例2019-08-09 12:08:06
     */
    public static String getTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// HH:mm:ss
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    /**
     *
     * @return 获取年月日
     */
    public static String getDay(){
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码

        return mYear + "-" + mMonth + "-" + mDay;
    }
    public static int getYear() {

        Calendar c = Calendar.getInstance();

        return c.get(Calendar.YEAR) ;
    }
    public static String getmMonth() {

        Calendar c = Calendar.getInstance();
        if(c.get(Calendar.MONTH) + 1<10){
            mMonth = "0"+String.valueOf(c.get(Calendar.MONTH) + 1);
        }else {
            mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);
        }
        return mMonth;
    }
    public static String getmToday() {

        Calendar c = Calendar.getInstance();
        if(c.get(Calendar.DAY_OF_MONTH)<10){
            mDay = "0"+String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        }else {
            mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        }

        return mDay;
    }
    public static String getWeek(){
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if("1".equals(mWay)){
            mWay ="天";
        }else if("2".equals(mWay)){
            mWay ="一";
        }else if("3".equals(mWay)){
            mWay ="二";
        }else if("4".equals(mWay)){
            mWay ="三";
        }else if("5".equals(mWay)){
            mWay ="四";
        }else if("6".equals(mWay)){
            mWay ="五";
        }else if("7".equals(mWay)){
            mWay ="六";
        }
        return "星期"+mWay;
    }
}
