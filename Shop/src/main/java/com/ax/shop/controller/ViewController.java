package com.ax.shop.controller;

import io.swagger.annotations.ApiOperation;
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


    @RequestMapping(value = "/loginError.html")
    private ModelAndView loginError() {
        return new ModelAndView("loginError");
    }





    @RequestMapping(value = "/register.html")
    private ModelAndView register_html() {
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/500.html")
    private ModelAndView error_500() {
        return new ModelAndView("500");
    }

    /**
     * jsp 页面可以直接取值,默认是请求转发 forward:
     * ${result}
     */
    @ApiOperation(value = "登录页面", notes = "进入home页面")
    @RequestMapping(value = "/home.html")
    private ModelAndView homePage() {
        return new ModelAndView("home");

    }

}
