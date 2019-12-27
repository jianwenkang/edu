package com.crown.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName HomeController
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/12/24
 * @Time 11:52
 * @Version 1.0
 */

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "/web/index";
    }
}
