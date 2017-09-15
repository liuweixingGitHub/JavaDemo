package com.ax.spring.controller;

import com.alibaba.fastjson.JSONObject;
import com.ax.spring.domain.Userinfo;
import com.ax.spring.interceptor.RequiredLogin;
import com.ax.spring.service.ILoginService;
import com.ax.spring.util.AXTools.AXJsonView;
import com.ax.spring.context.UserinfoContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController extends BaseController {

    @Autowired
    private ILoginService loginService;


    @RequestMapping(value="/login.do")
    @ResponseBody
    public Map<String,Object> login(@RequestParam(required = true) String username, @RequestParam(required = true) String password){

        String userAgent = this.request.getHeader("user-agent");
        System.out.println("userAgent = " + userAgent);


        Map<String,Object> map = new HashMap<String, Object>();

        Userinfo userinfo = this.loginService.login(username,password, this.request);
        if (userinfo != null){

            map.put("result",true);
            map.put("userinfo",userinfo);

            System.out.println(">>"+UserinfoContext.getCurrent());

        }else {

            map.put("result",false);
            map.put("mes","账号或者密码错误");
        }
        return map;

    }

    /*
    jsp 页面可以直接取值,默认是请求转发 forward:
    ${result}
     */
    @RequestMapping(value="/login2.do")

    public ModelAndView login2(@RequestParam(required=true)String username, @RequestParam(required=true)String password) {

        ModelAndView mView = new ModelAndView("home.jsp");
        Userinfo userinfo = this.loginService.login(username,password, this.request);
        if (userinfo != null){
            mView.addObject("result",true);
            mView.addObject("userinfo",userinfo);

        }else {
            mView.addObject("result",false);
            mView.addObject("mes","账号或者密码错误");
        }
        return mView;

    }



//重定向 redirect
//    /*
//  jsp 页面可以直接取值
//  ${result}
//   */
//    @RequestMapping(value="/login3")
//
//    public ModelAndView login3(@RequestParam(required=true)String username, @RequestParam(required=true)String password,RedirectAttributes
//            redirectAttributes) {
//
//        ModelAndView mView = new ModelAndView("redirect:/app.jsp");
//        Userinfo userinfo = this.loginService.login(username,password, this.request);
//        if (userinfo != null){
//            redirectAttributes.addAttribute("result",true);
////            redirectAttributes.addAttribute("userinfo",userinfo);
//
//        }else {
//            redirectAttributes.addAttribute("result",false);
//            redirectAttributes.addAttribute("mes","账号或者密码错误");
//        }
//        return mView;
//
//    }


}
