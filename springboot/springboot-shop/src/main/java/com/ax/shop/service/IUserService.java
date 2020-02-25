package com.ax.shop.service;

import com.ax.shop.entity.User;

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
