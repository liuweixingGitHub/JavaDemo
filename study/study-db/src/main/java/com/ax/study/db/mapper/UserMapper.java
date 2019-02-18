package com.ax.study.db.mapper;

import com.ax.study.db.entity.User;

import java.util.List;


/**
 * @author axing
 */
public interface UserMapper {

    void insert(User user);

    void update(User user);

    User get(Long id);

    void delete(Long id);

    List<User> list();

}
