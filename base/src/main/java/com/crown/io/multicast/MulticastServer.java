package com.crown.io.multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MulticastServer
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-13
 * @Time 17:36
 * @Version 1.0
 */
public class MulticastServer {

    public static void main(String[] args) throws Exception {
        //地址段 224.0.0.0 -----  239.255.255.255
        InetAddress group = InetAddress.getByName("224.1.2.3");

        MulticastSocket multicastSocket = new MulticastSocket();

        for (int i=0;i<10;i++){
            String data = "Hello Corwn";

            byte[] bytes = data.getBytes();

            multicastSocket.send(new DatagramPacket(bytes,bytes.length,group,8899));

            TimeUnit.SECONDS.sleep(2);
        }
    }
}

