package com.crown.test.bio;

import java.io.PrintStream;
import java.lang.reflect.Field;

/**
 * @ClassName TT
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/8/13
 * @Time 17:15
 * @Version 1.0
 */
public class OverridePrint {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = 10;
        method1(a,b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }

    static void method(int a, int b){
        /*System.out.println("a = 100");
        System.out.println("b = 200");
        System.exit(0);*/
        System.setOut(new PrintStream(System.out){
            @Override
            public void print(String s) {
                switch (s){
                    case "a=10":
                        super.print("a=100");
                        break;
                    case "b=10":
                        super.print("b=200");
                        break;
                }
            }
        });
    }

    private static void method1(Integer a, Integer b) {
        changeValue(a, 100);
        changeValue(b, 200);
    }

    private static void changeValue(Integer i, int value) {
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            field.set(i, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
