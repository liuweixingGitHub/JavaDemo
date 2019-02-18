package com.ax.study.all.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author axing
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/")
    public ModelAndView index(){
        System.out.println("index>>>>>>");

        ModelAndView modelAndView =  new ModelAndView("login");
        modelAndView.addObject("name","tom");
        return modelAndView;
    }

}