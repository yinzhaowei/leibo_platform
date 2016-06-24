package com.yzw.timer.socket;

import com.yzw.timer.vo.socket.DataVO;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DataPacketUtil {
	/**
	 * byte转换
	 * @param res
	 * @return
	 */
	public static byte[] BToB(int res) {
		byte[] targets = new byte[1];

		targets[0] = (byte) (res & 0xff);// 最低位
		return targets;
	}

	/**
	 * word转换
	 * @param res
	 * @return
	 */
	public static byte[] WToB(int res) {
		byte[] targets = new byte[2];

		targets[1] = (byte) (res & 0xff);// 最低位
		targets[0] = (byte) ((res >> 8) & 0xff);// 次低位
		// /targets[2] = (byte) ((res >> 16) & 0xff);// 次高位
		// /targets[3] = (byte) (res >>> 24);// 最高位,无符号右移。
		return targets;
	}

	/**
	 * DWORD转换
	 * @param res
	 * @return
	 */
	public static byte[] DWToB(int res) {
		byte[] targets = new byte[4];

		targets[0] = (byte) ((res >>> 24) & 0xff);// 最高位,无符号右移。
		targets[1] = (byte) ((res >> 16) & 0xff);// 次高位
		targets[2] = (byte) ((res >> 8) & 0xff);// 次低位
		targets[3] = (byte) (res & 0xff);// 最低位

		return targets;
	}
	/**
	 * DWORD转换
	 * @param res
	 * @return
	 */
	public static byte[] DWToB(long res) {
		byte[] targets = new byte[4];

		targets[0] = (byte) ((res >>> 24) & 0xff);// 最高位,无符号右移。
		targets[1] = (byte) ((res >> 16) & 0xff);// 次高位
		targets[2] = (byte) ((res >> 8) & 0xff);// 次低位
		targets[3] = (byte) (res & 0xff);// 最低位

		return targets;
	}

	/**
	 * 转换16进制
 	 * @param rawData
	 * @return
	 */
	public static String hexC(byte[] rawData) {
		StringBuilder hexText = new StringBuilder();
		String initialHex = null;
		int initHexLength = 0;

		for (int i = 0; i < rawData.length; i++) {
			int positiveValue = rawData[i] & 0x000000FF;
			initialHex = Integer.toHexString(positiveValue);
			initHexLength = initialHex.length();
			while (initHexLength++ < 2) {
				hexText.append("0");
			}
			hexText.append(initialHex);
		}
		return hexText.toString();
	}


	/**
	 * 将byte数组bRefArr转为一个整数,字节数组的低位是整型的高字节位
	 * @param bRefArr
	 * @return
	 */
	public static int toIntR(byte[] bRefArr) {
		int iOutcome = 0;
		byte bLoop;

		for (int i = 0; i < bRefArr.length; i++) {
			bLoop = bRefArr[i];
			iOutcome = (iOutcome << 8) + (bLoop & 0xFF);
		}
		return iOutcome;
	}

	public static String DWToBin(int tmpdword) {
		String s = "00000000000000000000000000000000";
		s = s + Integer.toBinaryString(tmpdword);
		s = s.substring(s.length() - 32);
		return s;
	}

	public static String WDtoBin(int tmpdword) {
		String s = "0000000000000000";
		s = s + Integer.toBinaryString(tmpdword);
		s = s.substring(s.length() - 16);
		return s;
	}

	public static byte asc_to_bcd(byte asc) {
		byte bcd;

		if ((asc >= '0') && (asc <= '9'))
			bcd = (byte) (asc - '0');
		else if ((asc >= 'A') && (asc <= 'F'))
			bcd = (byte) (asc - 'A' + 10);
		else if ((asc >= 'a') && (asc <= 'f'))
			bcd = (byte) (asc - 'a' + 10);
		else
			bcd = (byte) (asc - 48);
		return bcd;
	}

	/**
	 * ascii转换
	 * @param ascii
	 * @param asc_len
	 * @return
	 */
	public static byte[] AToB(byte[] ascii, int asc_len) {
		byte[] bcd = new byte[asc_len / 2];
		int j = 0;
		for (int i = 0; i < (asc_len + 1) / 2; i++) {
			bcd[i] = asc_to_bcd(ascii[j++]);
			bcd[i] = (byte) (((j >= asc_len) ? 0x00 : asc_to_bcd(ascii[j++])) + (bcd[i] << 4));
		}
		return bcd;
	}

	/**
	 * BCD计算
	 * @param bytes
	 * @return
	 */
	public static String bcd2Str(byte[] bytes) {
		char temp[] = new char[bytes.length * 2], val;

		for (int i = 0; i < bytes.length; i++) {
			val = (char) (((bytes[i] & 0xf0) >> 4) & 0x0f);
			temp[i * 2] = (char) (val > 9 ? val + 'A' - 10 : val + '0');

			val = (char) (bytes[i] & 0x0f);
			temp[i * 2 + 1] = (char) (val > 9 ? val + 'A' - 10 : val + '0');
		}
		return new String(temp);
	}

	/**
	 * byte转换 String
	 * @param bytes
	 * @return
	 */
	public static String bytesToStr(byte[]bytes){
		return new String(bytes);
	}

	/**
	 * 日期转换
	 * @param adate
	 * @return
	 */
	public static byte[] Str12DateToByte(String adate){
		  byte[] tmpdate=new byte[6];
		  
		  tmpdate[0]=(byte) Integer.parseInt(adate.substring(0, 2));
		  tmpdate[1]=(byte) Integer.parseInt(adate.substring(2, 4));
		  tmpdate[2]=(byte) Integer.parseInt(adate.substring(4, 6));
		  tmpdate[3]=(byte) Integer.parseInt(adate.substring(6, 8));
		  tmpdate[4]=(byte) Integer.parseInt(adate.substring(8, 10));
		  tmpdate[5]=(byte) Integer.parseInt(adate.substring(10, 12));
		  
		  return tmpdate;
		  
		  
	}

	/**
	 *
	 * @param ahexString
	 * @param bytelen
	 * @return
	 */
	public static byte[] HexStrToByteArray(String ahexString, int bytelen) {
		int len=0;
		String hexString=ahexString;
		if(ahexString==null)
		{ len=0;}
		else{
		 	if (ahexString.length() % 2==1){
		 		hexString="0"+ahexString;
		 	}
		 len = hexString.length() / 2;
		}
		byte[] result=null;
		if (len==0){
			result =new byte[bytelen];
			
		}
		else{
		   result = new byte[len];
	
		for (int i = 0; i < len; i++)
		{	result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2),
					16).byteValue();
		}
		if(bytelen>len){
			byte[] tmparray0=new byte[bytelen-len];
			result=byteMerger(tmparray0,result);
		}
		}	
		
		
		return result;
	}


	/**
	 * 计算BCC
	 * @param data
	 * @return
	 */

	public static byte getBCC(byte[] data) {
		byte tmpBCC = 0;
		for (int i = 0; i < data.length; i++) {
			tmpBCC = (byte) (tmpBCC ^ data[i]);
		}

		return tmpBCC;
	}

	public static byte[] getBCCArray(byte[] data) {
		byte[] tmpBCCArray = new byte[1];
		tmpBCCArray[0] = getBCC(data);
		return tmpBCCArray;
	}

	/**
	 * byte数组合并
	 * @param byte_1
	 * @param byte_2
	 * @return
	 */
	public static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
		if (byte_2 == null) {
			return byte_1;
		} else if (byte_1 == null) {
			return byte_2;
		} else {

			byte[] byte_3 = new byte[byte_1.length + byte_2.length];
			System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
			System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
			return byte_3;
		}
	}


	/**
	 *
	 * @param astr
	 * @param abytelen
	 * @return
	 */
	public static byte[] StrToByteArray(String astr, int abytelen){
		int blen=abytelen;
		if(astr.length()>blen){
			try {
				return astr.getBytes("GBK");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return astr.getBytes();
			}
		}else{
		int clen=blen-astr.length();
		 byte[] cbyte=new byte[clen];
		 return byteMerger(astr.getBytes(),cbyte);
		}
		
		
	}

	/**
	 *
	 * @param data
	 * @return
	 */
	public static byte[] getExtEncodeData(byte[] data) {
		int k = 0;
		byte[] tmpRst = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		for (int i = 0; i < data.length; i++) {
			if (data[i] == 0x7e) {
				bos.write(0x7d);
				bos.write(0x02);
				k++;
			} else if (data[i] == 0x7d) {
				bos.write(0x7d);
				bos.write(0x01);
				k++;
			} else {
				bos.write(data[i]);
			}
			k++;
		}

		tmpRst = bos.toByteArray();

		return tmpRst;

	}

	/**
	 *
	 * @param head
	 * @param body
	 * @return
	 */
	public static byte[] getCombineMessage(byte[] head, byte[] body) {
		byte[] tmpheadbody = byteMerger(head, body);
		byte[] tmpBCCArray = getBCCArray(tmpheadbody);
		byte[] tmpExtData = getExtEncodeData(byteMerger(tmpheadbody,
				tmpBCCArray));

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		bos.write(0x7e);
		try {
			bos.write(tmpExtData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bos.write(0x7e);
		byte[] tmpRst = bos.toByteArray();

		return tmpRst;
	}

	/**
	 *
	 * @param data
	 * @return
	 */
	public static byte[] getDecodeData(byte[] data) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		int i = 1;
		int data_len = data.length;
		while (i < data_len - 1) {

			if (data[i] == 0x7d) {
				i++;

				if (i < data_len - 1) {
					if (data[i] == 0x02) {
						bos.write(0x7e);
					} else if (data[i] == 0x01) {
						bos.write(0x7d);
					} else {
						bos.write(data[i]);
					}
				}

			} else {
				bos.write(data[i]);
			}

			i++;

		}

		byte[] byte_1 = bos.toByteArray();
		byte[] byte_2 = new byte[byte_1.length - 1];

		byte tmpBCC = byte_1[byte_1.length - 1];
		System.arraycopy(byte_1, 0, byte_2, 0, byte_2.length);

		if (getBCC(byte_2) == tmpBCC) {
			return byte_2;
		} else {
			return null;
		}
	}

	/**
	 * 解码
	 * @param data2
	 * @return
	 */
	public static DataVO decodeProtocolData(byte[] data2) {
		DataVO tmpRst = new DataVO();
        
		byte[] data=getDecodeData(data2);

		byte[] byte2=new byte[2];

		byte2[0]=data[0];
		byte2[1]=data[1];
		tmpRst.setMsgPrefix(byte2);


		tmpRst.setMsgCode(data[2]);
		tmpRst.setMsgYingDa(data[3]);

		byte2[0] = data[4];
		byte2[1] = data[5];
		tmpRst.setMsgAutoId(toIntR(byte2));
		
		byte[] tmpvin=new byte[17];
		System.arraycopy(data, 6, tmpvin, 0,
				tmpvin.length);
		tmpRst.setMsgVIN(new String(tmpvin));
		tmpRst.setMsgIsRSA(data[23]);
		
		byte2[0] = data[24];
		byte2[1] = data[25];
		tmpRst.setMsgBodyLenth(toIntR(byte2));

		byte[] tmpbody=new byte[tmpRst.getMsgBodyLenth()];
		System.arraycopy(data, 26, tmpbody, 0,
				tmpbody.length);
		return tmpRst;
	}

	/**
	 * 加密
	 * @param aheader
	 * @return
	 */
	public static byte[] EncodeProtocolData(DataVO aheader) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		try {
			bos.write(aheader.getMsgPrefix());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bos.write(BToB(aheader.getMsgCode()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			bos.write(BToB(aheader.getMsgYingDa()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			bos.write(WToB(aheader.getMsgAutoId()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		int tmplen = aheader.getMsgVIN().length();
		byte[] tmpphonearray = new byte[17];
		int tmpless = tmpphonearray.length - tmplen;
		for (int i = 0; i < tmplen; i++) {
			tmpphonearray[i] = (byte) aheader.getMsgVIN().charAt(i);
		}

		try {
			bos.write(tmpphonearray);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		try {
			bos.write(BToB(aheader.getMsgIsRSA()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			bos.write(WToB(aheader.getMsgBodyData().length));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		byte[] tmpRst = getCombineMessage(bos.toByteArray(),
				aheader.getMsgBodyData());

		return tmpRst;

	}

}
