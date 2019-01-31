package com.ax.demo.util.axtools;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author axing
 */
public class AxConst {
    /**
     *
     */
    public static final String ADMIN_NAME = "admin";

    /**
     *
     */
    public static final String ADMIN_PASSWORD = "123456";

    /**
     *
     */
    public static final String USERINFO_IN_SESSION = "USERINFO_IN_SESSION";

    /**
     *
     * @return
     */
    public static HttpServletRequest getRequest(){

        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

}
