package com.ax.springsecurity.service;


import com.ax.springsecurity.entity.Userinfo;
import com.ax.springsecurity.util.axUtil.AxResultEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author axing
 */
@Service
public class LoginServiceImpl implements ILoginService {



    @Override
    public Userinfo login(String username, String password, HttpServletRequest request) {



        Userinfo userinfo = null;


        return userinfo;

    }

    @Override
    public Userinfo getByUserName(String username) {

        Userinfo userinfo = new Userinfo();

        return userinfo;

    }

    @Override
    public Userinfo getById(Long id) {
        return null;
    }


    @Override
    public Object loginState(String username, String password, HttpServletRequest request) {


        Userinfo userinfo = new Userinfo();

        System.out.println("userinfo = " + userinfo);


        AxResultEntity<Userinfo> responseEntity = new AxResultEntity();

        return responseEntity;

    }

    @Override
    public boolean hasAdmin() {

        return false;

    }

    @Override
    public void createAdmin() {



    }
}
