package com.crown.myproxy;

/**
 * @ClassName MyClient
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-08
 * @Time 17:10
 * @Version 1.0
 */
public class MyClient {
    public static void main(String[] args) {
        new MyClient().m1();
    }

    public void m1(){
        getMethod();
        m2();
    }
    public void m2(){
        getMethod();
        m3();
    }
    public void m3(){
        getMethod();
        System.out.println("end");
    }

    private void getMethod(){
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        System.out.println(stackTrace[1].getMethodName());
    }
}
