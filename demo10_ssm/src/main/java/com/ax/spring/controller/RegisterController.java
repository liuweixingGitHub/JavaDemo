package com.ax.spring.controller;

import com.ax.spring.entity.Userinfo;
import com.ax.spring.service.IRegisterService;
import com.ax.spring.util.AXTools.AXResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RegisterController {

    @Autowired
    private IRegisterService registerService;

    @RequestMapping(value="/register.do")
    @ResponseBody
    public AXResultMap register(@RequestParam(required=true)String username, @RequestParam(required=true)String password){

        boolean register = this.registerService.register(username,password,Userinfo.USERTYPE_NORMAL);

        AXResultMap result = new AXResultMap();
        if (register){
            result.setSuccess(true);
            result.setMsg("注册成功");

        }else {
            result.setSuccess(false);
            result.setMsg("用户已存在");
        }
        return result;
    }

    @RequestMapping(value="/checkUsername.do")
    @ResponseBody
    public AXResultMap checkUsername(@RequestParam(required=true)String username){

        Boolean checkUsername = registerService.checkUsername(username);
        System.out.println("username = " + username+ "\n"+"checkUsername="+checkUsername);
//        return registerService.checkUsername(username);

        AXResultMap result = new AXResultMap();
        result.setSuccess(checkUsername);

        return result;

    }

}
