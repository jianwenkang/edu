package com.crown.myrmi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName UserSkeleton
 * @Description TODO serversocket
 * @Author Jianwen Kang
 * @Date 2020-08-14
 * @Time 17:38
 * @Version 1.0
 */
public class UserSkeleton extends Thread{

    private UserServer userServer;

    public UserSkeleton(UserServer userServer) {
        this.userServer = userServer;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);

            Socket socket = serverSocket.accept();

            while (socket != null){
                ObjectInputStream read = new ObjectInputStream(socket.getInputStream());

                String method = (String) read.readObject();

                if(method.equals("age")){
                    int age = userServer.getAge();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeInt(age);
                    objectOutputStream.flush();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
