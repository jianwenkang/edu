package com.crown.springboot.controller;

import com.crown.springboot.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2019/11/7
 * @Time 14:23
 * @Version 1.0
 */
//@Controller
public class HelloController0 {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private String age;

    @Autowired
    private HelloService helloService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        helloService.sayHello();
        return "Hello Spring Boot-->>>!" + age + "---" + name;
    }

    @RequestMapping("/admin")
    @ResponseBody
    public String admin() {
        helloService.sayHello();
        return "Hello admin Spring Boot-->>>!" + age + "---" + name;
    }

    @RequestMapping("/user")
    @ResponseBody
    public String user() {
        helloService.sayHello();
        return "Hello user Spring Boot-->>>!" + age + "---" + name;
    }

    @RequestMapping("/")
    public String index(){
        return "thymeleaf/login";
    }

    @RequestMapping("/home")
    public String home(){
        return "thymeleaf/home";
    }
}
