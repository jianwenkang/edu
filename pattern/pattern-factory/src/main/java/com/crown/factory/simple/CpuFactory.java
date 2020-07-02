package com.crown.factory.simple;

/**
 * @ClassName CpuFactory
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-02
 * @Time 16:25
 * @Version 1.0
 */
public class CpuFactory {
    public static Cpu createCpu(int type) {
        Cpu cpu = null;
        if (type == 1) {
            cpu = new IntelCpu(755);
        } else if (type == 2) {
            cpu = new AmdCpu(938);
        }
        return cpu;
    }
}
