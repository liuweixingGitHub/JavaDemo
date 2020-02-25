package com.ax.shop.security.handler;

import com.alibaba.fastjson.JSON;
import com.ax.shop.entity.Userinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 退出成功 handler
 * @author xing
 */
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {

        logger.info("退出登陆>>>>>>>>>>>>>" + authentication.getPrincipal());

        Map map = new HashMap();
        map.put("code","200");

        if (authentication.getPrincipal() instanceof Userinfo) {
            /**获取user*/
            Userinfo userinfo = (Userinfo) authentication.getPrincipal();
            System.out.println("userinfo.getUsername() = " + userinfo);

            map.put("msg","退出登陆成功");

        } else {
            throw new IOException("Authentication 用户类型错误");
        }
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(JSON.toJSONString(map));

    }
}