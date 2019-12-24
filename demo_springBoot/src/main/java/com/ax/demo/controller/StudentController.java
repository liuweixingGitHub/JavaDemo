package com.ax.demo.controller;

import com.ax.demo.entity.Student;
import com.ax.demo.mapper.StudentMapper;
import com.ax.demo.service.impl.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class StudentController {


    @Autowired
    private  StudentMapper studentMapper;


    @RequestMapping(value = "/student.do")
    public void insetStudent(){
        Student student = new Student();
        student.setName("jim"+ new Random(1).nextInt(100));
        studentMapper.insertStudent(student);


    }

    @RequestMapping(value = "/students.do")
    public void insetStudents(){
        List list = new ArrayList();

        {

            Student student = new Student();
            student.setName("jim"+ new Random(1).nextInt(100));
            list.add(student);
        }
        {

            Student student = new Student();
            student.setName("jim"+ new Random(1).nextInt(100));
            list.add(student);
        }
        {

            Student student = new Student();
            student.setName("jim"+ new Random(1).nextInt(100));
            list.add(student);
        }
        studentMapper.inserList(list);
    }


    @RequestMapping(value = "/selectStudent.do")
    @Cacheable(value = "student")
    public List select(){

      List<Student> list =   studentMapper.selectAll();

        System.out.println("list = " + list);
        return list;
    }

}
