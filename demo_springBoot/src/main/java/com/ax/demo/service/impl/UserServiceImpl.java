package com.ax.demo.service.impl;

import com.ax.demo.entity.User;
import com.ax.demo.mapper.UserMapper;
import com.ax.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author axing
 */
@Service()
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User get(Long id) {
        return userMapper.get(id);
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);

    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }

}
