package com.ax;

import com.ax.spring.domain.Userinfo;
import com.ax.spring.mapper.UserinfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations ="classpath:application.xml")
public class UserinfoTest extends BaseTest{


    @Autowired
    private UserinfoMapper logininfoMapper;

    @Test
    public void getNameAndPsd(){

        Userinfo logininfo  = this.logininfoMapper.getModelByUsernameAndPassword("jim","123");

        System.out.println("logininfo = " + logininfo);
    }

    @Test
    public void getName(){
        Userinfo logininfo = this.logininfoMapper.getModelByUsername("jim");
        System.out.println("logininfo = " + logininfo);
    }


    @Test
    public void testinfo(){

        Userinfo logininfo  = new Userinfo();
        logininfo.setUsername("jim");
        logininfo.setPassword("123");

        int insert = this.logininfoMapper.insert(logininfo);
        System.out.println("insert = " + insert);
    }
}

