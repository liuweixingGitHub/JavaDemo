package com.ax.demo.controller;

import com.ax.demo.service.ILoginService;
import com.ax.demo.util.axtools.AXResultMap;
import com.ax.demo.util.axtools.AXResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@RestController
public class LoginController extends BaseController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "/login.do")
    @ResponseBody
    public AXResultMap login(@RequestParam(value = "username",required = true) String username, @RequestParam(value = "password" ,required = true) String password) {

        AXResultMap axResultMap = this.loginService.loginState(username, password, this.request);

        System.out.println("axResultMap = " + axResultMap);

        return axResultMap;

    }


    @RequestMapping(value = "/login2.do")
    public Object login2(){

        List list = new LinkedList();
        list.add("B");

        AXResultObject object = new AXResultObject();
        object.setState(true);
        object.setMsg("hhh");
        object.setList(list);

        return object;

    }



    /**
     * jsp 页面可以直接取值,默认是请求转发 forward:
     * ${result}
     */
    @RequestMapping(value = "/home.page")
    public ModelAndView homePage() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;

    }


}
