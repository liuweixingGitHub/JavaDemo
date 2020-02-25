package com.ax.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author axing
 */

/**
 * 打包 war 必须改继承 SpringBootServletInitializer
 * 同时用springboot 打包插件
 * */

@SpringBootApplication
@MapperScan("com.ax.shop.mapper")
@EnableTransactionManagement
@EnableSwagger2             //启动swagger注解
//@EnableWebMvc
public class ShopSpringBootApplication extends SpringBootServletInitializer {

	private static ApplicationContext applicationContext;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		applicationContext = builder.context();
		hostAndContextPath(applicationContext);
		return builder.sources(ShopSpringBootApplication.class);
	}


	public static void main(String[] args) {

		applicationContext = SpringApplication.run(ShopSpringBootApplication.class, args);
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

            System.out.println("swagger地址是: http://"+"localhost:"+port+contextPath+"/swagger-ui.html");


		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

}

