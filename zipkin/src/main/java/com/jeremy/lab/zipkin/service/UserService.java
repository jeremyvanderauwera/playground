package com.jeremy.lab.zipkin.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void get(){
        new RuntimeException().printStackTrace();
        System.out.println("Hello World");
    }
}
