package com.ax.spring.controller;

import com.ax.spring.service.IRegisterService;
import com.ax.spring.util.AXResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class RegisterController {

    @Autowired
    private IRegisterService registerService;

    @RequestMapping(value="/register")
    @ResponseBody
    public AXResult register(@RequestParam(required=true)String username, @RequestParam(required=true)String password){

        AXResult result = new  AXResult();
        try {

            this.registerService.register(username,password);

            result.setResult(true);
            result.setMsg("注册成功");

        }catch (RuntimeException e){
            result.setResult(false);
            result.setMsg(e.getMessage());
        }
        return result;

    }








}
