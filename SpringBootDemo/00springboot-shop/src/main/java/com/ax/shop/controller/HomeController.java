package com.ax.shop.controller;

import com.ax.shop.annotation.RequireToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {



    /**
     * PageInfo 含有页面信息
     */
    @RequestMapping(value = "/toId")
    @RequireToken
    public Object ipLogPageInfo() {

        Map<String, Object> map = new HashMap<>();
        map.put("home","首页");
        return map;

    }



}
