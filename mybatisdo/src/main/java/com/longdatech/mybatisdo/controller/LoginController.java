package com.longdatech.mybatisdo.controller;

import com.longdatech.mybatisdo.dao.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SysUser sysUser;

    @GetMapping("/test")
    public String test(){
        return "hello,world" + sysUser.countAll();
    }
}
