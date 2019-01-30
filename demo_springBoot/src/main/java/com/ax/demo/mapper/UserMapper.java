package com.ax.demo.mapper;

import com.ax.demo.entity.User;

import java.util.List;


public interface UserMapper{

     void insert(User user);
     void update(User user);
     User get(Long id);
     void  delete(Long id);
     List<User> list();

}
