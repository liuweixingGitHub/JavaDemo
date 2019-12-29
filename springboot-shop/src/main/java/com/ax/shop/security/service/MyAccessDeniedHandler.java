package com.ax.shop.security.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ax.shop.util.axtools.AxResultEntity;
import com.ax.shop.util.axtools.AxResultStateEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
/**用来解决认证过的用户访问无权限资源时的异常**/
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException,AccessDeniedException {

        logger.info("handle 验证失败 = "+accessDeniedException.getMessage());


        response.setContentType("application/json;charset=UTF-8");
        AxResultEntity<Object> entity = new AxResultEntity();
        entity.setStateEnum(AxResultStateEnum.INVALID_ANONYMOUS_NOT_SECURITY);
        response.getWriter().write(JSON.toJSONString(entity));
    }

}