package com.ax.shop.security.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
/**用来解决认证过的用户访问无权限资源时的异常-- 无权限访问--  不允许访问**/
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException, AccessDeniedException {

        response.setContentType("application/json;charset=UTF-8");
        Map map = new HashMap();
        map.put("code","400");
        map.put("msg","AccessDeniedHandler = "+accessDeniedException.getMessage());
        response.getWriter().write(JSON.toJSONString(map));
    }

}