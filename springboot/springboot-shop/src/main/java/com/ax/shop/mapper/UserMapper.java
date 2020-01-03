package com.ax.shop.mapper;

import com.ax.shop.entity.User;

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
