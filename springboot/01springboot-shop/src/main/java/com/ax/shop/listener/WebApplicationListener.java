package com.ax.shop.listener;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author axing
 */
@Component
public class WebApplicationListener implements ApplicationListener<WebServerInitializedEvent> {

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {

        int port = event.getWebServer().getPort();
        String dateString = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm.SSSS").format(LocalDateTime.now());

        System.out.println("\n");
        System.out.println("-------------->" + "监听tomcat启动成功 WebApplicationListener>> " + dateString + " 端口:" + port);
    }

}


@Component
 class WebApplicationListener2 implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        String dateString = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm.SSSS").format(LocalDateTime.now());
        System.out.println("\n");
        System.out.println("-------------->" + "监听tomcat启动 WebApplicationListener2>> " + dateString);

    }


}


