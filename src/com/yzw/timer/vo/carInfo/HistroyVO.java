package com.yzw.timer.vo.carInfo;

/**
 * Created by BoYang
 * ����:2016/4/22
 * ʱ��:11:09.
 * .
 */
public class HistroyVO {
    private String XID;//ϵͳID���int
    private String EV_ID;//����ID int
    private String SPEED;//�ٶ�   double
    private String ERR_CODE;//���ϴ��� int
    private String VOLTAGE;// ���ص�ѹ double
    private String VOLTAGEALL;// ����ܵ�ѹ double
    private String CURRENTALL;// ����ܵ��� double
    private String GPS_LAT;//  ���� double
    private String GPS_LNG;//ά�� double
    private String SOC;//SOCֵ double
    private String RESISTANCE;//��Ե����ֵdouble
    private String VOL_MAX;//�����ѹ���ֵdouble
    private String VOL_MAX_POS;//�����ѹ���ֵ�ں�smallint
    private String VOL_MAX_XIANG;// �����ѹ���ֵ���smallint
    private String VOL_MIN;//�����ѹ���ֵ  double
    private String VOL_MIN_POS;//�����ѹ���ֵ�ں�smallint
    private String VOL_MIN_XIANG;// �����ѹ���ֵ���smallint
    private String TEMPE_MAX;// �����¶����double
    private String TEMPE_MAX_POS;//  �����¶���߽ںţ�smallint
    private String TEMPE_MAX_XIANG;// �����¶�������smallint
    private String TEMPE_MIN;// �����¶����double
    private String TEMPE_MIN_POS;// �����¶���ͽں�smallint
    private String TEMPE_MIN_XIANG;// �����¶�������smallint
    private String LAST_TIME;// ����¼ʱ�� timestamp
    private String DASH_ERR_CODE;// �Ǳ�������1
    private String DASH_ERR_CODE2;// �Ǳ�������2 int
    private String DASH_ERR_CODE3;// ���� timestamp
    private String DASH_ERR_CODE4;// ���� timestamp

    private String tableName;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getXID() {
        return XID;
    }

    public void setXID(String XID) {
        this.XID = XID;
    }

    public String getEV_ID() {
        return EV_ID;
    }

    public void setEV_ID(String EV_ID) {
        this.EV_ID = EV_ID;
    }

    public String getSPEED() {
        return SPEED;
    }

    public void setSPEED(String SPEED) {
        this.SPEED = SPEED;
    }

    public String getERR_CODE() {
        return ERR_CODE;
    }

    public void setERR_CODE(String ERR_CODE) {
        this.ERR_CODE = ERR_CODE;
    }

    public String getVOLTAGE() {
        return VOLTAGE;
    }

    public void setVOLTAGE(String VOLTAGE) {
        this.VOLTAGE = VOLTAGE;
    }

    public String getVOLTAGEALL() {
        return VOLTAGEALL;
    }

    public void setVOLTAGEALL(String VOLTAGEALL) {
        this.VOLTAGEALL = VOLTAGEALL;
    }

    public String getCURRENTALL() {
        return CURRENTALL;
    }

    public void setCURRENTALL(String CURRENTALL) {
        this.CURRENTALL = CURRENTALL;
    }

    public String getGPS_LNG() {
        return GPS_LNG;
    }

    public void setGPS_LNG(String GPS_LNG) {
        this.GPS_LNG = GPS_LNG;
    }

    public String getGPS_LAT() {
        return GPS_LAT;
    }

    public void setGPS_LAT(String GPS_LAT) {
        this.GPS_LAT = GPS_LAT;
    }

    public String getSOC() {
        return SOC;
    }

    public void setSOC(String SOC) {
        this.SOC = SOC;
    }

    public String getRESISTANCE() {
        return RESISTANCE;
    }

    public void setRESISTANCE(String RESISTANCE) {
        this.RESISTANCE = RESISTANCE;
    }

