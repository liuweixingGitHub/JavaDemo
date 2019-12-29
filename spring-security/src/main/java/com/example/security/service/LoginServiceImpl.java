package com.example.security.service;


import com.example.security.entity.Userinfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author axing
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Override
    public Userinfo getByUserName(String userName) {


        Userinfo userinfo = new Userinfo();
        userinfo.setId(1L);
        userinfo.setUsername(userName);
        userinfo.setPassword("123456");

        return userinfo;

    }


}
