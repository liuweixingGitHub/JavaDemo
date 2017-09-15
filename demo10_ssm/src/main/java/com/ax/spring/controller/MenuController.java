package com.ax.spring.controller;


import com.ax.spring.interceptor.RequiredLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController extends BaseController{

    @RequiredLogin
    @RequestMapping(value="/user/test4.do")
    public ModelAndView test4(Model model){

        ModelAndView mView = new ModelAndView("app.jsp");
//       Userinfo userinfo = UserinfoContext.getCurrent();
//       model.addAttribute("userinfo",userService.get(userinfo.getId()));

        return mView;

    }
}
