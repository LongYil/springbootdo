package com.longdatech.swaggerdo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/test")
    public String test() throws Exception{
        Random random = new Random();
        Thread.sleep(random.nextInt(10) * 1000);
        return "hello,world" + Thread.currentThread().getName();
    }


}
