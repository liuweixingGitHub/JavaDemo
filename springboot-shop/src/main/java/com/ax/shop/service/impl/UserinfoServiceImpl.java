package com.ax.shop.service.impl;

import com.ax.shop.entity.Userinfo;
import com.ax.shop.mapper.UserinfoMapper;
import com.ax.shop.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author axing
 */
@Service
public class UserinfoServiceImpl implements IUserinfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public Userinfo get(Long id) {
        return userinfoMapper.selectByPrimaryKey(id);

    }
    @Override
    public List<Userinfo> getAllUserinfo() {
        return userinfoMapper.getAll();
    }

    @Override
    public Userinfo selectUserWithRelo(Long id) {
        return userinfoMapper.selectUserWithRelo(id);
    }

}


