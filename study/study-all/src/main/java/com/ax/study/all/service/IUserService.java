package com.ax.study.all.service;

import com.ax.study.db.entity.User;

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
