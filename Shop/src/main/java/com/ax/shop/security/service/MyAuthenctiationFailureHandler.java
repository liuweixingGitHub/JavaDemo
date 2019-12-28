package com.ax.shop.security.service;

import com.alibaba.fastjson.JSON;
import com.ax.shop.entity.Userinfo;
import com.ax.shop.util.axtools.AxResultEntity;
import com.ax.shop.util.axtools.AxResultStateEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenctiationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
 
  private Logger logger = LoggerFactory.getLogger(getClass());
 
//  @Autowired
//  private ObjectMapper objectMapper;
 
  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                      AuthenticationException exception) throws IOException, ServletException {
 
    logger.info("登录失败"+exception.getMessage());
    response.setContentType("application/json;charset=UTF-8");
    AxResultEntity<Object> entity = new AxResultEntity();
    entity.setStateEnum(AxResultStateEnum.INVALID_LOGIN_PASSWORD_WRONG);

//    response.getWriter().write(objectMapper.writeValueAsString(entity));
    response.getWriter().write(JSON.toJSONString(entity));

  }
}