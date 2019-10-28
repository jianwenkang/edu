package com.crown;

import java.beans.PropertyChangeListener;

import static jdk.nashorn.internal.objects.Global.println;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        

        System.out.println("Hello World!");

        PropertyChangeListener listener = e ->{
            println(e);
        };
    }
}
