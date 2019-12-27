package com.crown.test.reserve;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @ClassName Script
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/8/15
 * @Time 10:04
 * @Version 1.0
 */
public class Script {
    public static void test1() throws ScriptException {
        String str = "(a >= 0 && b <= 5)";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        engine.put("a", 6);
        engine.put("b", 1);
        Object result = engine.eval(str);
        System.out.println("结果类型:" + result.getClass().getName() + ",计算结果:" + result);
    }
    public static void test2() throws ScriptException {
        String str = "43*(2 + 1.4)+2*32/(3-2.1)";
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = engine.eval(str);
        System.out.println("结果类型:" + result.getClass().getName() + ",计算结果:" + result);
    }


    public static void main(String[] args) {
        try {
            test1();
            test2();
        } catch (ScriptException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}