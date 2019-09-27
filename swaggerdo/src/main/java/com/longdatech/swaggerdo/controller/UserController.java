package com.longdatech.swaggerdo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private Set<String> set = new HashSet<>();

    @PostMapping("/test")
    public String test() throws Exception{

        set.add(Thread.currentThread().getName());
        Random random = new Random();
        Thread.sleep(random.nextInt(10) * 100);
        log.info("测试swaggerdo");
        return "hello,world" + Thread.currentThread().getName();
    }

    @GetMapping("/getThread")
    public String getThread(){
        System.out.println("线程数：" + set.size());
        return "" + set.size();
    }

}
