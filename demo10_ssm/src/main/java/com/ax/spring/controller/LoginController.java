package com.ax.spring.controller;

import com.ax.spring.entity.Userinfo;
import com.ax.spring.service.ILoginService;
import com.ax.spring.context.UserinfoContext;
import com.ax.spring.util.AXTools.AXResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends BaseController {

    @Autowired
    private ILoginService loginService;

    /**
     * jsp 页面可以直接取值,默认是请求转发 forward:
     * ${result}
     */
    @RequestMapping(value = "/login.page")
    public ModelAndView loginPage() {


        ModelAndView modelAndView = new ModelAndView("login");


        return modelAndView;

    }


    @RequestMapping(value = "/login.do")
    @ResponseBody
    public AXResultMap login(@RequestParam(required = true) String username, @RequestParam(required = true) String password) {

//        String userAgent = this.request.getHeader("user-agent");
//        System.out.println("userAgent = " + userAgent);

        AXResultMap axResultMap = this.loginService.loginState(username, password, this.request);

        System.out.println("axResultMap = " + axResultMap);

        return axResultMap;

    }


    @RequestMapping(value = "/login12.do")
    @ResponseBody
    public AXResultMap login12(@RequestParam(required = true) String username, @RequestParam(required = true) String password) {

        String userAgent = this.request.getHeader("user-agent");
        System.out.println("userAgent = " + userAgent);


        AXResultMap axResult = new AXResultMap();

        Userinfo userinfo = this.loginService.login(username, password, this.request);


        if (userinfo != null) {

            axResult.setState(true);
            axResult.put("userinfo", userinfo);

            System.out.println(">>" + UserinfoContext.getCurrent());

        } else {
            axResult.setState(false);
            axResult.setMsg("账号或者密码错误");
        }
        return axResult;

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
