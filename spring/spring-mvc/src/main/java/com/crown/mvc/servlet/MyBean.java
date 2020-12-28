package com.crown.mvc.servlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;

/**
 * @ClassName MyBean
 * @Description TODO
 * @Author Jianwen Kang
 * @Date 2020-05-20
 * @Time 16:23
 * @Version 1.0
 */
@Controller
public class MyBean {

    @RequestMapping("/hello")
    public @ResponseBody Object getString(String string){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("a",1L);
        stringObjectHashMap.put("b",1);
        stringObjectHashMap.put("c",new Date());

        return stringObjectHashMap;
    }
}
class User{
    Integer id;
    Long age;
    Date date;

}