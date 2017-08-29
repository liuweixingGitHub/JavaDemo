package com.ax.spring.service;

import com.ax.spring.domain.User;
import com.ax.spring.mapper.UserMapper;

import java.util.List;


public class UserServiceImp implements  IUserService{

	
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

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
