package com.ax.shop.security.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ax.shop.util.axtools.AxResultEntity;
import com.ax.shop.util.axtools.AxResultStateEnum;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***用来解决匿名用户访问无权限资源时的异常**/
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        response.setContentType("application/json;charset=UTF-8");
        AxResultEntity<Object> entity = new AxResultEntity();
        entity.setStateEnum(AxResultStateEnum.INVALID_USER_NOT_SECURITY);
        response.getWriter().write(JSON.toJSONString(entity));
    }

}