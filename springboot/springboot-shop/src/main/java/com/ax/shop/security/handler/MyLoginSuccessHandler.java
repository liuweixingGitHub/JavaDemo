package com.ax.shop.security.handler;

import com.alibaba.fastjson.JSON;
import com.ax.shop.entity.Userinfo;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Autowired
//    private ObjectMapper objectMapper;



    @SneakyThrows
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        logger.info("登录成功>>>>>>>>>>>>>" + authentication.getPrincipal());

        Map map = new HashMap();
        map.put("code","200");

        if (authentication.getPrincipal() instanceof Userinfo) {
          /**获取user*/
            Userinfo userinfo = (Userinfo) authentication.getPrincipal();

            map.put("body",userinfo);

            System.out.println("userinfo = " + userinfo.getToken());

        } else {
            throw new Exception("Authentication 用户类型错误");
        }
        response.setContentType("application/json;charset=UTF-8");

        response.getWriter().write(JSON.toJSONString(map));

    }
}