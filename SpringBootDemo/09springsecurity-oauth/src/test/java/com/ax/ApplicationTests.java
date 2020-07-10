package com.ax;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@SpringBootTest
class ApplicationTests {

//	@Test
//	void contextLoads() {
//	}
public static void main(String[] args) {
	System.out.println( new BCryptPasswordEncoder().encode("123456"));
}
}
