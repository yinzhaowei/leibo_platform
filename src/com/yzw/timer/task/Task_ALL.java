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
    private int id;//����ID

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * ȡ����ʱ��
     */
    public void stop(){
        this.cancel();//ȡ����ʱ��
        System.exit(0);
    }

    @Override
    public void run() {
        Action_ALL action = new Action_ALL();
        if(DateUtil.getCurrentHour()>= Integer.parseInt(CommonConstrants.STARTHOUR)&&DateUtil.getCurrentHour()<Integer.parseInt(CommonConstrants.ENDHOUR)){
            action.execute();
        }else{
            LogUtil.info("�Ǵ���ʱ�䡣��������ʱ�䡾"+CommonConstrants.STARTHOUR+","+CommonConstrants.ENDHOUR+"��");
            CommonConstrants.firstTimeList.clear();//����б�
        }

    }
}
