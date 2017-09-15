package com.ax;

import com.alibaba.fastjson.JSON;
import com.ax.spring.domain.Person;
import com.ax.spring.mapper.UserinfoMapper;
import com.ax.spring.util.AXTools.AXResult;
import com.ax.spring.domain.User;
import com.ax.spring.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:application.xml")
public class test1 {

    @Autowired
    private UserinfoMapper logininfoMapper;

    @Autowired
    private IUserService userService;

    @Test
    public void testU(){
//        User user = new User();
//        user.setAge(18);
//        user.setName("中文jim2");
//        userService.add(user);

        User user = userService.get(1L);

        List list = new ArrayList();
        list.add(user);

//        return  new AXResult(true,list).toJSONString();
        System.out.println( AXResult.errorMsg("代码"));
        System.out.println( AXResult.errorMsg(null));

        System.out.println( ">>"+AXResult.succeeList(null));
        System.out.println( ">>"+AXResult.succeeList(list));



    }

    public void test(){

        System.out.println("test");

        String str=null;

        List list = new ArrayList();

        Person person = new Person();
        person.setAge(10);
        person.setName("ppp");

        User user1 = new User();
        user1.setAge(11);
        user1.setName("name11");

        User user2 = new User();
        user2.setAge(12);
        user2.setName("name12");

        person.getList1().add(user1);
        person.getList1().add(user2);




        User user3 = new User();
        user3.setAge(13);
        user3.setName("name14");
        person.setUser2(user3);

        list.add(person);



//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("list",list);
//
//
//        Map map = new HashMap();
//        map.put("lit",list);


        AXResult result = new AXResult();

        result.setResult(true);
        result.setList(list);
//
        str= JSON.toJSONString(result);
//
        System.out.println(">>>"+str);
        System.out.println(">>>"+result.toJSONString());


//        System.out.println(">>>"+jsonObject.toJSONString());

    }



    public  void test2(){
//        String name = "JOM";
//        System.out.println(new AXResult(true,name).toJSONString());;

    }
}
