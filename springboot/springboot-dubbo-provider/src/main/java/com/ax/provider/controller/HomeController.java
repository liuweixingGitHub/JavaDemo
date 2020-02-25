package com.ax.provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/home")
    public Object user() {
        System.out.println("home 123");
        return "home-provider";
    }
}
