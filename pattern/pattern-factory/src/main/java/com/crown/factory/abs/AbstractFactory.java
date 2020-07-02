package com.crown.factory.abs;

import com.crown.factory.simple.Cpu;
import com.crown.factory.simple.Mainboard;

/**
 * @ClassName AbstractFactory
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-02
 * @Time 16:28
 * @Version 1.0
 */
public interface AbstractFactory {
    /**
     * 创建CPU对象
     *
     * @return CPU对象
     */
    public Cpu createCpu();

    /**
     * 创建主板对象
     *
     * @return 主板对象
     */
    public Mainboard createMainboard();
}

