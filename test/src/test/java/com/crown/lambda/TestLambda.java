package com.crown.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Crown on 2019/1/28.
 */
public class TestLambda {

    @Test
    public void test0(){
        new Thread( () -> System.out.println("In Java8!") ).start();
    }
    @Test
    public void test1(){
        Test1 test1 = (a,b)-> 1+b;
        int i = test1.add0("1", 2);
        System.err.println(i);
    }

    @Test
    public void testThread(){
        new Thread(
                ()-> System.out.println(Thread.currentThread().getName())
        ).start();
        new Runnable(){
            @Override
            public void run() {

            }
        }.run();
    }

    @Test
    public void testList(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        // 直接打印
        list.forEach(System.err::println);

        // 取值分别操作
        list.forEach(i -> {
            System.out.println(i * 3);
        });
    }

    @Test
    public void stream(){
        Test1 t1 = (a,b)->{
            int c = 1;
            System.out.println("===");
            return 1;
        };
        Test1 t2 = (a,b)->b+1;
        Test2 t3 = (a,b,c)-> System.out.println("===");
    }
}
interface Test1{
    int add0(String a,int b);
}
interface Test2{
    void test(String a,int b,int c);
}
