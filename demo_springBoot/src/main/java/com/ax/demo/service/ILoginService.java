package com.ax.demo.service;

import com.ax.demo.entity.Userinfo;
import com.ax.demo.util.axtools.AxResultMap;

import javax.servlet.http.HttpServletRequest;
/**
 * @author axing
 */
public interface ILoginService {

    Userinfo login(String userName, String passWord, HttpServletRequest request);

     AxResultMap loginState(String userName, String passWord, HttpServletRequest request);

    boolean hasAdmin();

    void createAdmin();

}
