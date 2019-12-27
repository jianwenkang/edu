package com.crown.servlet.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @ClassName UserFormAuthenticationFilter
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/8
 * @Time 11:50
 * @Version 1.0
 */
@Component
public class UserFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {

        System.out.println("filter拦截了请求，创建token....");

        //拦截获取登录的账号和密码
        String username = getUsername(request);
        String password = getPassword(request);
        if (password==null){
            password = "";
        }

        //返回UsernamePasswordToken对象
        return new UsernamePasswordToken(username, password);
    }

    //认证成功
    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        System.out.println("filter认证成功方法执行...");
        super.issueSuccessRedirect(request, response);
    }


    //认证失败
    @Override
    protected boolean onLoginFailure(AuthenticationToken token,
                                     AuthenticationException e, ServletRequest request, ServletResponse response) {

        System.out.println("filter认证失败方法执行...");

        String className = e.getClass().getName(), message = "";

        if (IncorrectCredentialsException.class.getName().equals(className)
                || UnknownAccountException.class.getName().equals(className)){
            message = "用户或密码错误, 请重试.";
        }
        else if (e.getMessage() != null && StringUtils.startsWith(e.getMessage(), "msg:")){
            message = StringUtils.replace(e.getMessage(), "msg:", "");
        }
        else{
            message = "系统出现点问题，请稍后再试！";
            e.printStackTrace(); // 输出到控制台
        }

        System.out.println(className + "::" + message);
        request.setAttribute("shiroLoginFailure", className);
        request.setAttribute("message", message);

        /** 认证失败，交给controller继续处理 */
        return true;
    }

}
