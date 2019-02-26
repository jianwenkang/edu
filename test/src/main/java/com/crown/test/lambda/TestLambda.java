package com.crown.test.lambda;


/**
 * Created by Crown on 2019/1/28.
 */
public class TestLambda {

    public void test1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8 ");
            }
        }).start();

    }
}
