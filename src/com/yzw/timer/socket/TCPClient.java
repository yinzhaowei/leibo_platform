package com.yzw.timer.socket;

import com.yzw.timer.util.CommonConstrants;
import com.yzw.timer.util.DateUtil;
import com.yzw.timer.util.LogUtil;
import com.yzw.timer.vo.socket.CarRegisterVO;
import com.yzw.timer.vo.socket.DataVO;

import java.io.IOException;


public class TCPClient {

	private SocketUtil FMyTCPClient=null;

	/**
	 * 关闭线程
 	 */
	public void closeRequest(){
		if(FMyTCPClient!=null){
		  if(FMyTCPClient!=null){
			  try {
				FMyTCPClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			  FMyTCPClient=null;
		  }
		}
	}

	/**
	 * 连接平台
	 * @return
	 */
	public  boolean connectPingTai(){
		  boolean tmprst=false;

		  if(FMyTCPClient!=null){
			  try {
				FMyTCPClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			  FMyTCPClient=null;
		  }

		  FMyTCPClient=new SocketUtil();
		  try {
			  FMyTCPClient.connect(CommonConstrants.PingTai_IP, CommonConstrants.PingTai_Port);
			  tmprst=true;
		} catch (Exception e) {
			tmprst=false;
			e.printStackTrace();
		}

		  return tmprst;

	}

	public static void main(String[] args) {
		TCPClient gyptrc = new TCPClient();
		CommonConstrants.loadConfig();
		gyptrc.sendRenZheng();
		CarRegisterVO vo = new CarRegisterVO();
		vo.setKccs("申沃");
		vo.setMsgVIN("1");
		gyptrc.sendCarRegister(vo);
	}

	/**
	 * 平台认证
	 * @return
	 */
	public int sendRenZheng(){
		int rst=-1;
		connectPingTai();
		byte []SendData = ByteHelper.toVerifyByte();
		String tmphex= DataPacketUtil.hexC(SendData);
		LogUtil.info("平台认证报文: " + tmphex);
	 	try {
			this.FMyTCPClient.sendBytes(SendData);
			byte[] getData=FMyTCPClient.readBytes();
			LogUtil.info("平台认证返回报文: " +  DataPacketUtil.hexC(getData));
			DataVO bheader= DataPacketUtil.decodeProtocolData(getData);
			LogUtil.info("平台认证返回状态: " + bheader.getMsgYingDa());

			rst= bheader.getMsgYingDa();

		} catch (IOException e) {
			LogUtil.error("平台认证异常["+e.getMessage()+"]");
		}finally {
		//	this.closeRequest();//关闭线程
		}
		return rst;
	}

	/**
	 * 平台认证
	 * @return
	 */
	public int sendCarRegister(CarRegisterVO vo){
		int rst=-1;
		connectPingTai();
		byte []SendData = ByteHelper.toCarRegister(vo);
		String tmphex= DataPacketUtil.hexC(SendData);
		LogUtil.info("平台车辆注册报文: " + tmphex.toUpperCase());
		try {
			this.FMyTCPClient.sendBytes(SendData);
			byte[] getData=FMyTCPClient.readBytes();
			LogUtil.info("平台车辆注册返回报文: " +  DataPacketUtil.hexC(getData));

			DataVO bheader= DataPacketUtil.decodeProtocolData(getData);
			LogUtil.info("平台车辆注册状态: " + bheader.getMsgYingDa());

			rst= bheader.getMsgYingDa();

		} catch (IOException e) {
			LogUtil.error("平台车辆注册异常["+e.getMessage()+"]");
		}finally {
			this.closeRequest();//关闭线程
		}
		return rst;
	}

}
