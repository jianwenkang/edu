package com.crown.base;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Operator
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-02
 * @Time 14:34
 * @Version 1.0
 */
public class Operator {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();
        List<? extends B> listUpper;
        listUpper=new ArrayList<B>();
        listUpper=new ArrayList<C>();

        List<? super B> listLower;
        listLower=new ArrayList<B>();
        listLower=new ArrayList<A>();

    }

}

class A{

}

class B extends A{

}

class C extends B{

}
