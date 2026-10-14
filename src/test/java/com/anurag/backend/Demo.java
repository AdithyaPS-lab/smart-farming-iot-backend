package com.anurag.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {//API

    @GetMapping
    public String m1(){
        return "Hello World";
    }
    public String m2(){
        return "Welcome to Spring Boot";
    }
    public String m3(){
        return "Hi, How are you?";
    }
    
}