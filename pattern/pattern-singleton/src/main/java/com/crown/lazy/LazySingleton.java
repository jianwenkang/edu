package com.crown.lazy;

/**
 * Created by Crown on 2018/12/18.
 */
public class LazySingleton {
    private LazySingleton() {
    }
    private static LazySingleton lazySingleton = null;

    public static synchronized LazySingleton getLazySingleton(){
        if(lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
