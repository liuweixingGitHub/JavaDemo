package com.ax.study.all.controller;

import com.ax.study.db.entity.Userinfo;
import com.ax.study.all.service.IRegisterService;
import com.ax.study.all.util.axtools.AxResultEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author axing
 */
@RestController
public class RegisterController {


    @Autowired
    private IRegisterService registerService;


    public RegisterController(IRegisterService registerService) {
        this.registerService = registerService;
    }

    @RequestMapping(value = "/registerPage.do")
    public ModelAndView registerPage(){

        return new ModelAndView("register");
    }


    @RequestMapping(value = "/registerUser.do")
    @ResponseBody
    public Object registerUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {

        boolean register = this.registerService.register(username, password, Userinfo.USERTYPE_NORMAL);


        AxResultEntity responseEntity = new AxResultEntity();

        if (register) {
            responseEntity.setState(true);
            responseEntity.setMsg("注册成功");

        } else {
            responseEntity.setState(false);
            responseEntity.setMsg("用户已存在");
        }
        return responseEntity;
    }



    @RequestMapping(value = "/checkUserName.do")
    @ResponseBody
    public boolean checkUsername(@Param(value = "username") String username) {

        boolean checkUsername = registerService.checkUsername(username);

        System.out.println("checkUsername>>>> "+checkUsername);

        return checkUsername;

    }
}