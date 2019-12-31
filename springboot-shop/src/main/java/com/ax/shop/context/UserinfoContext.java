package com.ax.shop.context;

import com.ax.shop.entity.Userinfo;
import com.ax.shop.util.axUtil.AxConst;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author axing
 */
public class UserinfoContext {

    private static HttpServletRequest getRequest(){

        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static  void  putUserinfo(Userinfo userinfo){
        getRequest().getSession().setAttribute(AxConst.USERINFO_IN_SESSION,userinfo);

    }

    public static  Userinfo  getCurrent(){
        return (Userinfo)  getRequest().getSession().getAttribute(AxConst.USERINFO_IN_SESSION);

    }



}
