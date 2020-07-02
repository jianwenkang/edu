package com.crown.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibProxyClass
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-08
 * @Time 16:22
 * @Version 1.0
 */
public class CglibProxyClass implements MethodInterceptor {
    //目标对象
    private Object target;
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CGLIB前置通知");
        Object o1 = methodProxy.invokeSuper(o, objects);
        //method.invoke(target,objects);
        System.out.println("CGLIB后置通知");
        return o1;
    }
}
