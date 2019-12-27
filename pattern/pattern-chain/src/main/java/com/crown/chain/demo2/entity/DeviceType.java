package com.crown.chain.demo2.entity;

import java.util.Objects;

/**
 * @ClassName DeviceType
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/15
 * @Time 18:27
 * @Version 1.0
 */
public class DeviceType {
    private Integer id;

    private String name;

    public DeviceType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceType that = (DeviceType) o;
        return id.equals(that.id) &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
