package com.ax.shop.controller;

import com.ax.shop.entity.Userinfo;
import com.ax.shop.service.IUserinfoService;
import com.ax.shop.util.axtools.AxResultStateEnum;
import com.ax.shop.util.axtools.AxResultEntity;
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

        AxResultEntity<List<Userinfo>> entity = new AxResultEntity<>();
        entity.setStateEnum(AxResultStateEnum.SUCCESS);
        entity.setBody(list);

        return entity;

    }

}