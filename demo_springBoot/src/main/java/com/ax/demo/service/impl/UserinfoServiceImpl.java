package com.ax.demo.service.impl;

import com.ax.demo.entity.Userinfo;
import com.ax.demo.mapper.UserinfoMapper;
import com.ax.demo.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserinfoServiceImpl implements IUserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public Userinfo get(Long id) {


        return userinfoMapper.selectByPrimaryKey(id);

    }
}
