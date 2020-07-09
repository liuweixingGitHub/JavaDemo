package com.ax.shop;

import com.ax.shop.service.impl.RedisService;
import com.ax.shop.entity.IpLog;
import com.ax.shop.mapper.IpLogMapper;
import com.ax.shop.util.axUtil.AxResultStateEnum;
import com.ax.shop.util.axUtil.AxResultEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
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
//		IpLog ipLog = new IpLog();
//		ipLog.setId((long) 88);
//		ipLog.setUsername("jim");
//
//		redisUtils.set("ipLog:redis_key1", ipLog);
		AxResultEntity responseEntity =new AxResultEntity();
		responseEntity.setStateEnum(AxResultStateEnum.SUCCESS);
		System.out.println("responseEntity = " + responseEntity);
		System.out.println("responseEntity = " + responseEntity.toString());
	}

	/**
	 * 读取缓存数据
	 */
	@Test
	public void get() {
		Object value = redisUtils.get("redis_key");
		System.out.println(value);
	}


	@Autowired
	IpLogMapper ipLogMapper;

	@Test
	public void deleteByIdList() {

		List list = new ArrayList();
		list.add(94);



		int result	= ipLogMapper.deleteByIdList(list);

		System.out.println("result = " + result);
	}

	@Test
	public void insertList() {

		List list = new ArrayList();

		IpLog ipLog1 = new IpLog();

		ipLog1.setUsername("jim1");


		list.add(ipLog1);

		IpLog ipLog2 = new IpLog();
		ipLog2.setUsername("jim2");

		list.add(ipLog2);


		int result	= ipLogMapper.insertList(list);

		System.out.println("result = " + result);
	}


	@Test
	public void updateByList() {

		List list = new ArrayList();

		IpLog ipLog1 = ipLogMapper.selectByPrimaryKey(88L);

		ipLog1.setUsername("jim11");

		list.add(ipLog1);

		IpLog ipLog2 = ipLogMapper.selectByPrimaryKey(89L);;
		ipLog2.setUsername("jim22");

		list.add(ipLog2);


		int result	= ipLogMapper.updateByListWhen(list);


//		int result	=ipLogMapper.updateByPrimaryKey(ipLog1);

		System.out.println("result = " + result);
	}



	/**
	 * 读取缓存数据
	 */
	@Test
	public void person() {
		Person person = new Person();
		person.setName("jim");



		System.out.println("person = " + person);
	}

	@Test
	public void test110(){

		Student stuA = new Student(1, "A", "M", 184);
		Student stuB = new Student(2, "B", "G", 163);
		Student stuC = new Student(3, "C", "M", 175);
		Student stuD = new Student(4, "D", "G", 158);
		Student stuE = new Student(5, "E", "M", 170);
		List<Student> list = new ArrayList<>();
		list.add(stuA);
		list.add(stuB);
		list.add(stuC);
		list.add(stuD);
		list.add(stuE);


		list.stream()
				.filter(student -> student.getSex().equals("G"))
				.forEach(student -> System.out.println(">>>"+student.toString()));
	}

	@Test
	public void Task2() throws Exception{

		Task task = new Task();
		task.doTaskOne();
		task.doTaskTwo();
		task.doTaskThree();

	}




}

