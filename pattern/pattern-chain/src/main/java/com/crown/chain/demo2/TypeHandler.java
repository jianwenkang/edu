package com.crown.chain.demo2;

import com.crown.chain.demo2.entity.DeviceType;

import java.util.Objects;

/**
 * @ClassName TypeHandle
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/5/10
 * @Time 17:27
 * @Version 1.0
 */
public class TypeHandler extends Handler {

    public DeviceType deviceType;

    @Override
    public void handleRequest() {
        System.out.println("Type Handler");
        if(nextHandler != null){
            nextHandler.handleRequest();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TypeHandler that = (TypeHandler) o;
        return deviceType.equals(that.deviceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deviceType);
    }
}
