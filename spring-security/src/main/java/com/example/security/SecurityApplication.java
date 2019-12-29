package com.example.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class SecurityApplication extends SpringBootServletInitializer {

    private static ApplicationContext applicationContext;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        applicationContext = builder.context();
        hostAndContextPath(applicationContext);
        return builder.sources(SecurityApplication.class);
    }


    public static void main(String[] args) {

        applicationContext = SpringApplication.run(SecurityApplication.class, args);
        hostAndContextPath(applicationContext);

    }


    static void hostAndContextPath(ApplicationContext applicationContext) {

        try {

            String host = InetAddress.getLocalHost().getHostAddress();
            TomcatServletWebServerFactory tomcatServletWebServerFactory= (TomcatServletWebServerFactory) applicationContext.getBean("tomcatServletWebServerFactory");
            int port = tomcatServletWebServerFactory.getPort();
            String contextPath = tomcatServletWebServerFactory.getContextPath();



            String dateString = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm.SSSS").format(LocalDateTime.now());;

            System.out.println("\n");
            System.out.println("-------------->" + "监听tomcat启动 hostAndContextPath>> " + dateString);

            System.out.println("地址是: http://"+host+":"+port+contextPath+"/");
            System.out.println("地址是: http://"+"localhost:"+port+contextPath+"/");



        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

}



//public class SecurityApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(SecurityApplication.class, args);
//    }
//
//}
