package com.ax.spring.service;

import com.ax.spring.domain.Userinfo;
import com.ax.spring.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImp implements IRegisterService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    public  void  register(String username, String password){

       int count = this.userinfoMapper.getCountByUsername(username);

        if (count<=0){

            Userinfo userinfo  = new Userinfo();
            userinfo.setUsername(username);
            userinfo.setPassword(password);

            int insert = this.userinfoMapper.insert(userinfo);

        }else {
            System.out.println("用户已经存在");
            throw  new  RuntimeException("用户已经存在");

        }

    }

}
