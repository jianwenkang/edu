package com.crown.objectadapter;

/**
 * @ClassName Target
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-21
 * @Time 13:38
 * @Version 1.0
 */
public interface Target {
    /**
     * 这是源类Adaptee也有的方法
     */
    void sampleOperation1();
    /**
     * 这是源类Adapteee没有的方法
     */
    void sampleOperation2();
}
