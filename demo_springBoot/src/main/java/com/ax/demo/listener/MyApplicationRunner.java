package com.ax.demo.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ApplicationRunner和CommandLineRunner，来实现，他们都是在SpringApplication 执行之后开始执行的。
 * CommandLineRunner接口可以用来接收字符串数组的命令行参数，
 * ApplicationRunner 是使用ApplicationArguments 用来接收参数的，貌似后者更牛逼一些。
 *
 * */

@Component//被spring容器管理
@Order(1)//如果多个自定义ApplicationRunner，用来标明执行顺序
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        System.out.println("-------------->" + "监听tomcat启动" + new Date());
        System.out.println("获取到的参数： " + applicationArguments.getOptionNames());
        System.out.println("获取到的参数： " + applicationArguments.getNonOptionArgs());
        System.out.println("获取到的参数： " + applicationArguments.getSourceArgs());

    }

}
