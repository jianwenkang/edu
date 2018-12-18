package com.crown.eager;

/**
 * Created by Crown on 2018/12/18.
 *  在加载是创建实例 没有加锁运行效率高（绝对线程安全）
 *  占用内存空间
 */
public class EagerSingleton {
    private EagerSingleton() {
    }

    private static EagerSingleton eagerSingleton = new EagerSingleton();

    public static EagerSingleton getInstance(){
        return eagerSingleton;
    }
}
