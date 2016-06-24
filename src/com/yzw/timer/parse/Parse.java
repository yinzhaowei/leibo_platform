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
 * ����:2016/1/28
 * ʱ��:7:45.
 * .
 */
public class Parse {
    /**
     * ������ʷЭ���
     * @param rs
     * @return
     * @throws Exception
     */
    public static HistroyVO parse_HistroyVO(ResultSet rs)throws Exception{
        HistroyVO vo = new HistroyVO();
        vo.setXID(String.valueOf(rs.getInt("XID")));//intϵͳID���
        vo.setEV_ID(String.valueOf(rs.getInt("EV_ID")));//����ID int
        vo.setSPEED(String.valueOf(rs.getDouble("SPEED")));//�ٶ�   double
        vo.setERR_CODE(String.valueOf(rs.getInt("ERR_CODE")));//���ϴ��� int
        vo.setVOLTAGE(String.valueOf(rs.getDouble("VOLTAGE")));//���ص�ѹ double
        vo.setVOLTAGEALL(String.valueOf(rs.getDouble("VOLTAGEALL")));//����ܵ�ѹ double
        vo.setCURRENTALL(String.valueOf(rs.getDouble("CURRENTALL")));//����ܵ��� double
        vo.setGPS_LAT(String.valueOf(rs.getDouble("GPS_LAT")));//���� double
        vo.setGPS_LNG(String.valueOf(rs.getDouble("GPS_LNG")));//ά�� double
        vo.setSOC(String.valueOf(rs.getDouble("SOC")));//SOCֵ double
        vo.setRESISTANCE(String.valueOf(rs.getDouble("RESISTANCE")));//��Ե����ֵdouble
        vo.setVOL_MAX(String.valueOf(rs.getDouble("VOL_MAX")));//�����ѹ���ֵdouble
        vo.setVOL_MAX_POS(String.valueOf(rs.getInt("VOL_MAX_POS")));//�����ѹ���ֵ�ں�smallint
        vo.setVOL_MAX_XIANG(String.valueOf(rs.getInt("VOL_MAX_XIANG")));//�����ѹ���ֵ���smallint
        vo.setVOL_MIN(String.valueOf(rs.getDouble("VOL_MIN")));//�����ѹ���ֵ  double
        vo.setVOL_MIN_POS(String.valueOf(rs.getInt("VOL_MIN_POS")));//�����ѹ���ֵ�ں�smallint
        vo.setVOL_MIN_XIANG(String.valueOf(rs.getInt("VOL_MIN_XIANG")));// �����ѹ���ֵ���smallint
        vo.setTEMPE_MAX(String.valueOf(rs.getDouble("TEMPE_MAX")));// �����¶����double
        vo.setTEMPE_MAX_POS(String.valueOf(rs.getInt("TEMPE_MAX_POS")));//�����¶���߽ںţ�smallint
        vo.setTEMPE_MAX_XIANG(String.valueOf(rs.getInt("TEMPE_MAX_XIANG")));//�����¶�������smallint
        vo.setTEMPE_MIN(String.valueOf(rs.getDouble("TEMPE_MIN")));//�����¶����double
        vo.setTEMPE_MIN_POS(String.valueOf(rs.getInt("TEMPE_MIN_POS")));//�����¶���ͽں�smallint
        vo.setTEMPE_MIN_XIANG(String.valueOf(rs.getInt("TEMPE_MIN_XIANG")));//�����¶�������smallint
        vo.setLAST_TIME(String.valueOf(rs.getTimestamp("LAST_TIME")));//����¼ʱ�� timestamp
        vo.setDASH_ERR_CODE(String.valueOf(rs.getInt("DASH_ERR_CODE")));//�Ǳ�������1  int
        vo.setDASH_ERR_CODE2(String.valueOf(rs.getInt("DASH_ERR_CODE2")));//�Ǳ�������2  int
        vo.setDASH_ERR_CODE3(String.valueOf(rs.getInt("DASH_ERR_CODE3")));//  ����
        vo.setDASH_ERR_CODE4(String.valueOf(rs.getInt("DASH_ERR_CODE4")));//����
        vo.setCREATETIME(DateUtil.getCurrentDateTime());

        if(Parse.isExitColumn(rs,"VINCODE"))
            vo.setVINCODE(rs.getString("VINCODE"));
        else vo.setVINCODE("05GBEV" + rs.getString("phone"));
        vo.setQIYEVIN("");
        return vo;
    }

    /**
     * ����������Ϣ��
     * @param rs
     * @return
     * @throws Exception
     */
    public static CarInfoVO parse_CarInfoVO(ResultSet rs) throws Exception{
        CarInfoVO vo = new CarInfoVO();
        vo.setEV_ID(String.valueOf(rs.getInt("EV_ID")));//int(10) NOT NULL,����ID
        vo.setEV_NAME(String.valueOf(rs.getString("EV_NAME")));//varchar(255) NOT NULL��������
        vo.setERP_ID(rs.getString("ERP_ID"));//varchar(255) DEFAULT NULL,ERPID    ERP���  ERP_ID
        vo.setEV_TYPE(String.valueOf(rs.getInt("EV_TYPE")));//int(8) NOT NULL, ��������
        vo.setEV_NUM(rs.getString("EV_NUM"));//char(20) DEFAULT NULL,���ƺ�
        vo.setBT_ID(rs.getString("BT_ID"));// char(20) NOT NULL DEFAULT '',       ��ر�־,
        vo.setCOMP_ID(String.valueOf(rs.getInt("COMP_ID")));//int(8) NOT NULL DEFAULT '0', ��˾ID
        vo.setMANUFCTUR(rs.getString("MANUFCTUR"));// varchar(255) DEFAULT NULL,      ��Ӧ��
        vo.setCOMMENT(rs.getString("COMMENT"));//varchar(255) DEFAULT NULL, ��·����
        vo.setBATT_TYPE(rs.getString("BATT_TYPE"));//varchar(255) DEFAULT NULL,      �������
        vo.setAC_TYPE(rs.getString("AC_TYPE"));// varchar(255) DEFAULT NULL,�յ�Ʒ�ƣ���֥����̩������
        vo.setMOBILE_NUM(rs.getString("MOBILE_NUM"));//char(11) DEFAULT NULL,�ֻ���
        vo.setNSC(String.valueOf(rs.getInt("NSC")));// tinyint(4) NOT NULL DEFAULT '0',      �����ã�
        vo.setFIRST_USE(String.valueOf(rs.getDate("FIRST_USE")));//date DEFAULT NULL,		    ����ʱ��

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
