package com.crown.servlet.shiro;

import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PageController
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/8
 * @Time 11:50
 * @Version 1.0
 */
@Controller
public class PageController {

    @RequestMapping({"/index", "/login", "/"})
    public String login() {
        System.out.println("---------");
        return "login";
    }

    /**
     * 该方法会来拦截器登录认证失败后执行
     * @return
     */
    @RequestMapping({"/user/login"})
    public String redirectLogin() {
        /**
         * 注意：必须使用重定向
         * 原因：
         *  当前程序使用Filter进行拦截登录，如果不是重定向，那么进入服务器之后
         *  Filter就只会执行一次，如果要保证每次登录都经过Filter就需要使用重定向
         *  到登录页面
         */
        System.out.println("登录失败，重定向到登录页面！！！---->");
//      return "redirect:/";
//      return "redirect:/index";
        return "redirect:/login";
    }

    @RequestMapping("/login_success")
    public String loginSuccess() {
        return "login_success";
    }

    /**
     * shiro注解需要shiro配置在子容器才生效
     * 1. shiro标签用于控制显示
     * 2. @RequiresRoles用于控制有心人用url直接访问
     * */
    @RequiresRoles("admin")
//  @RequiresPermissions({"insert"})
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @ExceptionHandler({UnauthorizedException.class})
    public String noAccess() {
        return "no_access";
    }

}
