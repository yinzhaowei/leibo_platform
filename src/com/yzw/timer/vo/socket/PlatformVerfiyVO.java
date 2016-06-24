package com.yzw.timer.vo.socket;

import com.yzw.timer.socket.DataPacketUtil;

/**
 * 平台认证
 * Created by BoYang
 * 日期:2016/5/7
 * 时间:11:03.
 * .
 */
public class PlatformVerfiyVO extends DataVO {
    private String user;//用户名
    private String pwd;//密码
    private int type;//1：客车厂 2：运营公司

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * 转换字节流
     * @return
     */
    public byte[] toByte(){
        byte[] byte1= DataPacketUtil.BToB(this.type);
        byte[] byte40= DataPacketUtil.StrToByteArray(this.user, 40);
        byte[] byte20= DataPacketUtil.StrToByteArray(this.pwd, 20);

        byte[] rst= DataPacketUtil.byteMerger(byte40, byte20);
        rst= DataPacketUtil.byteMerger(rst, byte1);

        return rst;
    }

}
