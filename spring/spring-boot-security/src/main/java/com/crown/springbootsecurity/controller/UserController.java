package com.crown.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/12/23
 * @Time 17:10
 * @Version 1.0
 */
@Controller
@RequestMapping("/")
public class UserController {

    @RequestMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String getUsers() {
        return "Hello Spring Security";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String admin() {
        return "Hello Spring Security Admin";
    }

    @GetMapping("/user")
    @ResponseBody
    public String user() {
        return "Hello Spring Security User";
    }
}
