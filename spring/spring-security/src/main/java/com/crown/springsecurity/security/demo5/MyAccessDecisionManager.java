package com.crown.springsecurity.security.demo5;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import java.util.Collection;

/**
 * @ClassName MyAccessDecisionManager
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/3/21
 * @Time 17:03
 * @Version 1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Component("myAccessDecisionManager")
public class MyAccessDecisionManager implements AccessDecisionManager {
    /**
     *
     * @param authentication  认证对象
     * @param url   访问资源
     * @param requiedRoles  访问资源所对应的角色
     * @throws AccessDeniedException    没有访问权限
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object url,
                       Collection<ConfigAttribute> requiedRoles)
            throws AccessDeniedException, InsufficientAuthenticationException {
        if(authentication.getAuthorities() == null)throw new InsufficientAuthenticationException("无效认证信息");
        //获得认证用户的角色
        Collection<GrantedAuthority> ownedRoles = (Collection<GrantedAuthority>) authentication.getAuthorities();
        for (GrantedAuthority ownedRole:ownedRoles){
            String ownedStrRole = ownedRole.getAuthority();
            for (ConfigAttribute configAttribute:requiedRoles
                 ) {
                String requiedRole = configAttribute.getAttribute();
                if(requiedRole.equals(ownedStrRole)){
                    return;
                }
            }
        }
        throw new AccessDeniedException("没有访问权限");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
