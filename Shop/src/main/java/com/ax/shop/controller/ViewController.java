package com.ax.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    @RequestMapping(value = "/")
    public ModelAndView index(){
        ModelAndView modelAndView =  new ModelAndView("login");
        modelAndView.addObject("name","tom");
        return modelAndView;
    }
    
    @RequestMapping(value = "/login.html")
    private ModelAndView loginHtml() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/lregister.html")
    private ModelAndView register_html() {
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/500.html")
    private ModelAndView error_500() {
        return new ModelAndView("500");
    }

}
