package com.ax.spring.util;

import com.ax.spring.domain.Userinfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

public class UserinfoContext {

    private static final String USERINFO_IN_SESSION = "userinfo";


    private   static  HttpServletRequest getRequest(){

        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static  void  putUserinfo(Userinfo userinfo){
        getRequest().getSession().setAttribute(USERINFO_IN_SESSION,userinfo);

    }

    public static  Userinfo  getCurrent(){
        return (Userinfo)  getRequest().getSession().getAttribute(USERINFO_IN_SESSION);

    }








}
