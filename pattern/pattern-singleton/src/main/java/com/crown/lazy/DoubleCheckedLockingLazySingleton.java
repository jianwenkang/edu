package com.crown.lazy;

/**
 * Created by Crown on 2018/12/18.
 */
public class DoubleCheckedLockingLazySingleton {
    private DoubleCheckedLockingLazySingleton() {
    }

    private static DoubleCheckedLockingLazySingleton doubleCheckedLockingLazySingleton;

    public DoubleCheckedLockingLazySingleton getInstance(){
        if(doubleCheckedLockingLazySingleton == null){
            synchronized (DoubleCheckedLockingLazySingleton.class){
                if (doubleCheckedLockingLazySingleton == null){
                    doubleCheckedLockingLazySingleton = new DoubleCheckedLockingLazySingleton();
                }
            }
        }
        return doubleCheckedLockingLazySingleton;
    }
}
