package com.yzw.timer.util;

/**
 * Created by BoYang
 * 日期:2016/5/7
 * 时间:6:52.
 * .
 */

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * socket 通信工具
 * Created by boyang on 2016/05/07.
 */
public class SocketUtil {

    private String ip = null;

    private int port = 0;

    private Socket socket = null;

    DataOutputStream outputStream = null;

    DataInputStream inputStream = null;

    public SocketUtil(String ip, int port)
    {

        this.ip = ip;
        this.port = port;
    }

    public void createConnection() throws Exception
    {

        try
        {

            socket = new Socket(ip, port);
            socket.setKeepAlive(false);
            LogUtil.info("与服务器["+ip+":"+port+"]建立连接。。。。。。");
            // socket.setReuseAddress(true);

        }
        catch (Exception e)
        {

            LogUtil.info("与服务器[" + ip + ":" + port + "]建立连接异常"+e.getMessage());

            if (socket != null)
            {
                socket.close();
            }
            throw e;

        }
        finally
        {
        }
    }

    public byte[] toByte(String msg){

        byte[] ret = {};
        return ret;

    }

    public synchronized void sendMessage(String sendMessage , String Charset) throws Exception
    {

        try
        {

            if (outputStream == null)
            {

                outputStream = new DataOutputStream(socket.getOutputStream());
            }

           // byte b[] = sendMessage.getBytes(Charset);
            byte b[] ={(byte)0x7E,(byte)0x23,(byte)0x23,(byte)0x07,(byte)0xFE,(byte)0x00,(byte)0x01,(byte)0x77,(byte)0x61,(byte)0x6E,(byte)0x78,(byte)0x69,(byte)0x61,(byte)0x6E,(byte)0x67,(byte)0x62,(byte)0x6F,(byte)0x78,(byte)0x69,(byte)0x65,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x3D,(byte)0x62,(byte)0x6F,(byte)0x78,(byte)0x69,(byte)0x65,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x62,(byte)0x6F,(byte)0x78,(byte)0x69,(byte)0x65,(byte)0x31,(byte)0x32,(byte)0x33,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x01,(byte)0x8C,(byte)0x7E};

            outputStream.write(b);
            outputStream.flush();

        }
        catch (Exception e)
        {

            e.printStackTrace();

            if (outputStream != null)
            {
                outputStream.close();
            }

            throw e;

        }
        finally
        {
        }
    }

    public synchronized String getMessage() throws Exception
    {

        return getMessage(-1);
    }

    public synchronized String getMessage(int readSize) throws Exception
    {

        try
        {

            if (inputStream == null)
            {
                inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            }

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            if (inputStream != null)
            {

                if (readSize != -1 && readSize > 0)
                {

                    for (int i = 0; i < readSize; i++)
                    {

                        int read = inputStream.read();

                        if (read == -1)
                        {
                            break;
                        }
                        else
                        {
                            byteArrayOutputStream.write(read);
                        }
                    }
                }
                else
                {
                    while (true)
                    {

                        int read = inputStream.read();

                        if (read <= 0)
                        {
                            break;
                        }
                        else
                        {
                            byteArrayOutputStream.write(read);
                        }
                    }
                }
                byte ret[] = byteArrayOutputStream.toByteArray();

                return new String(byteArrayOutputStream.toByteArray(), "GBK");

            }
        }
        catch (Exception e)
        {

            e.printStackTrace();

            if (inputStream != null)
            {
                inputStream.close();
            }

            throw e;

        }
        finally
        {

        }

        return null;
    }

    public void shutDownConnection()
    {

        try
        {

            if (outputStream != null)
            {
                outputStream.close();
            }

            if (inputStream != null)
            {
                inputStream.close();
            }

            if (socket != null)
            {
                socket.shutdownInput();
                socket.shutdownOutput();
                socket.close();
            }

        }
        catch (Exception e)
        {

        }
    }

    public static String send(String ip, int port, String msg ,String charSet) throws Exception {
        SocketUtil socketUtil = null;
        String recMsg = null;
        try {
            socketUtil = new SocketUtil(ip, port);
            socketUtil.createConnection();
            socketUtil.sendMessage(msg,charSet);
            recMsg = socketUtil.getMessage();
        } finally {  //增加try...finally，保证在异常情况下socket也正常关闭。
            if(socketUtil!=null){
                socketUtil.shutDownConnection();
            }
        }
        return recMsg;
    }

    public static void main(String[] args) throws Exception{
        String msg = "7E232307FE000177616E7869616E67626F7869650000000000003D626F7869650000000000000000000000000000000000000000000000000000000000000000000000626F786965313233000000000000000000000000018C7E";
        String revMsg = SocketUtil.send("61.129.57.83",16004,msg,"GBK");
        StringBuffer bf = new StringBuffer();
        for(int i=0;i<msg.length();i=i+2){
            bf.append("0x").append(msg.substring(i,i+2)).append(",");

        }
        String a = "12";
        byte bc[] = a.getBytes();
      //  byte as[] = {0x7E,0x23,0x23,0x07,0xfe,0x00,0x01,0x77,0x61,0x6E,0x78,0x69,0x61,0x6E,0x67,0x62,0x6F,0x78,0x69,0x65,0x00,0x00,0x00,0x00,0x00,0x00,0x3D,0x62,0x6F,0x78,0x69,0x65,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x62,0x6F,0x78,0x69,0x65,0x31,0x32,0x33,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x01,0x8C,0x7E};
        System.out.println(bf);
    }
}