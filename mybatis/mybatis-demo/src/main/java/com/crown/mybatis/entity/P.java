package com.crown.mybatis.entity;

import java.util.List;

/**
 * @ClassName P
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/9/18
 * @Time 17:49
 * @Version 1.0
 */
public class P {
    Integer id;

    String name;

    List<S> ss;

    @Override
    public String toString() {
        return "P{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ss=" + ss +
                '}';
    }
}
