package com.ax.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDubboConfig
//@EnableAutoConfiguration
public class SpringbootDubboProviderApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringbootDubboProviderApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDubboProviderApplication.class, args);
		logger.info("项目启动");
	}

}
