package com.ax.study.all.controller;

import com.ax.study.db.entity.Userinfo;
import com.ax.study.all.service.IUserinfoService;
import com.ax.study.all.util.axtools.AxResultEntity;
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

        return iUserinfoService.get(id);

    }

    @RequestMapping(value = "/getAllUserInfo.do")
    public Object getAllUserInfo() {

        List<Userinfo> list = iUserinfoService.getAllUserinfo();

        AxResultEntity<List<Userinfo>> object = new AxResultEntity<>();
        object.setState(true);
        object.setBody(list);

        return object;

    }

}
