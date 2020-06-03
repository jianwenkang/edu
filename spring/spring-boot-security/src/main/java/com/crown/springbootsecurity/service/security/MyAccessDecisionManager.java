package com.crown.springbootsecurity.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @ClassName MyAccessDecisionManager
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/12/24
 * @Time 17:25
 * @Version 1.0
 */
@Service
public class MyAccessDecisionManager implements AccessDecisionManager {

    private static Logger logger = LoggerFactory.getLogger(MyAccessDecisionManager.class);

    /**
     * @Author: Crown
     * @Description: 取当前用户的权限与这次请求的这个url需要的权限作对比，决定是否放行
     * authentication 包含了当前的用户信息，包括拥有的权限,即之前UserDetailsService登录时候存储的用户对象
     * object 就是FilterInvocation对象，可以得到request等web资源。
     * configAttributes 是本次访问需要的权限。即上一步的 MyFilterInvocationSecurityMetadataSource 中查询核对得到的权限列表
     * @Date:
     * @Param: [authentication, object, configAttributes]
     * @return: void
     */
    @Override
    public void decide(Authentication authentication, Object object,
                       Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {
        if(authentication.getAuthorities() == null){
            logger.info("无效认证信息");
            throw new InsufficientAuthenticationException("无效认证信息");
        }
        //获得认证用户的角色
        Collection<GrantedAuthority> ownedRoles = (Collection<GrantedAuthority>) authentication.getAuthorities();
        ownedRoles.forEach(System.out::println);
        for (GrantedAuthority ownedRole:ownedRoles){
            String ownedStrRole = ownedRole.getAuthority();
            if(ownedStrRole.equals("ROLE_ANONYMOUS")){
                AntPathRequestMatcher matcher = new AntPathRequestMatcher("/login.html");
                HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
                if (matcher.matches(request)) {
                    return;
                }
            }
            for (ConfigAttribute configAttribute:configAttributes
            ) {
                String requiedRole = configAttribute.getAttribute();
                if(requiedRole.equals(ownedStrRole)){
                    return;
                }
            }
        }
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        authorities.forEach(System.out::println);
        logger.info("没有访问权限");
        throw new AccessDeniedException("没有访问权限");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return true;
    }

}
