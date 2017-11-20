package com.ax.spring.service;

import com.ax.spring.entity.Userinfo;

import javax.servlet.http.HttpServletRequest;

public interface ILoginService {

    Userinfo login(String username, String password, HttpServletRequest request);

    boolean hasAdmin();

    void createAdmin();

}
