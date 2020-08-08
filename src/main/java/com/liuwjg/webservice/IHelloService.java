package com.liuwjg.webservice;

import com.liuwjg.webservice.impl.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
//                                                                                             注意，当接口类和实现类不在同一个包下时，需要指定targetNamespace
@WebService(endpointInterface = "com.liuwjg.webservice.IHelloService",targetNamespace = "http://impl.webservice.liuwjg.com/")
public interface IHelloService {

    @WebMethod
    String hello(@WebParam(name = "name") String name);

    @WebMethod
    User getUser(@WebParam(name = "user")User user);
}
