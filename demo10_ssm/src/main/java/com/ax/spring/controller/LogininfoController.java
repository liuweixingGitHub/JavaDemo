package com.ax.spring.controller;

import com.ax.spring.service.ILogininfoService;
import com.ax.spring.util.AXResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LogininfoController {

    @Autowired
    private ILogininfoService logininfoService;

    @RequestMapping(value="/reg")
    @ResponseBody
    public AXResult reg(String username, String password){

        AXResult result = new  AXResult();
        try {

            this.logininfoService.register(username,password);

            result.setResult(true);
            result.setMsg("注册成功");

        }catch (RuntimeException e){

            result.setResult(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }






}
