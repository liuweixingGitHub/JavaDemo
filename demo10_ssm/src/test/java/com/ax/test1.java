package com.ax;

import com.alibaba.fastjson.JSON;
import com.ax.spring.domain.Person;
import com.ax.spring.domain.AXResult;
import com.ax.spring.domain.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class test1 {


    @Test
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


        AXResult result = new AXResult(true,list);

        result.setResult(true);
        result.setList(list);
//
        str= JSON.toJSONString(result);
//
        System.out.println(">>>"+str);
        System.out.println(">>>"+result.toJSONString());


//        System.out.println(">>>"+jsonObject.toJSONString());

    }


    @Test
    public  void test2(){
        String name = "JOM";
        System.out.println(new AXResult(true,name).toJSONString());;

    }
}