    public String getVOL_MAX() {
        return VOL_MAX;
    }

    public void setVOL_MAX(String VOL_MAX) {
        this.VOL_MAX = VOL_MAX;
    }

    public String getVOL_MAX_POS() {
        return VOL_MAX_POS;
    }

    public void setVOL_MAX_POS(String VOL_MAX_POS) {
        this.VOL_MAX_POS = VOL_MAX_POS;
    }

    public String getVOL_MAX_XIANG() {
        return VOL_MAX_XIANG;
    }

    public void setVOL_MAX_XIANG(String VOL_MAX_XIANG) {
        this.VOL_MAX_XIANG = VOL_MAX_XIANG;
    }

    public String getVOL_MIN() {
        return VOL_MIN;
    }

    public void setVOL_MIN(String VOL_MIN) {
        this.VOL_MIN = VOL_MIN;
    }

    public String getVOL_MIN_POS() {
        return VOL_MIN_POS;
    }

    public void setVOL_MIN_POS(String VOL_MIN_POS) {
        this.VOL_MIN_POS = VOL_MIN_POS;
    }

    public String getVOL_MIN_XIANG() {
        return VOL_MIN_XIANG;
    }

    public void setVOL_MIN_XIANG(String VOL_MIN_XIANG) {
        this.VOL_MIN_XIANG = VOL_MIN_XIANG;
    }

    public String getTEMPE_MAX() {
        return TEMPE_MAX;
    }

    public void setTEMPE_MAX(String TEMPE_MAX) {
        this.TEMPE_MAX = TEMPE_MAX;
    }

    public String getTEMPE_MAX_POS() {
        return TEMPE_MAX_POS;
    }

    public void setTEMPE_MAX_POS(String TEMPE_MAX_POS) {
        this.TEMPE_MAX_POS = TEMPE_MAX_POS;
    }

    public String getTEMPE_MAX_XIANG() {
        return TEMPE_MAX_XIANG;
    }

    public void setTEMPE_MAX_XIANG(String TEMPE_MAX_XIANG) {
        this.TEMPE_MAX_XIANG = TEMPE_MAX_XIANG;
    }

    public String getTEMPE_MIN() {
        return TEMPE_MIN;
    }

    public void setTEMPE_MIN(String TEMPE_MIN) {
        this.TEMPE_MIN = TEMPE_MIN;
    }

    public String getTEMPE_MIN_POS() {
        return TEMPE_MIN_POS;
    }

    public void setTEMPE_MIN_POS(String TEMPE_MIN_POS) {
        this.TEMPE_MIN_POS = TEMPE_MIN_POS;
    }

    public String getTEMPE_MIN_XIANG() {
        return TEMPE_MIN_XIANG;
    }

    public void setTEMPE_MIN_XIANG(String TEMPE_MIN_XIANG) {
        this.TEMPE_MIN_XIANG = TEMPE_MIN_XIANG;
    }

    public String getLAST_TIME() {
        return LAST_TIME;
    }

    public void setLAST_TIME(String LAST_TIME) {
        this.LAST_TIME = LAST_TIME;
    }

    public String getDASH_ERR_CODE() {
        return DASH_ERR_CODE;
    }

    public void setDASH_ERR_CODE(String DASH_ERR_CODE) {
        this.DASH_ERR_CODE = DASH_ERR_CODE;
    }

    public String getDASH_ERR_CODE2() {
        return DASH_ERR_CODE2;
    }

    public void setDASH_ERR_CODE2(String DASH_ERR_CODE2) {
        this.DASH_ERR_CODE2 = DASH_ERR_CODE2;
    }

    public String getDASH_ERR_CODE3() {
        return DASH_ERR_CODE3;
    }

    public void setDASH_ERR_CODE3(String DASH_ERR_CODE3) {
        this.DASH_ERR_CODE3 = DASH_ERR_CODE3;
    }

    public String getDASH_ERR_CODE4() {
        return DASH_ERR_CODE4;
    }

