package com.ax.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RegisterController {

    @RequestMapping(value = "/register.do")
    public ModelAndView register(){

        System.out.println("");
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }
}
