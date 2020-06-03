package com.crown.test.demo;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * @ClassName TestDomeTest
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/11
 * @Time 9:21
 * @Version 1.0
 */
public class TestDomeTest {

    @Test
    public void add() {
        LocalDateTime localDateTime = LocalDateTime.of(2020, Month.JULY, 1, 1, 1);
        System.out.println(localDateTime);
    }
}