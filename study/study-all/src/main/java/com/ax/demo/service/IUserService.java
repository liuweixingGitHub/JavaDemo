package com.ax.demo.service;

import com.ax.demo.entity.User;

import java.util.List;


/**
 * @author axing
 */
public interface IUserService {

    void add(User user);

    void update(User user);

    User get(Long id);

    void delete(Long id);

    List<User> list();

}
