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
    public Object getUserInfo(long id) {

        System.out.println("id = " + id);

        return iUserinfoService.getUserinfoWithKey(id);

    }

    @Autowired
    private IRedisService redisService;

    @Autowired
    RedisTemplate redisTemplate;

  @RequestMapping(value = "/getAllUserInfo.do")
    public Object getAllUserInfo() {

        Runnable runnable = () -> iUserinfoService.getAllUserinfo();
        /**简历线程池,避免直接用线程**/
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        /**submit有返回值，而execute没有*/
        for (int i = 0; i < 1000; i++) {
            executorService.submit(runnable);
        }
      return iUserinfoService.getAllUserinfo();

    }


    @RequestMapping(value = "/getAllUserInfo2.do")
    public Object getAllUserInfo2() {

        Runnable runnable = () -> iUserinfoService.getAllUserinfoWithRedis();

        /**简历线程池,避免直接用线程**/
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        /**submit有返回值，而execute没有*/
        for (int i = 0; i < 1000; i++) {
            executorService.submit(runnable);
        }
        return iUserinfoService.getAllUserinfoWithRedis();

    }

}
