package com.crown.io.broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @ClassName BroadcastServer
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-13
 * @Time 17:17
 * @Version 1.0
 */
public class BroadcastServer {
    public static void main(String[] args)
    {
        int port = 9999;//开启监听的端口
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        byte[] buf = new byte[1024];//存储发来的消息
        StringBuffer sbuf = new StringBuffer();
        try
        {
            //绑定端口的
            ds = new DatagramSocket(port);
            dp = new DatagramPacket(buf, buf.length);
            System.out.println("监听广播端口打开：");
            ds.receive(dp);
            ds.close();
            int i;
            for(i=0;i<1024;i++)
            {
                if(buf[i] == 0)
                {
                    break;
                }
                sbuf.append((char) buf[i]);
            }
            System.out.println("收到"+ dp.getAddress() +"广播消息：" + sbuf.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
