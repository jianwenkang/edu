package com.crown.easypoi;

import org.junit.Test;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-10-29
 * @Time 17:38
 * @Version 1.0
 */
public class TestBase {

    @Test
    public void test(){
        String strImge = "data:image/png;base64,iVBORw0KGgoA";
        String[] split = strImge.split(",");
        System.out.println(split[1]);
        System.out.println("======");
        String[] split2 = split[0].split(";")[0].split("/");
        System.out.println(split2[1]);
    }
}
