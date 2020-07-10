package com.ax.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		try {
			System.out.println("http://127.0.0.1:8083/ws/index");
			new NettyServer(12345).start();
		}catch(Exception e) {
			System.out.println("NettyServerError:"+e.getMessage());
		}
	}

}