    public void setDASH_ERR_CODE4(String DASH_ERR_CODE4) {
        this.DASH_ERR_CODE4 = DASH_ERR_CODE4;
    }

    @Override
    public String toString(){
        return "{XID="+this.XID+",EV_ID="+this.EV_ID+",SPEED="+this.SPEED+",ERR_CODE="+this.ERR_CODE+",VOLTAGE="+this.VOLTAGE+",VOLTAGEALL="+this.VOLTAGEALL
                +",CURRENTALL="+this.CURRENTALL+",GPS_LAT="+this.GPS_LAT+",GPS_LNG="+this.GPS_LNG+",SOC="+this.SOC+",RESISTANCE="+this.RESISTANCE
                +",VOL_MAX="+this.VOL_MAX+",VOL_MAX_POS="+this.VOL_MAX_POS+",VOL_MAX_XIANG="+this.VOL_MAX_XIANG+",VOL_MIN="+this.VOL_MIN+",VOL_MIN_POS="+this.VOL_MIN_POS
                +",VOL_MIN_XIANG="+this.VOL_MIN_XIANG+",TEMPE_MAX="+this.TEMPE_MAX+",TEMPE_MAX_POS="+this.TEMPE_MAX_POS+",TEMPE_MAX_XIANG="+this.TEMPE_MAX_XIANG
                +",TEMPE_MIN="+this.TEMPE_MIN+",TEMPE_MIN_POS="+this.TEMPE_MIN_POS+",TEMPE_MIN_XIANG="+this.TEMPE_MIN_XIANG+",LAST_TIME="+this.LAST_TIME
                +",DASH_ERR_CODE="+this.DASH_ERR_CODE +",DASH_ERR_CODE2="+this.DASH_ERR_CODE2+",DASH_ERR_CODE3="+this.DASH_ERR_CODE3+",DASH_ERR_CODE4="+this.DASH_ERR_CODE4+"}";

    }

    public String toSql(){
        return "('"+this.XID+"','"+this.EV_ID+"','"+this.SPEED+"','"+this.ERR_CODE+"','"+this.VOLTAGE+"','"+this.VOLTAGEALL
                +"','"+this.CURRENTALL+"','"+this.GPS_LAT+"','"+this.GPS_LNG+"','"+this.SOC+"','"+this.RESISTANCE
                +"','"+this.VOL_MAX+"','"+this.VOL_MAX_POS+"','"+this.VOL_MAX_XIANG+"','"+this.VOL_MIN+"','"+this.VOL_MIN_POS
                +"','"+this.VOL_MIN_XIANG+"','"+this.TEMPE_MAX+"','"+this.TEMPE_MAX_POS+"','"+this.TEMPE_MAX_XIANG
                +"','"+this.TEMPE_MIN+"','"+this.TEMPE_MIN_POS+"','"+this.TEMPE_MIN_XIANG+"','"+this.LAST_TIME
                +"','"+this.DASH_ERR_CODE +"','"+this.DASH_ERR_CODE2+"','"+this.DASH_ERR_CODE3+"','"+this.DASH_ERR_CODE4+"')";

    }

    public String toTHead(){
        return "insert into "+ this.tableName+" (XID,EV_ID,SPEED,ERR_CODE,VOLTAGE,VOLTAGEALL,CURRENTALL,GPS_LAT,GPS_LNG,SOC,RESISTANCE,VOL_MAX,VOL_MAX_POS,VOL_MAX_XIANG,VOL_MIN,VOL_MIN_POS,VOL_MIN_XIANG,TEMPE_MAX,TEMPE_MAX_POS,TEMPE_MAX_XIANG,TEMPE_MIN,TEMPE_MIN_POS,TEMPE_MIN_XIANG,LAST_TIME,DASH_ERR_CODE,DASH_ERR_CODE2,DASH_ERR_CODE3,DASH_ERR_CODE4) values";
    }
}
