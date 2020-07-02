package com.crown.extend;

/**
 * @ClassName A
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-09
 * @Time 11:32
 * @Version 1.0
 */
class A {
    static {
        System.out.println("Static init A.");
    }

    {
        System.out.println("Instance init A.");
    }

    public A() {
        System.out.println("Constructor A.");
    }
}

class B extends A {
    static {
        System.out.println("Static init B.");
    }

    {
        System.out.println("Instance init B.");
    }

    public B() {
        System.out.println("Constructor B.");
    }
}

class C extends B {
    static {
        System.out.println("Static init C.");
    }

    {
        System.out.println("Instance init C.");
    }

    public C() {
        System.out.println("Constructor C.");
    }
}

public class Main {
    static {
        System.out.println("Static init Main.");
    }

    {
        System.out.println("Instance init Main.");
    }

    public Main() {
        System.out.println("Constructor Main.");
    }

    public static void main(String[] args) {
        new C();
        System.out.println("========");
        new C();
    }
}
