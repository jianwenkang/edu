package com.crown.base.map;

import org.junit.Test;

import java.util.HashMap;

/**
 * @ClassName TestMap
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020/4/23
 * @Time 10:19
 * @Version 1.0
 */
public class TestMap {
    @Test
    public void test(){
        MyKey myKey0 = new MyKey(0);
        MyInteger myInteger0 = new MyInteger(0);
        MyKey myKey10 = new MyKey(10);
        MyInteger myInteger10 = new MyInteger(10);
        HashMap<MyKey, MyInteger> map = new HashMap<MyKey, MyInteger>();
        System.out.println(hash(myKey0));
        System.out.println(hash(myKey10));
        map.put(myKey0,myInteger0);
        map.put(myKey10,myInteger10);
        System.out.println(map);

    }

    private int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}

class MyKey{

    Integer key;

    public MyKey() {
    }

    public MyKey(Integer key) {
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyKey myKey = (MyKey) o;
        return key.equals(myKey.key);
    }

    @Override
    public int hashCode() {
        return key % 10;
    }

    @Override
    public String toString() {
        return "MyKey{" +
                "key=" + key +
                '}';
    }
}

class MyInteger {

    Integer myi;

    public MyInteger() {
    }

    public MyInteger(Integer myi) {
        this.myi = myi;
    }

    @Override
    public int hashCode() {
        return myi % 10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyInteger myInteger = (MyInteger) o;
        return myi.equals(myInteger.myi);
    }

    @Override
    public String toString() {
        return "MyInteger{" +
                "myi=" + myi +
                '}';
    }
}