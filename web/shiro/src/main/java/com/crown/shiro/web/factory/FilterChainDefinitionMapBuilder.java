package com.crown.shiro.web.factory;

import java.util.LinkedHashMap;

/**
 * @ClassName FilterChainDefinitionMapBuilder
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/6
 * @Time 11:03
 * @Version 1.0
 */
public class FilterChainDefinitionMapBuilder {

    public LinkedHashMap<String,String> buildfilterChainDefinitionMap(){
                        //资源表达式（Ant 风格模式）  权限
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/login.jsp","anon");
        filterChainDefinitionMap.put("/shiro/login","anon");
        filterChainDefinitionMap.put("/shiro/logout","logout");
        filterChainDefinitionMap.put("/user.jsp","authc,roles[user]");
        filterChainDefinitionMap.put("/admin.jsp","authc,roles[admin]");
        filterChainDefinitionMap.put("/list.jsp","roles[user]");
        filterChainDefinitionMap.put("/**","authc");
        return filterChainDefinitionMap;
    }

}
