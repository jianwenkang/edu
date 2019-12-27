package com.crown.distributed.rmi.demo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Crown on 2019/1/30.
 * ServerSocket
 */
public class User_Skeeleton extends Thread{

    private UserServer userServer;

    public User_Skeeleton(UserServer userServer) {
        this.userServer = userServer;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            while (socket!=null){
                ObjectInputStream read = new ObjectInputStream(socket.getInputStream());
                String method = (String)read.readObject();
                if(method.equals("age")){
                    Integer age = userServer.getAge();
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOutputStream.writeInt(age);
                    objectOutputStream.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
