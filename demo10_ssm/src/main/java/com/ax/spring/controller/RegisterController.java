package com.ax.spring.controller;

import com.ax.spring.service.IRegisterService;
import com.ax.spring.util.AXTools.AXResult;
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
    public AXResult register(@RequestParam(required=true)String username, @RequestParam(required=true)String password){

        boolean register = this.registerService.register(username,password);

        AXResult result = new  AXResult();
        if (register){
            result.setResult(true);
            result.setMsg("注册成功");
        }else {
            result.setResult(false);
            result.setMsg("用户已存在");
        }
        return result;

    }

}
