package com.longdatech.redisdo.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.longdatech.redisdo.po.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        SetOperations set = redisTemplate.opsForSet();
        set.add(map.get("id"),map);
        Map res = (Map) set.pop(1);

        return ResponseEntity.ok(res);
    }

    @GetMapping("/testSet")
    public String testSet(){
        redisTemplate.opsForValue().set("num","123321");
        String str = (String) redisTemplate.opsForValue().get("num");

        redisTemplate.opsForValue().increment("increlong",1);
        Object a = redisTemplate.opsForValue().get("increlong");
        return str + ":" + a;
    }

    @GetMapping("/testList")
    public Object testList(){
        Person person = new Person();
        person.setAge(12);
        person.setUname("哈哈哈");

        Object jsonObject = JSONObject.toJSON(person);

        redisTemplate.opsForList().leftPush("user1",jsonObject.toString());

        String p = (String) redisTemplate.opsForList().leftPop("user1");

        Object obj = JSONObject.parse(p);

        return obj;
    }


}