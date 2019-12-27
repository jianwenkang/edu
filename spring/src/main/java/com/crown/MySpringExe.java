package com.crown;

import org.springframework.beans.factory.InitializingBean;

/**
 * @ClassName MySpringExe
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/4/29
 * @Time 11:01
 * @Version 1.0
 */
public class MySpringExe implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("自己的扩展点");
    }
}
