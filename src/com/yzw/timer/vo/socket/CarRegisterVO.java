package com.yzw.timer.vo.socket;

import com.yzw.timer.socket.DataPacketUtil;
import com.yzw.timer.util.DateUtil;

/**
 * Created by BoYang
 * 日期:2016/5/7
 * 时间:12:49.
 * .
 */
public class CarRegisterVO extends DataVO {
    private String createtime;//注册时间
    private int cartype;//车辆类型
    private String kccs;//客车厂商

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getCartype() {
        return cartype;
    }

    public void setCartype(int cartype) {
        this.cartype = cartype;
    }

    public String getKccs() {
        return kccs;
    }

    public void setKccs(String kccs) {
        this.kccs = kccs;
    }

    /**
     * 转换字节流
     * @return
     */
    public byte[] toByte(){

        byte[] byte6= DataPacketUtil.Str12DateToByte(this.createtime);//注册时间
        byte[] byte1= DataPacketUtil.BToB(this.cartype);
        byte[] byte4= DataPacketUtil.StrToByteArray(this.kccs, 2);
        byte[] byte11 = DataPacketUtil.HexStrToByteArray("",11);
        byte[] rst= DataPacketUtil.byteMerger(byte6, byte1);
        rst = DataPacketUtil.byteMerger(rst,byte4);
        rst = DataPacketUtil.byteMerger(rst,byte11);

        return rst;
    }


    public static void main(String[] args) {
        byte[] a = DataPacketUtil.HexStrToByteArray("",11);
        String tmphex= DataPacketUtil.hexC(a);

        System.out.println(DataPacketUtil.hexC(DataPacketUtil.StrToByteArray("申沃", 2)));
        //System.out.println("123");
    }
}
