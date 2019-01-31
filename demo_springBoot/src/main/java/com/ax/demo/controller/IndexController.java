package com.ax.demo.controller;

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

        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

}
