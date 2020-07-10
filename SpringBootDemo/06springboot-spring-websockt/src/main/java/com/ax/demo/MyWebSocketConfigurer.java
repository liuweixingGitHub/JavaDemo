package com.ax.demo;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * 使用的是 org.springframework.web.socket 效内容
 */
@Configuration
@EnableWebSocket
public class MyWebSocketConfigurer implements WebSocketConfigurer {

    public MyTextWebSocketHandler textMsgHandler(){
        return new MyTextWebSocketHandler();
    }

    public MyHttpSessionHandshakeInterceptor handshakeInterceptor(){
        return new MyHttpSessionHandshakeInterceptor();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(textMsgHandler(),"/ws/**").addInterceptors(handshakeInterceptor());

    }
}
