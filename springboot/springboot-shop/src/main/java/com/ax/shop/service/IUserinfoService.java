package com.ax.shop.service;

import com.ax.shop.entity.Userinfo;
import com.ax.shop.service.impl.RedisService;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @author axing
 */
public interface IUserinfoService {

    Userinfo get(Long id);

    Userinfo selectUserWithRelo(Long id);

    //    @Cacheable(value = RedisService.REDIS_VALUE_USERINFO,sync=true)
    @Cacheable(value = RedisService.REDIS_VALUE_USERINFO, sync = true)
    List<Userinfo> getAllUserinfo();

    List<Userinfo> getAllUserinfoWithRedis();
}
