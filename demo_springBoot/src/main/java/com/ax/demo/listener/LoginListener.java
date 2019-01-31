package com.ax.demo.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author axing
 */
@Component
public class LoginListener  implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event){

        System.out.println("-------------->" + "监听tomcat启动" + new Date());

    }

//    @Override
//    public void onApplicationEvent(ApplicationEvent event){
//
//        System.out.println("****************监听tomcat启动成功****************");
//
//    }

}

