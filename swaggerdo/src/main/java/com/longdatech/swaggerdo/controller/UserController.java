package com.longdatech.swaggerdo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/test")
    public String test(HttpServletRequest request) throws Exception{
        
        Random random = new Random();
        Thread.sleep(random.nextInt(10) * 1000);
        log.info("测试swaggerdo");
        return "hello,world" + Thread.currentThread().getName();
    }


}
