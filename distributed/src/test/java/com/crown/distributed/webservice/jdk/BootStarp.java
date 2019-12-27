package com.crown.distributed.webservice.jdk;


import javax.xml.ws.Endpoint;

/**
 * Created by Crown on 2019/1/30.
 */
public class BootStarp {
    public static void main(String[] args) throws Exception {
        Endpoint.publish("http://localhost:8888/vip/hello",new SayHello());
    }
}
