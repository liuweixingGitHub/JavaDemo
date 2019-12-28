package com.ax.shop.service;

import com.ax.shop.entity.Userinfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @author axing
 */
public interface ILoginService {

    Userinfo login(String userName, String passWord, HttpServletRequest request);

//    Userinfo login(String userName, String passWord);

    Object loginState(String userName, String passWord, HttpServletRequest request);

    boolean hasAdmin();

    void createAdmin();

    Userinfo getByUserName(String userName);

}
