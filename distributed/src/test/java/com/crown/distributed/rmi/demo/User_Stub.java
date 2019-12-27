package com.crown.distributed.rmi.demo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Crown on 2019/1/30.
 */
public class User_Stub extends User{
    private Socket socket;

    public User_Stub() throws IOException {
        socket = new Socket("127.0.0.1", 8888);
    }

    public int getAge() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject("age");
        objectOutputStream.flush();
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        int i = objectInputStream.readInt();
        return Integer.valueOf(i);
    }
}
