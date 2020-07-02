package com.crown.init;

/**
 * Created by Crown on 2018/12/19.
 */
public class InitClass implements InitInterface{
    public InitClass() {
    }

    @Override
    public String getName(String string) {
        System.out.println("=======");
        return "Hello " + string;
    }
}
