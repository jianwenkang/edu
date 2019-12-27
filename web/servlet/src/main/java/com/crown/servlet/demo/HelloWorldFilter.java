package com.crown.servlet.demo;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName HelloWorldFilter
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/8
 * @Time 10:16
 * @Version 1.0
 */
public class HelloWorldFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("触发 hello world 过滤器...");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
