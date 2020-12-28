package com.crown.bridge;

/**
 * @ClassName Abstraction
 * @Description TODO 抽象化(Abstraction)角色
 * @Author Jianwen Kang
 * @Date 2020-07-21
 * @Time 14:13
 * @Version 1.0
 */
public abstract class Abstraction {
    protected Implementor impl;

    public Abstraction(Implementor impl){
        this.impl = impl;
    }
    //示例方法
    public void operation(){

        impl.operationImpl();
    }
}
