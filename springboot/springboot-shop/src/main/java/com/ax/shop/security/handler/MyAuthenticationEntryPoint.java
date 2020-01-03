package com.ax.shop.security.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/***用来解决匿名用户访问无权限资源时的异常 访问此资源需要完全的身份验证
 * 拦截了login 重定向
 * **/
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {

        response.setContentType("application/json;charset=UTF-8");
        Map map = new HashMap();
        map.put("code","400");
        map.put("msg","AuthenticationEntryPoint = "+authException.getMessage());
        response.getWriter().write(JSON.toJSONString(map));
    }

}