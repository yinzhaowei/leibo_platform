package com.yzw.timer;

import com.yzw.timer.util.LogUtil;
import com.yzw.timer.util.CommonConstrants;
import com.yzw.timer.task.Task_ALL;

import java.util.Timer;

/**
 * Created by BoYang on 2015/10/27.
 */
public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Task_ALL task1 = new Task_ALL();
        task1.setId(0);
        //加载配置信息
        CommonConstrants.loadConfig();
        LogUtil.info("程序开始启动");
        timer.schedule(task1,Integer.parseInt(CommonConstrants.BEGIN),Integer.parseInt(CommonConstrants.INTERVAL));
    }
}
