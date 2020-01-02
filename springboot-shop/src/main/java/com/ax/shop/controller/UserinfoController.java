package com.ax.shop.controller;

import com.ax.shop.service.IRedisService;
import com.ax.shop.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class UserinfoController {


    @Autowired
    IUserinfoService iUserinfoService;


    @RequestMapping(value = "/getUserInfo.do")
    public Object getUserInfo(Long id) {

        return iUserinfoService.get(id);

    }

    @Autowired
    private IRedisService redisService;

    @Autowired
    RedisTemplate redisTemplate;

  @RequestMapping(value = "/getAllUserInfo.do")
    public Object getAllUserInfo() {



//        StringRedisSerializer redisSerializer = new StringRedisSerializer();
//        RedisTemplate redisTemplate = new RedisTemplate();
//        redisTemplate.setKeySerializer(redisSerializer);


//        redisService.set("allUserInfo","AA");



        Runnable runnable = () -> iUserinfoService.getAllUserinfoWithRedis();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        /**submit有返回值，而execute没有*/


        for (int i = 0; i < 1000; i++) {
            executorService.submit(runnable);
        }
//        List<Userinfo> list = iUserinfoService.getAllUserinfo();
//
//        AxResultEntity<List<Userinfo>> entity = new AxResultEntity<>();
//        entity.setStateEnum(AxResultStateEnum.SUCCESS);
//        entity.setBody(list);
//
//        return entity;


        //加上双层检测锁




//            return orderList;



        return iUserinfoService.getAllUserinfoWithRedis();

    }

}
