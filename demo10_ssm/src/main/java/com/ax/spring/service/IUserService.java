package com.ax.spring.service;

import com.ax.spring.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;



public interface IUserService {

    void add(User user);

    void update(User user);
    User get(Long id);
    void  delete(Long id);
    List<User> list();

}
