package com.ax.spring.service.impl;

import com.ax.spring.domain.Userinfo;
import com.ax.spring.mapper.UserinfoMapper;
import com.ax.spring.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImp implements IRegisterService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    public boolean register(String username, String password){

       int count = this.userinfoMapper.getCountByUsername(username);

        if (count<=0){

            Userinfo userinfo  = new Userinfo();
            userinfo.setUsername(username);
            userinfo.setPassword(password);

            int insert = this.userinfoMapper.insert(userinfo);

            return insert >0? true : false;

        }


            return false;




    }

}
