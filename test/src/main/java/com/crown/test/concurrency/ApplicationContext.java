package com.crown.test.concurrency;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ApplicationContext
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/22
 * @Time 15:59
 * @Version 1.0
 */
public class ApplicationContext {

    private Map<String, Boolean> falgMap = new HashMap<String, Boolean>();

    public ApplicationContext() {
        falgMap.put("a",true);
        falgMap.put("b",true);
        falgMap.put("c",true);
    }

    public Map<String, Boolean> getFalgMap() {
        return falgMap;
    }

    public void setFalgMap(Map<String, Boolean> falgMap) {
        this.falgMap = falgMap;
    }

    public Boolean getFalg(String flag) {
        return falgMap.get(flag);
    }

    public void setFalg(String flag,Boolean sts) {
        this.falgMap.put(flag, sts);
    }
}
