package com.liuwjg.webservice.config;


import com.liuwjg.webservice.IHelloService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class CXFConfig {

    @Autowired
    IHelloService helloService;

    @Autowired
    Bus bus;

    @Bean
    public Endpoint endpoint() {

        EndpointImpl endpoint = new EndpointImpl(bus, helloService);
//        endpoint.getInInterceptors().add(new AuthInterceptor());//添加校验拦截器
        endpoint.publish("/hello");
        return endpoint;

    }

}
