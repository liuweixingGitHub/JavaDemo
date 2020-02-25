package com.ax.dubbo.service;

import com.ax.dubbo.entity.User;

public interface UserService {

    String sayHi(String name);

    User getUser(long id);


}
