package com.ax.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {

    @RequestMapping(value = "/api")
    public String api() {
        System.out.println("swagger-ui.html");
        return "redirect:swagger-ui.html";
    }
}
