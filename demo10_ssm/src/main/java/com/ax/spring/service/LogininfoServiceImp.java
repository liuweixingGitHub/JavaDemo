package com.ax.spring.service;

import com.ax.spring.dao.Logininfo;
import com.ax.spring.mapper.LogininfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogininfoServiceImp implements ILogininfoService {

    @Autowired
    private LogininfoMapper logininfoMapper;


    public  void  register(String username, String password){

        System.out.println(username+"----"+password);

       int count = this.logininfoMapper.getCountByUsername(username);


//
        System.out.println("count>> "+count);
//        System.out.println("count>> "+this.logininfoMapper.selectByPrimaryKey(1L));

        if (count<=0){

            Logininfo logininfo  = new Logininfo();
            logininfo.setUsername(username);
            logininfo.setPassword(password);

           int insert = this.logininfoMapper.insert(logininfo);

            System.out.println("insert>> "+insert);

        }else {
            System.out.println("用户已经存在");
            throw  new  RuntimeException("用户已经存在");

        }

    }

}
