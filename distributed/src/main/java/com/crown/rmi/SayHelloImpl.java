package com.crown.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @ClassName SayHelloImpl
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-08-14
 * @Time 16:07
 * @Version 1.0
 */
public class SayHelloImpl extends UnicastRemoteObject implements SayHello{

    public SayHelloImpl() throws RemoteException {
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello :" + name;
    }

}
