package com.ax.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    /**
     * PageInfo 含有页面信息
     */
    @RequestMapping(value = "/home.do")
    public Object ipLogPageInfo() {

        Map<String, Object> map = new HashMap<>();
        map.put("home","首页");
        return map;

    }

    @RequestMapping(value = "/home.page")
    public Object ipLogPageInfo1() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;

    }

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = {"/","/hi","/index.html"})
    public ModelAndView index(HttpServletRequest request){
        ModelAndView modelAndView = new ModelAndView("index");
        System.out.println(" request.getRemotePort() = " + request.getServerPort());

        modelAndView.addObject("port",request.getServerPort());

        return modelAndView;

    }

}
