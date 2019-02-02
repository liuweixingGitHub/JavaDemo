package com.ax.demo;

import com.ax.demo.config.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppSpringBootApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("contextLoads;>>");


//		try {
//			Yaml yaml = new Yaml();
//			URL url = Test.class.getClassLoader().getResource("application.yaml");
//			if (url != null) {
//				//获取test.yaml文件中的配置数据，然后转换为obj，
//				Object obj =yaml.load(new FileInputStream(url.getFile()));
//				System.out.println(obj);
//				//也可以将值转换为Map
//				Map map =(Map)yaml.load(new FileInputStream(url.getFile()));
//				System.out.println(map);
//				//通过map我们取值就可以了.
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}


	@Resource
	private RedisService redisUtils;

	/**
	 * 插入缓存数据
	 */
	@Test
	public void set() {
		redisUtils.set("redis_key", "redis_vale");
	}

	/**
	 * 读取缓存数据
	 */
	@Test
	public void get() {
		Object value = redisUtils.get("redis_key");
		System.out.println(value);
	}



}

