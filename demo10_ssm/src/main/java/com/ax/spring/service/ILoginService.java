package com.ax.spring.service;

import com.ax.spring.entity.Userinfo;
import com.ax.spring.util.AXTools.AXResultMap;

import javax.servlet.http.HttpServletRequest;

public interface ILoginService {

    Userinfo login(String username, String password, HttpServletRequest request);

    AXResultMap loginState(String username, String password, HttpServletRequest request);

    boolean hasAdmin();

    void createAdmin();

}
