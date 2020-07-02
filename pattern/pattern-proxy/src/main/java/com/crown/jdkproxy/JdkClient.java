package com.crown.jdkproxy;

import com.crown.init.Hello;
import com.crown.init.InitClass;
import com.crown.init.InitInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Crown on 2018/12/19.
 */
public class JdkClient {
    public static void main(String[] args) {
        //System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        InitInterface initInterface = (InitInterface) new JdkClient().install(JdkClient.class.getClassLoader(),
                new Class[]{InitInterface.class, Hello.class},
                new JdkProxyClass(new InitClass()));
        initInterface.getName("tom");


    }

    private Object install(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h){
        Object o = Proxy.newProxyInstance(loader, interfaces, h);
        return o;
    }

}
