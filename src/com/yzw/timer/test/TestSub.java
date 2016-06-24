package com.yzw.timer.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by BoYang on 2015/11/3.
 */
public class TestSub {
    public static void main(String[] args)throws Exception{
        String xm="12345678";
        for (int i=0;i<10;i++)
        getABC();
    }

    public static void getABC() throws Exception{

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        Thread.sleep(1000);

    }
}
