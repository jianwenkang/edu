package com.crown.factory.abs;

/**
 * @ClassName Client
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-02
 * @Time 16:29
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        //创建装机工程师对象
        ComputerEngineer cf = new ComputerEngineer();
        //客户选择并创建需要使用的产品对象
        AbstractFactory inter = new IntelFactory();
        //告诉装机工程师自己选择的产品，让装机工程师组装电脑
        cf.makeComputer(inter);

        System.out.println("------------------------");
        AbstractFactory amd = new AmdFactory();
        cf.makeComputer(amd);

    }
}
