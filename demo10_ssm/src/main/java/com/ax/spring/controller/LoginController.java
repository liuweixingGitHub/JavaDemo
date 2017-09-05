package com.ax.spring.controller;

import com.alibaba.fastjson.JSONObject;
import com.ax.spring.dao.Userinfo;
import com.ax.spring.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @RequestMapping(value="/login")
    @ResponseBody
    public Map<String,Object> login(@RequestParam(required=true)String username, @RequestParam(required=true)String password){

        Map<String,Object> map = new HashMap<String, Object>();

        try {

            Userinfo logininfo = this.loginService.login(username,password);
            System.out.println("logininfo = " + logininfo);
            map.put("result",true);
            map.put("userinfo",logininfo);

        }catch (RuntimeException e){
            map.put("result",false);
            map.put("mes",e.getMessage());
        }
        return map;

    }


    @RequestMapping(value="/login2")

    public ModelAndView login2(@RequestParam(required=true)String username, @RequestParam(required=true)String password){


        ModelAndView mView = new ModelAndView();




//        Map<String,Object> map = new HashMap<String, Object>();

        JSONObject jsonObject = new JSONObject();


        try {

            Userinfo logininfo = this.loginService.login(username,password);

            System.out.println("logininfo = " + logininfo);

//
//            map.put("result",true);
//            map.put("userinfo",logininfo);



            jsonObject.put("result",true);
            jsonObject.put("userinfo",logininfo);



        }catch (RuntimeException e){
//            map.put("result",false);
//            map.put("mes",e.getMessage());

            jsonObject.put("result",true);
            jsonObject.put("mes",e.getMessage());
        }
        mView.addObject("key",jsonObject);
        mView.setViewName("login.jsp");
//        mView.setViewName("redirect:login.jsp");
//        mView.setViewName("forward:/login.jsp");
        return mView;

    }



}
