package com.crown.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @ClassName HelloClient
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-08-14
 * @Time 16:13
 * @Version 1.0
 */
public class HelloClient {

    public static void main(String[] args) {
        try {
            SayHello sayHello = (SayHello) Naming.lookup("rmi://localhost:8888/sayhello");
            System.out.println(sayHello.sayHello("Hello, Gcca"));

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}
