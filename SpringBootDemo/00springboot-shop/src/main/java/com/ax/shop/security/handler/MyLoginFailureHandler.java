package com.ax.shop.security.handler;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
 
  private Logger logger = LoggerFactory.getLogger(getClass());
 
//  @Autowired
//  private ObjectMapper objectMapper;
 
  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                      AuthenticationException exception) throws IOException, ServletException {
 
    logger.info("登录失败"+exception.getMessage());
    response.setContentType("application/json;charset=UTF-8");

    Map map = new HashMap();
    map.put("code","400");
    map.put("msg","AuthenticationFailureHandler = "+exception.getMessage());

    response.getWriter().write(JSON.toJSONString(map));

  }
}