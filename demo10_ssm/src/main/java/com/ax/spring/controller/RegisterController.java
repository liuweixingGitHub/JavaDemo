package com.ax.spring.controller;

import com.ax.spring.entity.Userinfo;
import com.ax.spring.service.IRegisterService;
import com.ax.spring.util.AXTools.AXResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class RegisterController {

    @Autowired
    private IRegisterService registerService;

    @RequestMapping(value = "/register.do")
    @ResponseBody
    public AXResultMap register(@RequestParam(required = true) String username, @RequestParam(required = true) String password) {

        boolean register = this.registerService.register(username, password, Userinfo.USERTYPE_NORMAL);

        AXResultMap result = new AXResultMap();
        if (register) {
            result.setState(true);
            result.setMsg("注册成功");

        } else {
            result.setState(false);
            result.setMsg("用户已存在");
        }
        return result;
    }

    @RequestMapping(value = "/checkUserName.do")
    @ResponseBody
    public boolean checkUsername(@RequestParam(required = true) String username) {

        Boolean checkUsername = registerService.checkUsername(username);
        System.out.println("checkUsername>>>> "+checkUsername);

        return checkUsername;

    }

    /**
     * 注册页面
     */
    @RequestMapping(value = "/register.page")
    public ModelAndView register_jsp() {

        ModelAndView modelAndView = new ModelAndView("register");

        System.out.println("register.html>>>" + modelAndView);

        return modelAndView;
    }

}
