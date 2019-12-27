package com.crown.distributed.rmi.test;

import java.rmi.Naming;

/**
 * Created by Crown on 2019/1/29.
 */
public class HelloClient {
    public static void main(String[] args) {
        try {
            ISayHello iSayHello = (ISayHello) Naming.lookup("rmi://localhost:8888/sayHello");

            System.out.println(iSayHello.sayHello("Crown"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
