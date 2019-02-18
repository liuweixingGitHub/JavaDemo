package com.ax.study.all.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author axing
 */
@Component
public class LoginListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm.SSSS");
        String dateString = dateTimeFormatter.format(LocalDateTime.now());
//        System.out.println("-------------->" + "监听tomcat启动" + new Date());
        System.out.println("-------------->" + "监听tomcat启动>> " + dateString);

    }

//    @Override
//    public void onApplicationEvent(ApplicationEvent event){
//
//        System.out.println("****************监听tomcat启动成功****************");
//
//    }

}

