//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.yzw.timer.util;

import com.yzw.timer.util.LogUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommonConstrants {
    public static String INTERVAL;
    public static String BEGIN;
    public static String STARTHOUR;
    public static String ENDHOUR;
    public static String history_table;
    public static String info_table;
    public static String osa_history;
    public static String osa_carInfo;
    public static String limit;
    public static String leibo_history_table;
    public static String curTable;
    public static String leibo_realtime_info;
    public static String PingTai_IP;
    public static int PingTai_Port;
    public static String PingTai_User;
    public static String PingTai_Pwd;
    public static String MyVIN;
    public static String whereV;
    public static Map firstTimeList = new HashMap();

    public CommonConstrants() {
    }

    public static void loadConfig() {
        Properties prop = new Properties();

        try {
            InputStream e = CommonConstrants.class.getClassLoader().getResourceAsStream("index.properties");
            prop.load(e);
        } catch (IOException var2) {
            var2.printStackTrace();
            LogUtil.error("未找到index.properties配置文件");
        }

        INTERVAL = prop.getProperty("interval.time");
        BEGIN = prop.getProperty("begin");
        STARTHOUR = prop.getProperty("starthour");
        ENDHOUR = prop.getProperty("endhour");
        history_table = prop.getProperty("history_table");
        info_table = prop.getProperty("info_table");
        osa_history = prop.getProperty("osa_history");
        osa_carInfo = prop.getProperty("osa_carInfo");
        limit = prop.getProperty("limit");
        leibo_history_table = prop.getProperty("leibo_history_table");
        leibo_realtime_info = prop.getProperty("leibo_realtime_info");
        PingTai_IP = prop.getProperty("PingTai_IP");
        PingTai_Port = Integer.parseInt(prop.getProperty("PingTai_Port"));
        PingTai_User = prop.getProperty("PingTai_User");
        PingTai_Pwd = prop.getProperty("PingTai_Pwd");
        MyVIN = prop.getProperty("MyVIN");
        whereV = "万象";
    }

    public static void main(String[] args) throws Exception {
        File file = new File("/");
        File[] tempList = file.listFiles();

        for(int i = 0; i < tempList.length; ++i) {
            System.out.println(tempList[i].getName());
        }

    }
}
