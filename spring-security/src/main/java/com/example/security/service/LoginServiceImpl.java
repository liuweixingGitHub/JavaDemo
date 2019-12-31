package com.example.security.service;


import com.example.security.entity.UserRole;
import com.example.security.entity.Userinfo;
import com.example.security.util.AxJwtUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author axing
 */
@Service("LoginServiceImpl")
public class LoginServiceImpl implements ILoginService {

    @Override
    public Userinfo getByUserName(String userName) {

        List<UserRole> list = new ArrayList<>();

        Userinfo userinfo = new Userinfo();
        userinfo.setId(1L);
        userinfo.setUsername(userName);
        userinfo.setPassword("123456");
        userinfo.setAuthorities(list);

        {
            UserRole role = new UserRole();
            role.setId(1L);
            role.setRole("ROLE_ADMIN");
            list.add(role);
        }

        return userinfo;

    }

    private Userinfo getUserinfo(List<UserRole> list, Userinfo userinfo) {
        userinfo.setAuthorities(list);


        return userinfo;
    }

    @Override
    public Userinfo getById(Long id) {

        List<UserRole> list = new ArrayList<>();

        Userinfo userinfo = new Userinfo();
        userinfo.setId(id);
        userinfo.setUsername("jim");
        userinfo.setPassword("123456");
        userinfo.setAuthorities(list);
        {
            UserRole role = new UserRole();
            role.setId(1L);
            role.setRole("ROLE_ADMIN");
            list.add(role);
        }
       String token = AxJwtUtil.createJWT(userinfo.getId().toString(), userinfo.getUsername(), null, 0);
        userinfo.setToken(token);
        System.out.println("token = " + token);

        return userinfo;
    }

}
