package com.ax.shop.service;

import com.ax.shop.entity.Userinfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @author axing
 */
public interface ILoginService {

    Userinfo login(String username, String password, HttpServletRequest request);

//    Userinfo login(String username, String password);

    Object loginState(String username, String password, HttpServletRequest request);

    boolean hasAdmin();

    void createAdmin();

    Userinfo getByUserName(String username);

    Userinfo getById(Long id);
}
