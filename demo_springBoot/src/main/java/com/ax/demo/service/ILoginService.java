package com.ax.demo.service;

import com.ax.demo.entity.Userinfo;
import com.ax.demo.util.axtools.AxResultMap;

import javax.servlet.http.HttpServletRequest;
/**
 * @author axing
 */
public interface ILoginService {

    Userinfo login(String username, String password, HttpServletRequest request);

     AxResultMap loginState(String username, String password, HttpServletRequest request);

    boolean hasAdmin();

    void createAdmin();

}
