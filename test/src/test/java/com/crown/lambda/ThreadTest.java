package com.crown.lambda;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/3/4
 * @Time 16:29
 * @Version 1.0
 */
public class ThreadTest {
    public static void main(String[] args) {
        new Thread(new MyThread()).start();
        new Thread(new MyThread()).start();
        new Thread(new MyThread()).start();
    }
}

class MyThread implements Runnable{
    int i,j,k;
    @Override
    public void run() {

    }
}
