package com.ax.demo.controller;

import com.ax.demo.service.ILoginService;
import com.ax.demo.util.axtools.AxResultMap;
import com.ax.demo.util.axtools.AxResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

/**
 * @author axing
 */
@SuppressWarnings("ALL")
@RestController
public class LoginController extends BaseController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "/login.do")
    @ResponseBody
    public AxResultMap login(@RequestParam(value = "username",required = true) String username, @RequestParam(value = "password" ,required = true) String password) {

        AxResultMap axResultMap = this.loginService.loginState(username, password, this.request);

        System.out.println("axResultMap = " + axResultMap);

        return axResultMap;

    }


    @RequestMapping(value = "/login2.do")
    public Object login2(){

        List list = new LinkedList();
        list.add("B");

        AxResultObject object = new AxResultObject();
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
