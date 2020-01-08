package com.ax.springsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ax.springsecurity.mapper")
public class OauthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthServiceApplication.class, args);
	}

}
