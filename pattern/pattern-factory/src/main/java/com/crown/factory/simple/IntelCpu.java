package com.crown.factory.simple;

/**
 * @ClassName IntelCpu
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-02
 * @Time 16:22
 * @Version 1.0
 */
public class IntelCpu implements Cpu {
    /**
     * * CPU的针脚数
     */
    private int pins = 0;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    @Override
    public void calculate() {
        // TODO Auto-generated method stub
        System.out.println("Intel CPU的针脚数：" + pins);
    }
}
