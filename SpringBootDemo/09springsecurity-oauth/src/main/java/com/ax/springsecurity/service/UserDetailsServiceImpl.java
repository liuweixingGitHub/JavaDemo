package com.ax.springsecurity.service;

import com.ax.springsecurity.entity.Userinfo;
import com.ax.springsecurity.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {


    @Autowired
    IUserinfoService iUserinfoService;

    @Autowired
    UserinfoMapper userinfoMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Userinfo userinfo =  iUserinfoService.getByUsername(username);
        return userinfo;
    }
}
