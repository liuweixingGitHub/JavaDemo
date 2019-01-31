package com.ax.demo.listener;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class WebApplicationListener implements ApplicationListener<WebServerInitializedEvent> {

    @Override public void onApplicationEvent(WebServerInitializedEvent event) {
      int port = event.getWebServer().getPort();

        System.out.println("-------------->" +"端口:"+port+ "监听tomcat启动成功"+"时间:"+ new Date());
    }

}


