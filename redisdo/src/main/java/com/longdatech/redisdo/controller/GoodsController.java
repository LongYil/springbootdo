package com.longdatech.redisdo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {

//    @Autowired
//    private JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/getDetail")
    public ResponseEntity getDetail(){
        Map map = new HashMap();
        map.put("id",1);
        map.put("name","华为P20");

        BoundListOperations<String,String> boundListOperations = redisTemplate.boundListOps("userList");


        return ResponseEntity.ok(map);
    }


}