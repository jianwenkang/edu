package com.crown.distributed.webservice.jdk;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Crown on 2019/1/30.
 */

@WebService
public interface ISayHello {

    @WebMethod
    String sayHello(String name);
}
