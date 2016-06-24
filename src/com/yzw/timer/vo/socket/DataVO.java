package com.yzw.timer.vo.socket;

public class DataVO {
	private byte[] msgPrefix={0x23,0x23};  //��Ϣǰ׺ //�̶�ΪASCII �ַ���##�����á�0x23, 0x23����ʾ
	private int msgCode; // //��Ϣ ID BYTE
	private int msgYingDa;  //��ϢӦ�� BYTE
	private int msgAutoId; // //��Ϣ��ˮ�� WORD ������˳��� 0 ��ʼѭ���ۼ�
	private String msgVIN; // //VIN��	��17 λ���빹�ɣ�����Ӧ����GB16735 �еĹ涨��
	private int msgIsRSA; // /"0x00�����ݲ����ܣ�0x01�����ݾ���RSA�㷨���ܣ�	0xFF����Ч���ݣ�����Ԥ��"
	private int msgBodyLenth; // //��Ϣ�峤�� WORD ���ݵ�Ԫ���������ݵ�Ԫ�����ֽ�������Чֵ��Χ��0��65534
	private byte[] msgBodyData; // //��Ϣ��

	public byte[] getMsgPrefix() {
		return msgPrefix;
	}

	public void setMsgPrefix(byte[] msgPrefix) {
		this.msgPrefix = msgPrefix;
	}

	public int getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(int msgCode) {
		this.msgCode = msgCode;
	}

	public int getMsgYingDa() {
		return msgYingDa;
	}

	public void setMsgYingDa(int msgYingDa) {
		this.msgYingDa = msgYingDa;
	}

	public int getMsgAutoId() {
		return msgAutoId;
	}

	public void setMsgAutoId(int msgAutoId) {
		this.msgAutoId = msgAutoId;
	}

	public String getMsgVIN() {
		return msgVIN;
	}

	public void setMsgVIN(String msgVIN) {
		this.msgVIN = msgVIN;
	}

	public int getMsgIsRSA() {
		return msgIsRSA;
	}

	public void setMsgIsRSA(int msgIsRSA) {
		this.msgIsRSA = msgIsRSA;
	}

	public int getMsgBodyLenth() {
		return msgBodyLenth;
	}

	public void setMsgBodyLenth(int msgBodyLenth) {
		this.msgBodyLenth = msgBodyLenth;
	}

	public byte[] getMsgBodyData() {
		return msgBodyData;
	}

	public void setMsgBodyData(byte[] msgBodyData) {
		this.msgBodyData = msgBodyData;
	}

}
