package com.crown.springbootsecurity.service.security;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @ClassName ExceptionTranslationFilter
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-06-02
 * @Time 15:25
 * @Version 1.0
 */
public class MyExceptionTranslationFilter extends GenericFilterBean {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
