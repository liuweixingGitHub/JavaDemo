package com.example.security;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author axing
 */

@Controller
public class LoginController  {


    @RequestMapping(value = "/")
    public ModelAndView index(){
        ModelAndView modelAndView =  new ModelAndView("login.html");
        return modelAndView;
    }
}
