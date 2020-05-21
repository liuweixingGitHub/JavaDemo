package com.ax.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OtherController {

    @RequestMapping(value = "/swagger")
    public String index() {
        System.out.println("swagger-ui.html");
        return "redirect:swagger-ui";
    }
}
