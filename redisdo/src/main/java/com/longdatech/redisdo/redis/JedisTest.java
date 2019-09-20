package com.longdatech.redisdo.redis;

import com.whalin.MemCached.MemCachedClient;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

public class JedisTest {

    public static void main(String[] args){
//        RedisConnectionFactory factory;
//
//        RedisConnection redisConnection;
//
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//        jedisConnectionFactory.setHostName("localhost");
//        jedisConnectionFactory.setPort(6379);
//        jedisConnectionFactory.setPassword("");
//
//        redisConnection = jedisConnectionFactory.getConnection();
//
//        String obj = redisConnection.getClientName();
//        System.out.println(obj);

        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName("localhost");
        factory.setPort(6379);

        System.out.println(factory.getConnection());
    }

    public void test(){
        MemCachedClient memCachedClient=new MemCachedClient();
        memCachedClient.set("username","luck");
        String value= (String) memCachedClient.get("username");
        System.out.println(value);
    }
}
