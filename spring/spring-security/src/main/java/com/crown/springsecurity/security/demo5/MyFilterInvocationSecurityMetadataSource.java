package com.crown.springsecurity.security.demo5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @ClassName My
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/3/21
 * @Time 16:25
 * @Version 1.0
 */
@Component("myFilterInvocationSecurityMetadataSource")
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private static Logger logger = LoggerFactory.getLogger(MyFilterInvocationSecurityMetadataSource.class);
    /**
     * @param arg0
     * @return  返回用户相关的角色信息
     * @throws IllegalArgumentException
     */
    @Override//ConfigAttribute 角色
    public Collection<ConfigAttribute> getAttributes(Object arg0) throws IllegalArgumentException {
        //包含请求中的所有信息
        FilterInvocation filterInvocation = (FilterInvocation) arg0;
        String fullRequestUrl = filterInvocation.getFullRequestUrl();//受限资源
        //根据受限资源查询角色信息
        for (String string:map.keySet()
             ) {
            //请求对比器
            RequestMatcher matcher = new AntPathRequestMatcher(string);
            boolean matches = matcher.matches(filterInvocation.getHttpRequest());
            if(matches){
                return map.get(string);
            }
        }
        throw new IllegalArgumentException("访问无效资源");

    }

    private static Map<String, List<ConfigAttribute>> map = new HashMap<>();

    static {
        logger.debug("{}-{}-{}","模拟数据库查询:","资源:");
        List<ConfigAttribute> configAttributeList = new ArrayList<>();
        configAttributeList.add(new SecurityConfig("ROLE_USER1"));
        configAttributeList.add(new SecurityConfig("ROLE_USER2"));
        map.put("/user/*",configAttributeList);
        List<ConfigAttribute> configAttributeList1 = new ArrayList<>();
        configAttributeList1.add(new SecurityConfig("ROLE_ADMIN1"));
        configAttributeList1.add(new SecurityConfig("ROLE_ADMIN2"));
        map.put("/admin/*",configAttributeList1);
        List<ConfigAttribute> configAttributeList2 = new ArrayList<>();
        configAttributeList2.add(new SecurityConfig("ROLE_USER1"));
        configAttributeList2.add(new SecurityConfig("ROLE_ADMIN1"));
        map.put("/user_admin/*",configAttributeList2);


    }
    /**
     *
     * @return  返回所有角色信息 一般不用
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     *
     * @param clazz
     * @return
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
