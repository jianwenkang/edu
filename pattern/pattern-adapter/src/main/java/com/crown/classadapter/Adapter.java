package com.crown.classadapter;

/**
 * @ClassName Adapter
 * @Description TODO  适配器(Adaper)角色
 * @Author Jianwen Kang
 * @Date 2020-07-21
 * @Time 13:31
 * @Version 1.0
 */
public class Adapter extends Adaptee implements Target {
    /**
     * 由于源类Adaptee没有方法sampleOperation2()
     * 因此适配器补充上这个方法
     */
    @Override
    public void sampleOperation2() {
        //写相关的代码
    }
}
