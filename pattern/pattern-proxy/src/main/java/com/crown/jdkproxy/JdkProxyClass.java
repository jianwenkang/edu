package com.crown.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Crown on 2018/12/19.
 */
public class JdkProxyClass implements InvocationHandler{
    //目标对象
    private Object target;
    public JdkProxyClass(Object target){
        this.target = target;
    }
    @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK前置通知:"+method.getName());
        Object invoke = method.invoke(target, args);
        System.out.println("JDK后置通知");
        return invoke;

    }
}
