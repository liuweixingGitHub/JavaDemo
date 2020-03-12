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
public class ChatInterceptor extends HttpSessionHandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        //为了区分连接,通过名字区分,获取用户名字

        HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
        String id = servletRequest.getSession().getId();
        System.out.println("id = " + id);


        System.out.println("开始握手=====================" + request.getURI());
        String url = request.getURI().toString();


//        String userid = url.substring(url.lastIndexOf("/") + 1);
//
//        System.out.println("userid = " + userid);
        /**给当前连接设置名字*/

//        attributes.put("userid", Long.valueOf(userid));

        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {

        /**握手之后*/

        System.out.println("握手之后=====================" + request.getURI());

    }
}
