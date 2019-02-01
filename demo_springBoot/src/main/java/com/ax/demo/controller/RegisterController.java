package com.ax.demo.controller;

import com.ax.demo.entity.Userinfo;
import com.ax.demo.service.IRegisterService;
import com.ax.demo.util.axtools.AxResultMap;
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
    public AxResultMap registerUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {

        boolean register = this.registerService.register(username, password, Userinfo.USERTYPE_NORMAL);

        AxResultMap result = new AxResultMap();
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
    public boolean checkUsername(@Param(value = "username") String username) {

        boolean checkUsername = registerService.checkUsername(username);

        System.out.println("checkUsername>>>> "+checkUsername);

        return checkUsername;

    }
}
