package com.crown.myproxy;

import java.lang.reflect.Method;

/**
 * @ClassName MyInvocationHandler
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-08
 * @Time 17:27
 * @Version 1.0
 */
public abstract class MyInvocationHandler {
    abstract Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;


}
