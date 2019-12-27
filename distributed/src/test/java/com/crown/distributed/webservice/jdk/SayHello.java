package com.crown.distributed.webservice.jdk;

import javax.jws.WebService;

/**
 * Created by Crown on 2019/1/30.
 */
@WebService
public class SayHello implements ISayHello{

    @Override
    public String sayHello(String name) {
        System.out.println("=====");
        return "Hello:"+name;
    }
}
