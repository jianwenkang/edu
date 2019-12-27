package com.crown.distributed.rmi.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Crown on 2019/1/29.
 */
public interface ISayHello extends Remote{
    String sayHello(String name) throws RemoteException;
}
