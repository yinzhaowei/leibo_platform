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
	 * �ر��߳�
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
	 * ����ƽ̨
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
		vo.setKccs("����");
		vo.setMsgVIN("1");
		gyptrc.sendCarRegister(vo);
	}

	/**
	 * ƽ̨��֤
	 * @return
	 */
	public int sendRenZheng(){
		int rst=-1;
		connectPingTai();
		byte []SendData = ByteHelper.toVerifyByte();
		String tmphex= DataPacketUtil.hexC(SendData);
		LogUtil.info("ƽ̨��֤����: " + tmphex);
	 	try {
			this.FMyTCPClient.sendBytes(SendData);
			byte[] getData=FMyTCPClient.readBytes();
			LogUtil.info("ƽ̨��֤���ر���: " +  DataPacketUtil.hexC(getData));
			DataVO bheader= DataPacketUtil.decodeProtocolData(getData);
			LogUtil.info("ƽ̨��֤����״̬: " + bheader.getMsgYingDa());

			rst= bheader.getMsgYingDa();

		} catch (IOException e) {
			LogUtil.error("ƽ̨��֤�쳣["+e.getMessage()+"]");
		}finally {
		//	this.closeRequest();//�ر��߳�
		}
		return rst;
	}

	/**
	 * ƽ̨��֤
	 * @return
	 */
	public int sendCarRegister(CarRegisterVO vo){
		int rst=-1;
		connectPingTai();
		byte []SendData = ByteHelper.toCarRegister(vo);
		String tmphex= DataPacketUtil.hexC(SendData);
		LogUtil.info("ƽ̨����ע�ᱨ��: " + tmphex.toUpperCase());
		try {
			this.FMyTCPClient.sendBytes(SendData);
			byte[] getData=FMyTCPClient.readBytes();
			LogUtil.info("ƽ̨����ע�᷵�ر���: " +  DataPacketUtil.hexC(getData));

			DataVO bheader= DataPacketUtil.decodeProtocolData(getData);
			LogUtil.info("ƽ̨����ע��״̬: " + bheader.getMsgYingDa());

			rst= bheader.getMsgYingDa();

		} catch (IOException e) {
			LogUtil.error("ƽ̨����ע���쳣["+e.getMessage()+"]");
		}finally {
			this.closeRequest();//�ر��߳�
		}
		return rst;
	}

}
