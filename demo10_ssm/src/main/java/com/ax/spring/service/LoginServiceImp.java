package com.ax.spring.service;


import com.ax.spring.dao.Userinfo;
import com.ax.spring.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements ILoginService {

    @Autowired
    private UserinfoMapper userinfoMapper;
//
//    public Logininfo login(String username, String password){
//
//        int count = this.logininfoMapper.getCountByUsername(username);
//
//        if (count<=0){
//
////            Logininfo logininfo  = new Logininfo();
////            logininfo.setUsername(username);
////            logininfo.setPassword(password);
////
////            int insert = this.logininfoMapper.insert(logininfo);
//
//
//
//
//
//
//        }else {
//
//            System.out.println("用户不存在");
//            throw  new  RuntimeException("用户不存在");
//
//        }
//
//        return null;
//    }



    public Userinfo login(String username, String password){


        Userinfo logininfo = this.userinfoMapper.getModelByUsername(username);

        if (logininfo != null && (username.equals(logininfo.getUsername()) && password.equals(logininfo.getPassword()))){

                return logininfo;
        }else {

            throw  new  RuntimeException("账号密码错误");

        }

    }



}
