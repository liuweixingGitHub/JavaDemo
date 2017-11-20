package com.ax.spring.service.impl;

import com.ax.spring.entity.Userinfo;
import com.ax.spring.mapper.UserinfoMapper;
import com.ax.spring.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImp implements IRegisterService {

    @Autowired
    private UserinfoMapper userinfoMapper;



    public boolean register(String username, String password,int userType){

       int count = this.userinfoMapper.getCountByUsername(username);

        if (count<=0){

            Userinfo userinfo  = new Userinfo();
            userinfo.setUsername(username);
            userinfo.setPassword(password);
            userinfo.setUsertype(userType);
            int insert = this.userinfoMapper.insert(userinfo);

            return insert > 0;

        }
            return false;
    }

    public Boolean checkUsername(String username){

        int count = this.userinfoMapper.getCountByUsername(username);
        System.out.println("count = " + count);
        return count<=0;
    }




}
