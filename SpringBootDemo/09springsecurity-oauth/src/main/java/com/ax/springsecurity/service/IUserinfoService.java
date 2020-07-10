package com.ax.springsecurity.service;


import com.ax.springsecurity.entity.Userinfo;

import java.util.List;

/**
 * @author axing
 */
public interface IUserinfoService {

    Userinfo getUserinfoWithKey(long id);

    Userinfo getByUsername(String username);

    Userinfo selectUserWithRelo(long id);

    List<Userinfo> getAllUserinfo();

    List<Userinfo> getAllUserinfoWithRedis();
}
