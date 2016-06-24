package com.yzw.timer.vo.carInfo;

/**
 * Created by BoYang
 * 日期:2016/5/13
 * 时间:22:14.
 * .
 */
public class CarVO {
    private String EV_ID;
    private String flag;

    public String getEV_ID() {
        return EV_ID;
    }

    public void setEV_ID(String EV_ID) {
        this.EV_ID = EV_ID;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String toSql(){
        return "('"+this.EV_ID+"','"+this.flag+"')";

    }

    public String toTHead(){
        return "insert into leibo_car_register (EV_ID,flag) values";
    }
}