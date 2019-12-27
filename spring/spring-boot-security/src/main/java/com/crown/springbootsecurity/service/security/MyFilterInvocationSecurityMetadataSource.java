package com.crown.springbootsecurity.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName MyFilterInvocationSecurityMetadataSource
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/12/24
 * @Time 17:26
 * @Version 1.0
 */
@Service
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private static Logger logger = LoggerFactory.getLogger(MyFilterInvocationSecurityMetadataSource.class);
    private static Map<String, List<ConfigAttribute>> map = new HashMap<>();
    static {
        System.out.println("{}-{}-{}"+"模拟数据库查询:"+"资源:");
        List<ConfigAttribute> configAttributeList = new ArrayList<>();
        configAttributeList.add(new SecurityConfig("ROLE_ADMIN"));
        map.put("/admin",configAttributeList);
        map.put("/**",configAttributeList);
        List<ConfigAttribute> configAttributeList1 = new ArrayList<>();
        configAttributeList1.add(new SecurityConfig("ROLE_USER"));
        map.put("/user",configAttributeList1);
        map.put("/**",configAttributeList1);

    }

    /**
     * @Author: Crown
     * @Description: 返回本次访问需要的权限，可以有多个权限
     * @Date:
     * @Param: [object]
     * @return: java.util.Collection<org.springframework.security.access.ConfigAttribute>
     **/
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object)
            throws IllegalArgumentException {
        //包含请求中的所有信息
        FilterInvocation filterInvocation = (FilterInvocation) object;
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

    /**
     * @Author: Crown
     * @Description: 此处方法如果做了实现，返回了定义的权限资源列表，
     * Spring Security会在启动时校验每个ConfigAttribute是否配置正确，
     * 如果不需要校验，这里实现方法，方法体直接返回null即可。
     * @Date:
     * @Param: []
     * @return: java.util.Collection<org.springframework.security.access.ConfigAttribute>
     **/
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @Author: Crown
     * @Description: 方法返回类对象是否支持校验，
     * web项目一般使用FilterInvocation来判断，或者直接返回true
     * @Date: 2019/3/27-17:14
     * @Param: [aClass]
     * @return: boolean
     **/
    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

}
