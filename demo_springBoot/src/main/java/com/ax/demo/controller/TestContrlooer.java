package com.ax.demo.controller;

import com.ax.demo.config.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContrlooer {

    @Autowired
    RedisService redisService;

    @RequestMapping(value = "/doRedis.do")
    public void doRedis(){

        redisService.set("key_redis_nane","jim");

    }


    @RequestMapping(value = "/getRedis.do")
    public Object getRedis(){

       return redisService.get("key_redis_nane");

    }

}
