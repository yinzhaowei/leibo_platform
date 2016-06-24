package com.yzw.timer.task;
import com.yzw.timer.action.Action_ALL;
import com.yzw.timer.dto.Dto;
import com.yzw.timer.util.CommonConstrants;
import com.yzw.timer.util.DateUtil;
import com.yzw.timer.util.LogUtil;

import java.util.*;

/**
 * Created by BoYang on 2015/10/27.
 */
public class Task_ALL extends TimerTask{
    private int id;//车辆ID

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * 取消定时器
     */
    public void stop(){
        this.cancel();//取消定时器
        System.exit(0);
    }

    @Override
    public void run() {
        Action_ALL action = new Action_ALL();
        if(DateUtil.getCurrentHour()>= Integer.parseInt(CommonConstrants.STARTHOUR)&&DateUtil.getCurrentHour()<Integer.parseInt(CommonConstrants.ENDHOUR)){
            action.execute();
        }else{
            LogUtil.info("非处理时间。。。处理时间【"+CommonConstrants.STARTHOUR+","+CommonConstrants.ENDHOUR+"】");
            CommonConstrants.firstTimeList.clear();//清除列表
        }

    }
}
