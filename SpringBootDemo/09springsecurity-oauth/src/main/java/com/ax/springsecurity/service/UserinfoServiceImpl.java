package com.ax.springsecurity.service;


import com.ax.springsecurity.entity.Userinfo;
import com.ax.springsecurity.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author axing
 */
@Service
public class UserinfoServiceImpl implements IUserinfoService {



    @Override
    public Userinfo getUserinfoWithKey(long id) {
        return null;

    }

    @Autowired
    UserinfoMapper userinfoMapper;
    @Override
    public Userinfo getByUsername(String username) {
        System.out.println("username111 = " + username);

        Userinfo userinfo = userinfoMapper.selectUserAndReloByName(username);
////        Userinfo userinfo = userinfoMapper.selectUserWithRelo(1L);
////        System.out.println("userinfo = " + userinfo);
//

//
//        if (userinfo1 == null){
//          Userinfo userinfo = new Userinfo();
//        userinfo.setId(1l);
//        userinfo.setUsername(username);
////        userinfo.setPassword("123456");
//        userinfo.setPassword(new BCryptPasswordEncoder().encode(("123456")));
//        UserRole userRole = new UserRole();
//        userRole.setId(1L);
//        userRole.setRole("ROLE_ADMIN");
//        List list = new ArrayList();
//        list.add(userRole);
//        userinfo.setAuthorities(list);
//            return userinfo;
//        }


        return userinfo;
    }

    @Override
    public List<Userinfo> getAllUserinfo() {

        return null;
    }

    @Override
    public Userinfo selectUserWithRelo(long id) {
        return null;
    }


    @Override
    public List<Userinfo> getAllUserinfoWithRedis() {

        return null;
    }
}


