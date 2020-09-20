package com.ax.demo.controller;

import com.ax.demo.dto.StudentDto;
import com.ax.demo.entity.Student;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class TestController {

    @RequestMapping(value = "/test0", produces = "application/json;charset=UTF-8")
    public Object test(@RequestBody StudentDto studentDto) {
        System.out.println("studentDto = " + studentDto);
        Map<String, Object> map = new HashMap<>();

        map.put("date", studentDto);

        return map;
    }

    /**
     * @RequestBody能把简单json结构参数转换成实体类，
     */
    @RequestMapping(value = "/test1")
    public Map<String, Object> test1(@RequestBody @Validated StudentDto studentDto,
                                     @RequestHeader Map header) {
        System.out.println("studentDto = " + studentDto);
        System.out.println("header = " + header);
        Map<String, Object> map = new HashMap<>();

        map.put("date", studentDto);

        return map;
    }

    @RequestMapping(value = "/test2")
    @ResponseBody
    public Object test2(@RequestHeader(name = "token") String token,
                        @RequestHeader Object id,
                        StudentDto studentDto) {
        System.out.println("studentDto2 = " + studentDto);
        System.out.println("token = " + token);
        System.out.println("id = " + id);
        Map<String, Object> map = new HashMap<>();

        map.put("date", studentDto);

        return map;
    }

    @RequestMapping(value = "/test21")
    @ResponseBody
    public Map<String, Object> test2_1(String name, Integer age, @RequestHeader Map header) {
        StudentDto studentDto = new StudentDto();
        studentDto.setName(name);
        studentDto.setAge(age);
        System.out.println("studentDto = " + studentDto);
        System.out.println("header = " + header);

        Map<String, Object> map = new HashMap<>();
        map.put("date", studentDto);
        return map;
    }

    @RequestMapping(value = "/test22")
    @ResponseBody
    public Map<String, Object> test22(@RequestBody StudentDto studentDto, @RequestHeader Map header) {

        System.out.println("studentDto = " + studentDto);
        System.out.println("header = " + header);

        Map<String, Object> map = new HashMap<>();
        map.put("date", studentDto);
        return map;
    }

    @RequestMapping(value = "/test3")
    public Object test3(@RequestBody List<String> list) {
        return list;
    }

    @RequestMapping(value = "/test4",produces = {"application/json;charset=UTF-8"})
    public Object test4() {
        return "test4";
    }

    @RequestMapping(value = "/test5")
    public Object test5() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", "test5");
        return map;
    }

    public void init() {


        Student student = new Student(1, "jim");


        Student.builder().id(1).name("jim");


    }


}
