package com.crown.io.broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ClassName BroadcastClient
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-13
 * @Time 17:17
 * @Version 1.0
 */
public class BroadcastClient {
    public static void main(String[] args)
    {
        //广播的实现 :由客户端发出广播，服务器端接收
        String host = "255.255.255.255";//广播地址
        int port = 9999;//广播的目的端口
        String message = "test";//用于发送的字符串
        try
        {
            InetAddress adds = InetAddress.getByName(host);
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(message.getBytes(),message.length(), adds, port);
            ds.send(dp);
            ds.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
