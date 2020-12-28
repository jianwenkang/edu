package com.crown.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @ClassName SayHello
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-08-14
 * @Time 16:05
 * @Version 1.0
 */
public interface SayHello extends Remote {

    String sayHello(String name) throws RemoteException;

}
