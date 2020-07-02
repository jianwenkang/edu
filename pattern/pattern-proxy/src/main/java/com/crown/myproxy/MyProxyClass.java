package com.crown.myproxy;

import java.lang.reflect.Method;

/**
 * @ClassName MyProxyClass
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-08
 * @Time 17:22
 * @Version 1.0
 */
public class MyProxyClass {
    //目标对象
    private Object target;

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke = method.invoke(target, args);
        return invoke;
    }

    private Method getMethod(Class<?>... parameterTypes) throws NoSuchMethodException {
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        String methodName = stackTrace[1].getMethodName();
        Method method = target.getClass().getMethod(methodName, parameterTypes);
        return method;
    }
}
