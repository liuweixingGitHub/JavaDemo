package com.ax.spring.service;

import com.ax.spring.entity.User;

import java.util.List;



public interface IUserService {

    void add(User user);

    void update(User user);
    User get(Long id);
    void  delete(Long id);
    List<User> list();

}
