package com.ax.method1.config;


import com.ax.method1.handler.TextMsgHandler;
import com.ax.method1.interceptor.ChatInterceptor;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

//@Configuration
//@EnableWebSocket

/**
 * 使用的是 org.springframework.web.socket 效内容
 */
public class WebSocketConfig implements WebSocketConfigurer {


    public TextMsgHandler textMsgHandler(){
        return new TextMsgHandler();
    }


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {


        webSocketHandlerRegistry.addHandler(textMsgHandler(),"chat/**").addInterceptors(new ChatInterceptor());


    }
}
