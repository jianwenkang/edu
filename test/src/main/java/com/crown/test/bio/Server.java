package com.crown.test.bio;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Crown on 2019/2/22.
 */
public class Server {
    public static void main(String[] args) throws Exception {
        //new Server().serverA();
        new Server().serverB();
    }
    public void serverB()throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            Socket socket = serverSocket.accept();
            new Thread(()->{
                InputStream inputStream = null;
                try {
                    inputStream = socket.getInputStream();
                    DataInputStream dataInputStream = new DataInputStream(inputStream);
                    int i = dataInputStream.readInt();
                    while(i!=0){
                        System.err.println(Thread.currentThread().getName()+":"+i);
                        i = dataInputStream.readInt();
                    }
                    dataInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }).start();

        }
    }
    public void serverA()throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            int i = dataInputStream.readInt();
            while(i!=0){
                System.err.println(i);
                i = dataInputStream.readInt();
            }
            dataInputStream.close();
        }
    }
}
