package com.crown.cglibproxy;

import com.crown.init.Hello;
import com.crown.init.InitClass;
import com.crown.init.InitInterface;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @ClassName CglibClient
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-08
 * @Time 16:25
 * @Version 1.0
 */
public class CglibClient {
    public static void main(String[] args) {
        // 生成class类的路径
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "F:\\crownProjects\\edu\\pattern\\pattern-proxy\\src\\main\\java\\com\\crown\\cglibproxy\\source");
        CglibProxyClass cglibProxyClass = new CglibProxyClass();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(InitClass.class);
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(cglibProxyClass);
        InitInterface o = (InitInterface) enhancer.create();
        System.out.println(o.getClass());//com.crown.init.InitClass$$EnhancerByCGLIB$$1d5cc194
        o.getName("tom");
    }
}
