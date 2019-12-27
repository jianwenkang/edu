package com.crown.springsecurity.controller;

import com.crown.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * @ClassName UserController
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/3/20
 * @Time 11:04
 * @Version 1.0
 */
@RequestMapping
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
        System.out.println("=========="+userService);
    }

    @RequestMapping("/user/login")
    public String login(){
        System.out.println("==="+userService);
        return "index";
    }
    @RequestMapping("/user/add")
    public String useradd(){
        System.out.println("useradd");
        return "index";
    }
    @RequestMapping("/admin/add")
    public String adminadd(){
        System.out.println("adminadd");
        return "index";
    }
    @RequestMapping("/user_admin/add")
    public String useradminadd(){
        System.out.println("useradminadd");
        return "index";
    }
}
