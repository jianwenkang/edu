package com.crown.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @ClassName HelloServer
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-08-14
 * @Time 16:09
 * @Version 1.0
 */
public class HelloServer {

    public static void main(String[] args) {
        try {
            SayHello sayHello = new SayHelloImpl();
            LocateRegistry.createRegistry(8888);
            Naming.bind("rmi://localhost:8888/sayhello", sayHello);
            System.out.println("Server start Success");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
