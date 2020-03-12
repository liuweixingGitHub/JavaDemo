package com.ax.demo;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket

/**
 * 使用的是 org.springframework.web.socket 效内容
 */
public class WebSocketConfig implements WebSocketConfigurer {

    public TextMsgHandler textMsgHandler(){
        return new TextMsgHandler();
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(textMsgHandler(),"/ws/**").addInterceptors(new ChatInterceptor());

    }
}
