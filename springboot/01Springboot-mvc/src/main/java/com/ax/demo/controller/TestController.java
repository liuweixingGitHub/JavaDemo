package com.ax.demo.controller;

import com.ax.demo.dto.StudentDto;
import com.ax.demo.entity.Student;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class TestController {

    @PostMapping(value = "/test0", produces = "application/json;charset=UTF-8")
    public Object test(@RequestBody StudentDto studentDto) {
        Map<String, Object> map = new HashMap<>();

        map.put("date", studentDto);

        return map;
    }

    /**
     * @RequestBody能把简单json结构参数转换成实体类，
     */
    @RequestMapping(value = "/test1")
    public Map<String, Object> test1(@RequestBody @Validated StudentDto studentDto) {
        System.out.println("studentDto = " + studentDto);
        Map<String, Object> map = new HashMap<>();

        map.put("date", studentDto);

        return map;
    }

    @RequestMapping(value = "/test2")
    public Object test2(StudentDto studentDto) {
        System.out.println("studentDto2 = " + studentDto);
        Map<String, Object> map = new HashMap<>();

        map.put("date", studentDto);

        return map;
    }

    public void init() {


        Student student = new Student(1, "jim");


        Student.builder().id(1).name("jim");


    }


    @RequestMapping(value = "/list")
    public void listParam(@RequestBody List<String> list, String name) {

        System.out.println("list = " + list);
        System.out.println("name = " + name);
    }

}
