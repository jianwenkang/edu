package com.crown.myrmi;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @ClassName UserStub
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-08-14
 * @Time 17:43
 * @Version 1.0
 */
public class UserStub extends User{

    private Socket socket;

    public UserStub() throws IOException {
        this.socket = new Socket("127.0.0.1",8888);
    }

    public int getAge() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject("age");
        objectOutputStream.flush();

        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        int age = objectInputStream.readInt();
        return age;
    }
}
