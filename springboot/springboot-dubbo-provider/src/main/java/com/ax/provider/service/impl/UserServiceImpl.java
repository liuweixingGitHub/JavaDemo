package com.ax.provider.service.impl;

import com.ax.dubbo.entity.User;
import com.ax.dubbo.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

//使用dubbo注解
@Service(version = "1.0.0",interfaceClass = UserService.class )
@Component
class UserServiceImpl implements UserService {

    @Override
    public String sayHi(String name) {
        return name+"提供者";
    }

    @Override
    public User getUser(long id) {
        System.out.println("id = " + id);

        User user = new User();
        user.setId(id);
        user.setName("提供者jim");
        user.setAge("10");
        System.out.println("user = " + user);

        return user;
    }
}
