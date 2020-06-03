package com.crown.springbootsecurity.service.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MyAuthenticationSuccessHandler
 * @Description TODO可以根据不同的用户权限跳转不同的页面
 * @Author Jianwen Kang
 * @Date 2020-06-01
 * @Time 17:33
 * @Version 1.0
 */
@Service
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static Logger logger = LoggerFactory.getLogger(MyAuthenticationFailHander.class);

    @Autowired
    private ObjectMapper objectMapper;
    {
        map.put("ADMIN","/admin");
        map.put("USER","/user");
    }
    /**
     * url参数
     */
    private static Map<String, String> map = new HashMap<>();
    /**
     * 多role选择,默认取得权限表第一个权限
     */
    private boolean isFirst = true;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("登陆成功");
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        httpServletResponse.sendRedirect(map.get(authorities.iterator().next().toString()));

    }
    /**
     * 权限跳转依据
     * @param map 参数
     *  key:url
     *  value:role
     */
    public void setAuthDispatcherMap(Map<String, String> map) {
        this.map = map;
    }

    /**
     * 多种角色方案
     * 设置是否只取得第一个role
     * @param isFirst true:多种角色只取第一个，false:取得最后一个
     */
    public void setMultipleAuth(boolean isFirst) {
        this.isFirst = isFirst;
    }
}
