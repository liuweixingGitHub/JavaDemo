package com.ax.shop.security.service;

import com.alibaba.fastjson.JSON;
import com.ax.shop.context.UserinfoContext;
import com.ax.shop.entity.IpLog;
import com.ax.shop.entity.Userinfo;
import com.ax.shop.error.TokenException;
import com.ax.shop.util.axtools.AxResultEntity;
import com.ax.shop.util.axtools.AxResultStateEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
public class MyAuthenctiationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private ObjectMapper objectMapper;



    @SneakyThrows
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        logger.info("登录成功>>>>>>>>>>>>>" + authentication.getAuthorities());

        AxResultEntity<Userinfo> entity = new AxResultEntity();

        entity.setStateEnum(AxResultStateEnum.SUCCESS);

        if (authentication.getPrincipal() instanceof Userinfo) {
          /**获取user*/
            Userinfo userinfo = (Userinfo) authentication.getPrincipal();
            entity.setBody(userinfo);
        } else {
            throw new Exception("Authentication 用户类型错误");
        }
        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().write(objectMapper.writeValueAsString(entity));
        response.getWriter().write(JSON.toJSONString(entity));

    }
}