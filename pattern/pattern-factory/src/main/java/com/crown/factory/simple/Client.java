package com.crown.factory.simple;

/**
 * @ClassName Client
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-07-02
 * @Time 16:26
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        ComputerEngineer cf = new ComputerEngineer();
        cf.makeComputer(1, 1);
        System.out.println("--------");
        cf.makeComputer(1, 2);
    }
}
