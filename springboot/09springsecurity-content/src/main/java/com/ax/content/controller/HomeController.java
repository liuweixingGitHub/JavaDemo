package com.ax.content.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")

    public Object home(){

        Map map = new HashMap();
        map.put("code",123);
        return map;
    }
    @GetMapping("/test")
    public Object test(){

        Map map = new HashMap();
        map.put("test","222");
        return map;
    }

    @RequestMapping("/admin")
    @Secured("ROLE_ADMIN")
    public String greeting() { // token =1 才能访问
        return "ROLE_ADMIN";
    }

    @RequestMapping("/admin2")
    @Secured("ROLE_MANAGER")
    public String greeting2() {
        return "ROLE_MANAGER";
    }

}
