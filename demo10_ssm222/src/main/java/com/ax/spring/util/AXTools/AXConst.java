package com.ax.spring.util.AXTools;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class AXConst {

    public static final String ADMIN_NAME = "admin";

    public static final String ADMIN_PASSWORD = "123456";


    public static HttpServletRequest getRequest(){

        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

}
