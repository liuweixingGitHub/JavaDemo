package com.ax.demo.controller;

import com.ax.demo.entity.Userinfo;
import com.ax.demo.service.IUserinfoService;
import com.ax.demo.util.axtools.AxResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserinfoController {


    @Autowired
    IUserinfoService iUserinfoService;


    @RequestMapping(value = "/getUserInfo.do")
    public Object getUserInfo(Long id) {

        Userinfo userinfo = iUserinfoService.get(id);

        return userinfo;

    }

    @RequestMapping(value = "/getAllUserInfo.do")
    public Object getAllUserInfo() {

        List<Userinfo> list = iUserinfoService.getAllUserinfo();

        AxResponseEntity object = new AxResponseEntity();
        object.setState(true);
        object.setList(list);

        return object;

    }

}
