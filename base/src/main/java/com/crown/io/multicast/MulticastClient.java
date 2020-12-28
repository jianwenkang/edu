package com.crown.io.multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @ClassName MulticastClient
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-13
 * @Time 17:36
 * @Version 1.0
 */
public class MulticastClient {
    public static void main(String[] args) throws Exception {
        //保证和服务端为同一个组
        InetAddress group = InetAddress.getByName("224.1.2.3");

        MulticastSocket multicastSocket = new MulticastSocket(8899);

        multicastSocket.joinGroup(group);

        byte[] buf = new byte[256];

        while (true){
            DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);

            multicastSocket.receive(datagramPacket);

            String msg = new String(datagramPacket.getData());

            System.out.println("接收到的数据：" + msg);
        }

    }
}
