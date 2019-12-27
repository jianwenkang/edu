package com.crown.test.bio;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Crown on 2019/2/22.
 */
public class ClientA {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        DataOutputStream dataOutputStream = null;
        int i =1;
        while(i!=0){
            System.err.println("------");
            i = scanner.nextInt();
            dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeInt(i);
            dataOutputStream.flush();
        }
        dataOutputStream.writeInt(i);
        dataOutputStream.flush();
        System.out.println("关闭客户端A");
    }
}
