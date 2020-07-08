package com.ax.demo;

import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class IdSnowflake {

    @PostConstruct
    public void init(){
        System.out.println("init==========");
        String localhostStr = NetUtil.getLocalhostStr();
        log.info("localhostStr = {}",localhostStr);
        System.out.println("localhostStr = " + localhostStr);
        long ipv4ToLong = NetUtil.ipv4ToLong(localhostStr);
        System.out.println("ipv4ToLong = " + ipv4ToLong);


    }
}
