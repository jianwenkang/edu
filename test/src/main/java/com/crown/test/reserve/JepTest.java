package com.crown.test.reserve;

import jep.Jep;
import jep.JepException;
import org.junit.Test;

/**
 * @ClassName Jep
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/8/15
 * @Time 11:16
 * @Version 1.0
 */
public class JepTest {
    @Test
    public void test1() throws JepException {
        Jep jep = new Jep();
        Object value = jep.getValue("1+1");
        System.out.println(value);

    }
}
