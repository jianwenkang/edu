package com.crown.factory.abs;

import com.crown.factory.simple.Cpu;
import com.crown.factory.simple.IntelCpu;
import com.crown.factory.simple.IntelMainboard;
import com.crown.factory.simple.Mainboard;

/**
 * @ClassName IntelFactory
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-02
 * @Time 16:28
 * @Version 1.0
 */
public class IntelFactory implements AbstractFactory {

    @Override
    public Cpu createCpu() {
        // TODO Auto-generated method stub
        return new IntelCpu(755);
    }

    @Override
    public Mainboard createMainboard() {
        // TODO Auto-generated method stub
        return new IntelMainboard(755);
    }

}
