package com.crown.lazy;

/**
 * Created by Crown on 2018/12/18.
 */
public class HolderClassSingleton {
    private static boolean initialized = false;

    private HolderClassSingleton() {
        synchronized (HolderClassSingleton.class){
            if(initialized == false){
                initialized = !initialized;
            }else {
                throw new RuntimeException("实例已创建");
            }
        }
    }
    /*
     * static 保证单例空间共享
     * final 保证方法不被重写
     */
    public static final HolderClassSingleton getInstance(){
        return LazyHolder.holderClassSingleton;
    }

    private static class LazyHolder{
        private static final HolderClassSingleton holderClassSingleton = new HolderClassSingleton();
    }

}
