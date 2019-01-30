package com.ax.demo.service;

import com.ax.demo.entity.Userinfo;
import com.ax.demo.util.axtools.AXResultMap;

import javax.servlet.http.HttpServletRequest;

public interface ILoginService {

    Userinfo login(String username, String password, HttpServletRequest request);

    AXResultMap loginState(String username, String password, HttpServletRequest request);

    boolean hasAdmin();

    void createAdmin();

}
