package com.yzw.timer.vo.socket;

public class DataVO {
	private byte[] msgPrefix={0x23,0x23};  //消息前缀 //固定为ASCII 字符‘##’，用“0x23, 0x23”表示
	private int msgCode; // //消息 ID BYTE
	private int msgYingDa;  //消息应答 BYTE
	private int msgAutoId; // //消息流水号 WORD 按发送顺序从 0 开始循环累加
	private String msgVIN; // //VIN码	由17 位字码构成，字码应符合GB16735 中的规定。
	private int msgIsRSA; // /"0x00：数据不加密；0x01：数据经过RSA算法加密；	0xFF：无效数据；其它预留"
	private int msgBodyLenth; // //消息体长度 WORD 数据单元长度是数据单元的总字节数，有效值范围：0～65534
	private byte[] msgBodyData; // //消息体

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
