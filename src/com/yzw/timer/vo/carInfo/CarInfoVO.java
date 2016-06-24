package com.yzw.timer.vo.carInfo;

import com.yzw.timer.util.CommonConstrants;

/**
 * Created by BoYang
 * ����:2016/4/22
 * ʱ��:11:10.
 * .
 */
public class CarInfoVO {
    private String EV_ID;//����ID
    private String EV_NAME;//��������
    private String ERP_ID;//ERP���
    private String EV_TYPE;//��������
    private String EV_NUM;//���ƺ�
    private String BT_ID;//��ر�־
    private String COMP_ID;//��˾ID
    private String MANUFCTUR;//��Ӧ��
    private String COMMENT;//��·����
    private String BATT_TYPE;//�������
    private String AC_TYPE;//�յ�Ʒ�ƣ���֥����̩������
    private String MOBILE_NUM;//�ֻ���
    private String NSC;//�����ã�
    private String FIRST_USE;//����ʱ��

    public String getEV_ID() {
        return EV_ID;
    }

    public void setEV_ID(String EV_ID) {
        this.EV_ID = EV_ID;
    }

    public String getEV_NAME() {
        return EV_NAME;
    }

    public void setEV_NAME(String EV_NAME) {
        this.EV_NAME = EV_NAME;
    }

    public String getERP_ID() {
        return ERP_ID;
    }

    public void setERP_ID(String ERP_ID) {
        this.ERP_ID = ERP_ID;
    }

    public String getEV_TYPE() {
        return EV_TYPE;
    }

    public void setEV_TYPE(String EV_TYPE) {
        this.EV_TYPE = EV_TYPE;
    }

    public String getEV_NUM() {
        return EV_NUM;
    }

    public void setEV_NUM(String EV_NUM) {
        this.EV_NUM = EV_NUM;
    }

    public String getBT_ID() {
        return BT_ID;
    }

    public void setBT_ID(String BT_ID) {
        this.BT_ID = BT_ID;
    }

    public String getCOMP_ID() {
        return COMP_ID;
    }

    public void setCOMP_ID(String COMP_ID) {
        this.COMP_ID = COMP_ID;
    }

    public String getMANUFCTUR() {
        return MANUFCTUR;
    }

    public void setMANUFCTUR(String MANUFCTUR) {
        this.MANUFCTUR = MANUFCTUR;
    }

    public String getCOMMENT() {
        return COMMENT;
    }

    public void setCOMMENT(String COMMENT) {
        this.COMMENT = COMMENT;
    }

    public String getBATT_TYPE() {
        return BATT_TYPE;
    }

    public void setBATT_TYPE(String BATT_TYPE) {
        this.BATT_TYPE = BATT_TYPE;
    }

    public String getAC_TYPE() {
        return AC_TYPE;
    }

    public void setAC_TYPE(String AC_TYPE) {
        this.AC_TYPE = AC_TYPE;
    }

    public String getMOBILE_NUM() {
        return MOBILE_NUM;
    }

    public void setMOBILE_NUM(String MOBILE_NUM) {
        this.MOBILE_NUM = MOBILE_NUM;
    }

    public String getNSC() {
        return NSC;
    }

    public void setNSC(String NSC) {
        this.NSC = NSC;
    }

    public String getFIRST_USE() {
        return FIRST_USE;
    }

    public void setFIRST_USE(String FIRST_USE) {
        this.FIRST_USE = FIRST_USE;
    }

    @Override
    public String toString() {

        return "{EV_ID="+this.EV_ID+",EV_NAME="+this.EV_NAME+",ERP_ID="+this.ERP_ID+",EV_TYPE="+this.EV_TYPE+",EV_NUM="+this.EV_NUM+",BT_ID="
                +this.BT_ID+",COMP_ID="+this.COMP_ID+",MANUFCTUR="+this.MANUFCTUR+",COMMENT="+this.COMMENT+",BATT_TYPE="+this.BATT_TYPE+",AC_TYPE="+this.AC_TYPE
                +",MOBILE_NUM="+this.MOBILE_NUM+",NSC="+this.NSC+",FIRST_USE="+this.FIRST_USE+"}";

    }

    public String toSql(){
        return "('"+this.EV_ID+"','"+this.EV_NAME+"','"+this.ERP_ID+"','"+this.EV_TYPE+"','"+this.EV_NUM+"','"
                +this.BT_ID+"','"+this.COMP_ID+"','"+this.MANUFCTUR+"','"+this.COMMENT+"','"+this.BATT_TYPE+"','"+this.AC_TYPE
                +"','"+this.MOBILE_NUM+"','"+this.NSC+"','"+this.FIRST_USE+"')";
    }

    public String toTHead(){
        return "insert into "+ CommonConstrants.osa_carInfo+" (EV_ID,EV_NAME,ERP_ID,EV_TYPE,EV_NUM,BT_ID,COMP_ID,MANUFCTUR,COMMENT,BATT_TYPE,AC_TYPE,MOBILE_NUM,NSC,FIRST_USE) values ";
    }
}
