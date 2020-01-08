package com.ax.db.controller;

import com.ax.db.entity.db1.Userinfo;
import com.ax.db.entity.db2.Student;
import com.ax.db.mapper.db1.UserinfoMapper;
import com.ax.db.mapper.db2.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {


    @Autowired
    UserinfoMapper userinfoMapper;

    @Autowired
    StudentMapper studentMapper;

    /**
     * PageInfo 含有页面信息
     */
    @RequestMapping(value = "/home")
    public Object ipLogPageInfo() {


        Userinfo userinfo = userinfoMapper.selectByPrimaryKey(1L);

        System.out.println("userinfo = " + userinfo);

        System.out.println("studentMapper = " + studentMapper);

        
        Student student = studentMapper.selectById(1L);

        System.out.println("student = " + student);
        Map map = new HashMap();
        map.put("userinfo",userinfo);
        map.put("student",student);

        return map;
    }



}
