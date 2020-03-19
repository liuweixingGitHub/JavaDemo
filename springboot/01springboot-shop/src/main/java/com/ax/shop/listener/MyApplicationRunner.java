package com.ax.shop.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * ApplicationRunner和CommandLineRunner，来实现，他们都是在SpringApplication 执行之后开始执行的。
 * CommandLineRunner接口可以用来接收字符串数组的命令行参数，
 * ApplicationRunner 是使用ApplicationArguments 用来接收参数的，貌似后者更牛逼一些。
 */

@Component
@Order(1)
/**如果多个自定义ApplicationRunner，用来标明执行顺序*/
/**
 * @author axing
 */
public class MyApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        String dateString = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm.SSSS").format(LocalDateTime.now());

        System.out.println("\n");
        System.out.println("-------------->" + "监听Springboot启动>> " + dateString);
        System.out.println("获取到的参数： " + applicationArguments.getOptionNames());
        System.out.println("获取到的参数： " + applicationArguments.getNonOptionArgs());
        System.out.println("获取到的参数： " + applicationArguments.getSourceArgs());

    }

}
