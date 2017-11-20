package com.ax.spring.service.impl;

import com.ax.spring.entity.Userinfo;
import com.ax.spring.mapper.UserinfoMapper;
import com.ax.spring.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoServiceImpl implements IUserinfoService{

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public Userinfo get(Long id) {


        return userinfoMapper.selectByPrimaryKey(id);

    }
}
