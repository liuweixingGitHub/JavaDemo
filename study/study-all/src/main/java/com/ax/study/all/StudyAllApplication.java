package com.ax.study.all;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author axing
 */

/**开启缓存功能*/
@EnableCaching
@MapperScan("com.ax.demo.mapper")
@SpringBootApplication
public class StudyAllApplication extends SpringBootServletInitializer {

	private static ApplicationContext ctx;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

		ctx = builder.context();

		try {

			String host = InetAddress.getLocalHost().getHostAddress();
			TomcatServletWebServerFactory tomcatServletWebServerFactory= (TomcatServletWebServerFactory) ctx.getBean("tomcatServletWebServerFactory");
			int port = tomcatServletWebServerFactory.getPort(); String contextPath = tomcatServletWebServerFactory.getContextPath();

			System.out.println("\n");
			System.out.println("地址是:2 http://"+host+":"+port+contextPath+"/");
			System.out.println("地址是2: http://"+"localhost:"+port+contextPath+"/");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return builder.sources(StudyAllApplication.class);
	}


	public static void main(String[] args) {

		ctx = SpringApplication.run(StudyAllApplication.class, args);

		try {

			String host = InetAddress.getLocalHost().getHostAddress();
			TomcatServletWebServerFactory tomcatServletWebServerFactory= (TomcatServletWebServerFactory) ctx.getBean("tomcatServletWebServerFactory");
			int port = tomcatServletWebServerFactory.getPort(); String contextPath = tomcatServletWebServerFactory.getContextPath();

			System.out.println("\n");

			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss:mm.SSSS");
			String dateString = dateTimeFormatter.format(LocalDateTime.now());
			System.out.println("-------------->" + "监听tomcat启动>> " + dateString);

			System.out.println("地址是: http://"+host+":"+port+contextPath+"/");
			System.out.println("地址是: http://"+"localhost:"+port+contextPath+"/");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

//	@Bean
//	public HttpMessageConverters fastJsonHttpMessageConverters(){
//		//1. 需要定义一个converter转换消息的对象
//		FastJsonHttpMessageConverter fasHttpMessageConverter = new FastJsonHttpMessageConverter();
//
//		//2. 添加fastjson的配置信息，比如:是否需要格式化返回的json的数据
//		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
//
//		//3. 在converter中添加配置信息
//		fasHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//		HttpMessageConverter converter = fasHttpMessageConverter;
//		return new HttpMessageConverters(converter);
//	}

}

