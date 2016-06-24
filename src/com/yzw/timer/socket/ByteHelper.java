package com.yzw.timer.socket;

import com.yzw.timer.util.CommonConstrants;
import com.yzw.timer.util.DateUtil;
import com.yzw.timer.vo.socket.CarRegisterVO;
import com.yzw.timer.vo.socket.PlatformVerfiyVO;

/**
 * Created by BoYang
 * 日期:2016/5/7
 * 时间:12:06.
 * .
 */
public class ByteHelper {

    /**
     *认证报文
     * @return
     */
    public static byte[] toVerifyByte(){
        int liushuihao = 1;
        liushuihao=(liushuihao +1) & 0xffff ;
        PlatformVerfiyVO vo = new PlatformVerfiyVO();
        vo.setUser(CommonConstrants.PingTai_User);
        vo.setPwd(CommonConstrants.PingTai_Pwd);
        vo.setType(1);
        vo.setMsgCode(0x07);
        vo.setMsgIsRSA(0);
        vo.setMsgVIN(CommonConstrants.MyVIN);
        vo.setMsgYingDa(0xFE);
        vo.setMsgAutoId(liushuihao);
        vo.setMsgBodyData(vo.toByte());
        vo.setMsgBodyLenth(vo.getMsgBodyData().length);

        byte[] sendData= DataPacketUtil.EncodeProtocolData(vo);
        return sendData;
    }

    /**
     * 车辆注册
     * @return
     */
    public static byte[] toCarRegister(CarRegisterVO vo){

        int liushuihao = 1;
        liushuihao=(liushuihao +1) & 0xffff;
        vo.setCreatetime(DateUtil.getCurrentTime());
        vo.setCartype(1);
        vo.setMsgCode(0x01);
        vo.setMsgIsRSA(0);
        vo.setMsgYingDa(0xFE);
        vo.setMsgAutoId(liushuihao);
        vo.setMsgBodyData(vo.toByte());
        vo.setMsgBodyLenth(vo.getMsgBodyData().length);
        byte[] sendData= DataPacketUtil.EncodeProtocolData(vo);
        return sendData;

    }

}
