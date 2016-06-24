//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yzw.timer.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public DateUtil() {
    }

    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        return df.format(new Date());
    }

    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
        return df.format(new Date());
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        return df.format(new Date());
    }

    public static void main(String[] args) {
        System.out.println(getCurrentTime());
        String a = "7E232301FE000131000000000000000000000000000000000000161005070D183B01310000000000000000000000000000D57E";
        String b = "7E232301FE000231000000000000000000000000000000000000161005070D231801C9EACED60000000000000000000000C47E";
    }

    public static String getCurrentMonth() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
        return df.format(new Date());
    }

    public static int getCurrentHour() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(11);
        return hour;
    }

    public static String utf8(String tmp) {
        String ret = "";

        try {
            new String(tmp.getBytes("GBK"), "UTF-8");
        } catch (UnsupportedEncodingException var3) {
            var3.printStackTrace();
        }

        return tmp;
    }

    public static String getDate(int day) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, -day);
        date = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
