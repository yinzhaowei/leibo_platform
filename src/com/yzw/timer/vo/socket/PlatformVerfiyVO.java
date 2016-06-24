package com.yzw.timer.vo.socket;

import com.yzw.timer.socket.DataPacketUtil;

/**
 * ƽ̨��֤
 * Created by BoYang
 * ����:2016/5/7
 * ʱ��:11:03.
 * .
 */
public class PlatformVerfiyVO extends DataVO {
    private String user;//�û���
    private String pwd;//����
    private int type;//1���ͳ��� 2����Ӫ��˾

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
     * ת���ֽ���
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
