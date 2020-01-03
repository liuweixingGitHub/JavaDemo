package com.ax.consumer.controller;

import com.ax.dubbo.entity.User;
import com.ax.dubbo.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    /**
     * dubbo注解
     **/
    @Reference(version = "1.0.0")
    UserService userService;


    @RequestMapping("/user")
    public Object user() {
        String user = userService.sayHi("jim");
        return user;
    }

    @RequestMapping("/user2")
    public Object user2() {
        User user = userService.getUser(1L);
        return user;
    }
}
