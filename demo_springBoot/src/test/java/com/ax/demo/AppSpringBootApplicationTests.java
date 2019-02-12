package com.ax.demo;

import com.ax.demo.config.RedisService;
import com.ax.demo.entity.IpLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppSpringBootApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("contextLoads;>>");

		LocalDateTime dateTime = LocalDateTime.now();

		System.out.println("dateTime = " + dateTime);

		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("zonedDateTime = " + zonedDateTime);

		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println("zoneId = " + zoneId);

		ZonedDateTime zonedDateTime1 = dateTime.atZone(zoneId);

		System.out.println("zonedDateTime1 = " + zonedDateTime1);

		Date date  = new Date();
		System.out.println("date = " + date);


		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime time = LocalDateTime.now();
		String localTime = df.format(time);
		String localTime2 =df.format(zonedDateTime);

		System.out.println("localTime = " + localTime);
		System.out.println("localTime2 = " + localTime2);



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
		IpLog ipLog = new IpLog();
		ipLog.setId((long) 88);
		ipLog.setUserName("jim");

		redisUtils.set("ipLog:redis_key1", ipLog);
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

