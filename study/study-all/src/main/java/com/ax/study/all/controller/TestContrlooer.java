package com.ax.study.all.controller;

import com.ax.study.all.service.impl.RedisService;
import com.ax.study.all.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestContrlooer {

    @Autowired
    RedisService redisService;

    @Autowired
    HttpClientService httpClientService;


    @RequestMapping(value = "/doRedis.do")
    public void doRedis() {

        redisService.set("key_redis_nane", "jim");

    }


    @RequestMapping(value = "/getRedis.do")
    public Object getRedis() {

        return redisService.get("key_redis_nane");

    }

    @RequestMapping(value = "/toHttp.do")
    public Object toHttp() {
//        String url = "http://www.suning.com/";
        String url = "http://localhost:8080/getIpLog.do?id=88";

//        String url = "http://www.baidu.com/";
        return httpClientService.getClient(url, null, Object.class);


    }

}
