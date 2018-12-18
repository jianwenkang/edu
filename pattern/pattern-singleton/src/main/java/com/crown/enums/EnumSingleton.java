package com.crown.enums;

/**
 * Created by Crown on 2018/12/18.
 */
public class EnumSingleton {
    private EnumSingleton(){}

    public static  EnumSingleton getInstance(){
        return Singleton.INSTANCE.getEnumSingleton();
    }
    private static enum Singleton{
        INSTANCE;
        private EnumSingleton enumSingleton;
        //JVM保证此方法只调用一次
        private Singleton(){
            enumSingleton = new EnumSingleton();
        }
        public EnumSingleton getEnumSingleton(){
            return enumSingleton;
        }
    }
}
