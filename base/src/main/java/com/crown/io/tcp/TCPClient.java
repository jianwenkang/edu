package com.crown.io.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @ClassName TCPClient
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-13
 * @Time 17:11
 * @Version 1.0
 */
public class TCPClient {
    public static void main(String[] args) throws Exception {
        String sentence;
        String modifiedSentence;
        System.out.println("请输入一个英文字符串，服务器将返回其大写形式（输入exit退出）");
        while (true) {
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            //创建客户端 Socket 并指明需要连接的服务器端的主机名及端口号
            Socket clientSocket = new Socket("localhost", 6789);
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            sentence = inFromUser.readLine();
            if (sentence.equals("exit")) break;
            //向服务器发送数据
            outToServer.writeBytes(sentence + '\n');
            //接收服务器返回数据
            modifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER: " + modifiedSentence);
            clientSocket.close();
        }
    }
}
