package com.ax.spring.controller;


import com.ax.spring.interceptor.RequiredLogin;
import com.ax.spring.util.AXTools.AXResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController extends BaseController{

    @RequiredLogin
    @RequestMapping(value="/user/menu.do")
    @ResponseBody
    public AXResult test4(Model model){

        AXResult axResult = new AXResult();
        axResult.setSuccess(true);

//        ModelAndView mView = new ModelAndView("app.jsp");
//       Userinfo userinfo = UserinfoContext.getCurrent();
//       model.addAttribute("userinfo",userService.get(userinfo.getId()));

        return axResult;

    }
}
