package com.crown.factory.simple;

/**
 * @ClassName IntelMainboard
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-02
 * @Time 16:24
 * @Version 1.0
 */
public class IntelMainboard implements Mainboard {
    /**
     * CPU插槽的孔数
     */
    private int cpuHoles = 0;

    /**
     * 构造方法，传入CPU插槽的孔数
     *
     * @param cpuHoles
     */
    public IntelMainboard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    @Override
    public void installCPU() {
        // TODO Auto-generated method stub
        System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);
    }

}
