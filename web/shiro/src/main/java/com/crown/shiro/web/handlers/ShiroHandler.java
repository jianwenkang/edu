package com.crown.shiro.web.handlers;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName ShiroHandler
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/5
 * @Time 17:43
 * @Version 1.0
 */

@Controller
@RequestMapping("/shiro")
public class ShiroHandler {

    private static final transient Logger log = LoggerFactory.getLogger(ShiroHandler.class);

    @RequestMapping("/login")
    public String login(@RequestParam("username")String username, @RequestParam("password") String password){
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // rememberme
            token.setRememberMe(true);
            try {
                // 执行登录.
                //将封装好的token传递到自己写的认证接口MyAuthenticatingRealm#doGetAuthenticationInfo
                currentUser.login(token);
            }
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
                System.out.println("登陆失败" + ae.getMessage());
            }
        }
        return "success";
    }
}
