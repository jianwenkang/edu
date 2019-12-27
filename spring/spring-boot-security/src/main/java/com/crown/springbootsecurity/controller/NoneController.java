package com.crown.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName NoneController
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/12/24
 * @Time 16:45
 * @Version 1.0
 */
@Controller
@RequestMapping("/none")
public class NoneController {

    @RequestMapping("/pagea")
    public String pagea(){
        return "/web/npa";
    }

    @RequestMapping("/pageb")
    public String pageb(){
        return "/web/npb";
    }
}
