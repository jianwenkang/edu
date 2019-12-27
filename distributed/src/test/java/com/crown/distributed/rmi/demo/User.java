package com.crown.distributed.rmi.demo;

import java.io.IOException;

/**
 * Created by Crown on 2019/1/30.
 */
public class User {

    private Integer age;

  public int getAge() throws IOException {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
