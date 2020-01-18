package com.ax.content.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/content")
public class ContentController {

    @RequestMapping("/")
    public String content() {
        return "content";
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
