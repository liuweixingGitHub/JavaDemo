package com.ax.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {

    @GetMapping("/")
    public ModelAndView index(@RequestParam(value = "id")String id){

        System.out.println("index id = " + id);

        ModelAndView mav=new ModelAndView("socket");
        mav.addObject("uid", id);
        return mav;
    }
}
