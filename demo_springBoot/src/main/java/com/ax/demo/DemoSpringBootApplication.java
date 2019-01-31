package com.ax.demo;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author axing
 */
@SpringBootApplication
@MapperScan("com.ax.demo.mapper")
public class DemoSpringBootApplication {

	private static ApplicationContext ctx;

	public static void main(String[] args) {

		ctx = SpringApplication.run(DemoSpringBootApplication.class, args);

		try {

			String host = InetAddress.getLocalHost().getHostAddress();
			TomcatServletWebServerFactory tomcatServletWebServerFactory= (TomcatServletWebServerFactory) ctx.getBean("tomcatServletWebServerFactory");
			int port = tomcatServletWebServerFactory.getPort(); String contextPath = tomcatServletWebServerFactory.getContextPath();

			System.out.println("\n");
			System.out.println("地址是: http://"+host+":"+port+contextPath+"/");

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters(){
		//1. 需要定义一个converter转换消息的对象
		FastJsonHttpMessageConverter fasHttpMessageConverter = new FastJsonHttpMessageConverter();

		//2. 添加fastjson的配置信息，比如:是否需要格式化返回的json的数据
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

		//3. 在converter中添加配置信息
		fasHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter converter = fasHttpMessageConverter;
		return new HttpMessageConverters(converter);
	}




}

