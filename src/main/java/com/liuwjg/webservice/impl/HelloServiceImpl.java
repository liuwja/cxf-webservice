package com.liuwjg.webservice.impl;

import com.liuwjg.webservice.IHelloService;
import org.springframework.stereotype.Service;
@Service
public class HelloServiceImpl implements IHelloService {
    @Override
    public String hello(String name) {
        return "hello"+name;
    }

    @Override
    public User getUser(User user) {
        return user;
    }
}
