package com.crown.test.concurrency;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName demo1
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/22
 * @Time 15:57
 * @Version 1.0
 */
public class demo1 {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/em_new1","root", "root");


    }
}

class MyThread extends Thread{
    ApplicationContext applicationContext;
    @Override
    public void run() {
        super.run();
    }
}