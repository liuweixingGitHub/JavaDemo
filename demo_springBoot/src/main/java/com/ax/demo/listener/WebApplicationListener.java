package com.ax.demo.listener;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
/**
 * @author axing
 */
@Component
public class WebApplicationListener implements ApplicationListener<WebServerInitializedEvent> {

    @Override public void onApplicationEvent(WebServerInitializedEvent event) {
      int port = event.getWebServer().getPort();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm.SSSS");
        String dateString = dateTimeFormatter.format(LocalDateTime.now());

        System.out.println("-------------->"+ "监听tomcat启动成功>> "+ dateString +" 端口:"+port);
    }

}


