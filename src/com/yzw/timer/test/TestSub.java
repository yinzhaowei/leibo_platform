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

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
        Thread.sleep(1000);

    }
}
