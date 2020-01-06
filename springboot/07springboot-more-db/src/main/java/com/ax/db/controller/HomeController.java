package com.ax.db.controller;

import com.ax.db.entity.Student;
import com.ax.db.entity.Userinfo;
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
    @RequestMapping(value = "/userinfo")
    public Object ipLogPageInfo() {


        Userinfo userinfo = userinfoMapper.selectByPrimaryKey(1L);

        Student student = studentMapper.selectById(1L);

        Map map = new HashMap();
        map.put("userinfo",userinfo);
        map.put("student",student);

        return map;
    }



}
