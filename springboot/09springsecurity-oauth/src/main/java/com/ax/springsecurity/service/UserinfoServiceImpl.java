package com.ax.springsecurity.service;


import com.ax.springsecurity.entity.Userinfo;
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


