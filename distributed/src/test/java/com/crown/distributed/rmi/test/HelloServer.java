package com.crown.distributed.rmi.test;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Crown on 2019/1/29.
 */
public class HelloServer {
    public static void main(String[] args) {
        try {
            ISayHello sayHello = new SayHelloImpl();

            LocateRegistry.createRegistry(8888);

            Naming.bind("rmi://localhost:8888/sayHello",sayHello);

            System.out.println("Server start success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
