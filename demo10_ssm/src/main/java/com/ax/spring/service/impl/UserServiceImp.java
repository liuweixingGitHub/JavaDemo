package com.ax.spring.service.impl;

import com.ax.spring.entity.User;
import com.ax.spring.mapper.UserMapper;
import com.ax.spring.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

//这个注解方式必须有 set方式不需要

//@Service("userService")
@Service()
public class UserServiceImp implements IUserService {

	@Autowired
    private UserMapper userMapper;

//    public void setUserMapper(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }

    public void add(User user) {
        userMapper.insert(user);
    }


    public void update(User user) {
        userMapper.update(user);
    }

    public User get(Long id) {
        return userMapper.get(id);
    }

    public void delete(Long id) {
        userMapper.delete(id);

    }

    public List<User> list() {
        return userMapper.list();
    }

}
