package com.yzw.timer.parse;

import com.yzw.timer.util.CommonConstrants;
import com.yzw.timer.util.DateUtil;
import com.yzw.timer.vo.CarInfoVO;
import com.yzw.timer.vo.HistroyVO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by BoYang
 * 日期:2016/1/28
 * 时间:7:45.
 * .
 */
public class Parse {
    /**
     * 解析历史协议表
     * @param rs
     * @return
     * @throws Exception
     */
    public static HistroyVO parse_HistroyVO(ResultSet rs)throws Exception{
        HistroyVO vo = new HistroyVO();
        vo.setXID(String.valueOf(rs.getInt("XID")));//int系统ID编号
        vo.setEV_ID(String.valueOf(rs.getInt("EV_ID")));//车辆ID int
        vo.setSPEED(String.valueOf(rs.getDouble("SPEED")));//速度   double
        vo.setERR_CODE(String.valueOf(rs.getInt("ERR_CODE")));//故障代码 int
        vo.setVOLTAGE(String.valueOf(rs.getDouble("VOLTAGE")));//蓄电池电压 double
        vo.setVOLTAGEALL(String.valueOf(rs.getDouble("VOLTAGEALL")));//电池总电压 double
        vo.setCURRENTALL(String.valueOf(rs.getDouble("CURRENTALL")));//电池总电流 double
        vo.setGPS_LAT(String.valueOf(rs.getDouble("GPS_LAT")));//经度 double
        vo.setGPS_LNG(String.valueOf(rs.getDouble("GPS_LNG")));//维度 double
        vo.setSOC(String.valueOf(rs.getDouble("SOC")));//SOC值 double
        vo.setRESISTANCE(String.valueOf(rs.getDouble("RESISTANCE")));//绝缘电阻值double
        vo.setVOL_MAX(String.valueOf(rs.getDouble("VOL_MAX")));//单体电压最高值double
        vo.setVOL_MAX_POS(String.valueOf(rs.getInt("VOL_MAX_POS")));//单体电压最高值节号smallint
        vo.setVOL_MAX_XIANG(String.valueOf(rs.getInt("VOL_MAX_XIANG")));//单体电压最高值箱号smallint
        vo.setVOL_MIN(String.valueOf(rs.getDouble("VOL_MIN")));//单体电压最低值  double
        vo.setVOL_MIN_POS(String.valueOf(rs.getInt("VOL_MIN_POS")));//单体电压最低值节号smallint
        vo.setVOL_MIN_XIANG(String.valueOf(rs.getInt("VOL_MIN_XIANG")));// 单体电压最低值箱号smallint
        vo.setTEMPE_MAX(String.valueOf(rs.getDouble("TEMPE_MAX")));// 单体温度最高double
        vo.setTEMPE_MAX_POS(String.valueOf(rs.getInt("TEMPE_MAX_POS")));//单体温度最高节号，smallint
        vo.setTEMPE_MAX_XIANG(String.valueOf(rs.getInt("TEMPE_MAX_XIANG")));//单体温度最高箱号smallint
        vo.setTEMPE_MIN(String.valueOf(rs.getDouble("TEMPE_MIN")));//单体温度最低double
        vo.setTEMPE_MIN_POS(String.valueOf(rs.getInt("TEMPE_MIN_POS")));//单体温度最低节号smallint
        vo.setTEMPE_MIN_XIANG(String.valueOf(rs.getInt("TEMPE_MIN_XIANG")));//单体温度最低箱号smallint
        vo.setLAST_TIME(String.valueOf(rs.getTimestamp("LAST_TIME")));//最后记录时间 timestamp
        vo.setDASH_ERR_CODE(String.valueOf(rs.getInt("DASH_ERR_CODE")));//仪表错误代码1  int
        vo.setDASH_ERR_CODE2(String.valueOf(rs.getInt("DASH_ERR_CODE2")));//仪表错误代码2  int
        vo.setDASH_ERR_CODE3(String.valueOf(rs.getInt("DASH_ERR_CODE3")));//  保留
        vo.setDASH_ERR_CODE4(String.valueOf(rs.getInt("DASH_ERR_CODE4")));//保留
        vo.setCREATETIME(DateUtil.getCurrentDateTime());

        if(Parse.isExitColumn(rs,"VINCODE"))
            vo.setVINCODE(rs.getString("VINCODE"));
        else vo.setVINCODE("05GBEV" + rs.getString("phone"));
        vo.setQIYEVIN("");
        return vo;
    }

    /**
     * 解析车辆信息表
     * @param rs
     * @return
     * @throws Exception
     */
    public static CarInfoVO parse_CarInfoVO(ResultSet rs) throws Exception{
        CarInfoVO vo = new CarInfoVO();
        vo.setEV_ID(String.valueOf(rs.getInt("EV_ID")));//int(10) NOT NULL,车辆ID
        vo.setEV_NAME(String.valueOf(rs.getString("EV_NAME")));//varchar(255) NOT NULL车辆名称
        vo.setERP_ID(rs.getString("ERP_ID"));//varchar(255) DEFAULT NULL,ERPID    ERP编号  ERP_ID
        vo.setEV_TYPE(String.valueOf(rs.getInt("EV_TYPE")));//int(8) NOT NULL, 车辆类型
        vo.setEV_NUM(rs.getString("EV_NUM"));//char(20) DEFAULT NULL,车牌号
        vo.setBT_ID(rs.getString("BT_ID"));// char(20) NOT NULL DEFAULT '',       电池标志,
        vo.setCOMP_ID(String.valueOf(rs.getInt("COMP_ID")));//int(8) NOT NULL DEFAULT '0', 公司ID
        vo.setMANUFCTUR(rs.getString("MANUFCTUR"));// varchar(255) DEFAULT NULL,      供应商
        vo.setCOMMENT(rs.getString("COMMENT"));//varchar(255) DEFAULT NULL, 几路公交
        vo.setBATT_TYPE(rs.getString("BATT_TYPE"));//varchar(255) DEFAULT NULL,      电池类型
        vo.setAC_TYPE(rs.getString("AC_TYPE"));// varchar(255) DEFAULT NULL,空调品牌（松芝，科泰。。）
        vo.setMOBILE_NUM(rs.getString("MOBILE_NUM"));//char(11) DEFAULT NULL,手机号
        vo.setNSC(String.valueOf(rs.getInt("NSC")));// tinyint(4) NOT NULL DEFAULT '0',      （不用）
        vo.setFIRST_USE(String.valueOf(rs.getDate("FIRST_USE")));//date DEFAULT NULL,		    上线时间

        return vo;
    }

    public static boolean isExitColumn(ResultSet rs,String name)throws Exception{
        List<String> result = new ArrayList<>();
        int total =  rs.getMetaData().getColumnCount();
        for (int i=0;i<total;i++){
            result.add(rs.getMetaData().getColumnName(i+1));
        }
        if(result.contains(name))
            return true;

        return false;
    }
}
