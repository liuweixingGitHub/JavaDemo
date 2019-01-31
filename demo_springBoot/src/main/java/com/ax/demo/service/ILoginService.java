package com.ax.demo.service;

import com.ax.demo.entity.Userinfo;
import com.ax.demo.util.axtools.AxResultMap;

import javax.servlet.http.HttpServletRequest;
/**
 * @author axing
 */
public abstract class ILoginService {

    public abstract Userinfo login(String username, String password, HttpServletRequest request);

    public abstract AxResultMap loginState(String username, String password, HttpServletRequest request);

    public abstract boolean hasAdmin();

    public abstract void createAdmin();

}
