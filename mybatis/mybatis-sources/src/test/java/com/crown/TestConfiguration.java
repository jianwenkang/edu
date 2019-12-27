package com.crown;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Crown on 2018/12/24.
 */
public class TestConfiguration {
    public static void main(String[] args) throws Exception {
        new SqlSessionFactoryBuilder().build(new FileInputStream("")).openSession();
    }
}
