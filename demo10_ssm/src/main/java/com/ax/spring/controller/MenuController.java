package com.ax.spring.controller;


import com.ax.spring.context.UserinfoContext;
import com.ax.spring.entity.Userinfo;
import com.ax.spring.interceptor.RequiredLogin;
import com.ax.spring.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController extends AccountController{

//    @RequiredLogin
//    @RequestMapping(value="/user/menu.do")
//    @ResponseBody
//    public AXResultMap menu(@RequestParam(required=true)String id){
//        return AXResultMap.succeeList(null);
//    }

    @Autowired
    private IUserinfoService userinfoService;



    @RequiredLogin
    @RequestMapping(value="/menu.do")
    public String menu(Model model){

        Userinfo userinfo = UserinfoContext.getCurrent();
        model.addAttribute("userinfo", userinfoService.get(userinfo.getId()));
        System.out.println("userinfo = " + userinfo);

        return "menu12";
    }

}
