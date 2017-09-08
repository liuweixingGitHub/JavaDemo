package com.ax.spring.service;

import com.ax.spring.domain.Userinfo;

public interface ILoginService {

    Userinfo login(String username, String password);
}
