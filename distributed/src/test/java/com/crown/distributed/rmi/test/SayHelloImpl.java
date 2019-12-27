package com.crown.distributed.rmi.test;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Crown on 2019/1/29.
 */
public class SayHelloImpl extends UnicastRemoteObject implements ISayHello{
    public SayHelloImpl() throws RemoteException {
    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello:"+name;
    }
}
