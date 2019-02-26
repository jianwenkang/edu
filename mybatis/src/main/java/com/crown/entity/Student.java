package com.crown.entity;

/**
 * Created by Crown on 2018/12/21.
 */
public class Student implements Cloneable{
    private Integer id = 1;

    private Integer age;

    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
