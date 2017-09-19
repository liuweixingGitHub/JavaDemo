package com.ax.spring.context;

import com.ax.spring.domain.Userinfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UserinfoContext {

    public static final String USERINFO_IN_SESSION = "USERINFO_IN_SESSION";


    private static  HttpServletRequest getRequest(){

        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static  void  putUserinfo(Userinfo userinfo){
        getRequest().getSession().setAttribute(USERINFO_IN_SESSION,userinfo);

    }

    public static  Userinfo  getCurrent(){
        return (Userinfo)  getRequest().getSession().getAttribute(USERINFO_IN_SESSION);

    }



}
