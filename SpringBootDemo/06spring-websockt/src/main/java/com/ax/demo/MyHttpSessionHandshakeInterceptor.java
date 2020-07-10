package com.ax.demo;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 握手请求拦截器
 * 检查握手请求和相应的属性,用于区别
 */
public class MyHttpSessionHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        //为了区分连接,通过名字区分,获取用户名字

        HttpServletRequest servletRequest = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest();

        String id = servletRequest.getSession().getId();
        System.out.println("id = " + id);


        System.out.println("开始握手=====================" + serverHttpRequest.getURI());
        String url = serverHttpRequest.getURI().toString();
        System.out.println("url = " + url);

        String type = servletRequest.getParameter("id");
        System.out.println("type = " + type);

        String name = servletRequest.getParameter("name");
        System.out.println("name = " + name);


        System.out.println(servletRequest.getContextPath());// /wkwm
        System.out.println(servletRequest.getPathInfo());// null
        System.out.println(servletRequest.getPathTranslated());// null
        System.out.println(servletRequest.getQueryString()); // custNo=001&authType=2
        System.out.println(servletRequest.getRequestURI());// /wkwm/wx/auth/view
        System.out.println(servletRequest.getRequestURL().toString());// http://192.168.2.78/wkwm/wx/auth/view
        System.out.println(servletRequest.getServletPath());// /wx/auth/view


//        String userid = url.substring(url.lastIndexOf("/") + 1);
//
//        System.out.println("userid = " + userid);
        /**给当前连接设置名字*/

//        attributes.put("userid", Long.valueOf(userid));

        return super.beforeHandshake(serverHttpRequest, response, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {

        /**握手之后*/

        System.out.println("握手之后=====================" + request.getURI());

    }
}
