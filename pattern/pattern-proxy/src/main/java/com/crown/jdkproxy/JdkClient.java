package com.crown.jdkproxy;

import com.crown.init.InitClass;
import com.crown.init.InitInterface;

import java.lang.reflect.Proxy;

/**
 * Created by Crown on 2018/12/19.
 */
public class JdkClient {
    public static void main(String[] args) {
        InitInterface initInterface = (InitInterface) new JdkClient().install();
        String tom = initInterface.getName("Tom");
        System.out.println(initInterface.getClass());
        System.out.println(tom);


    }

    private Object install(){
        Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{InitInterface.class}, new ProxyClass(new InitClass()));
        return o;
    }

}
