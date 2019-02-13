package com.ax.demo.controller;

import com.ax.demo.interceptor.RequiredLogin;
import com.ax.demo.service.ILoginService;
import com.ax.demo.util.axtools.AxResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author axing
 */
@RestController
public class LoginController extends BaseController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value = "/login.do")
    @ResponseBody
    public Object login(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password) {

        Object axResultMap = this.loginService.loginState(username, password, this.request);

        System.out.println("axResultMap = " + axResultMap);

        return axResultMap;

    }


    @RequestMapping(value = "/login2.do")
    public Object login2() {

        List<String> list = new ArrayList<>();
        list.add("B");

        AxResponseEntity object = new AxResponseEntity();
        object.setState(true);
        object.setMsg("uuuuudddddd");
        object.setBody(list);

        return object;

    }

    @RequestMapping(value = "/login3.do")
    public Object login3() {

        List<String> list = new LinkedList<>();
        list.add("B");

        AxResponseEntity<List<String>> object = new AxResponseEntity<>();
        object.setState(true);
        object.setMsg("eee");
        object.setBody(list);

        return object;

    }

    /**
     * jsp 页面可以直接取值,默认是请求转发 forward:
     * ${result}
     */
    @RequestMapping(value = "/home.page")
    @RequiredLogin
    private ModelAndView homePage() {
        return new ModelAndView("home");

    }


}
