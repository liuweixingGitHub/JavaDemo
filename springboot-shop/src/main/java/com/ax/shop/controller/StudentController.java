package com.ax.shop.controller;

import com.ax.shop.entity.Student;
import com.ax.shop.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author xing
 */
@RestController
public class StudentController {


    @Autowired
    private  StudentMapper studentMapper;


    @RequestMapping(value = "/student.do")
    public void insetStudent(){

        int number = ThreadLocalRandom.current().nextInt(100);
        
        Student student = new Student();
        student.setName("jim"+ number);
        studentMapper.insertStudent(student);


    }

    @RequestMapping(value = "/students.do")
    public void insetStudents(){
        List list = new ArrayList();

        {

            Student student = new Student();
            student.setName("jim"+ ThreadLocalRandom.current().nextInt(100));
            list.add(student);
        }
        {

            Student student = new Student();
            student.setName("jim"+ ThreadLocalRandom.current().nextInt(100));
            list.add(student);
        }
        {

            Student student = new Student();
            student.setName("jim"+ ThreadLocalRandom.current().nextInt(100));
            list.add(student);
        }
        studentMapper.inserList(list);
    }


    @RequestMapping(value = "/selectStudent.do")
    @Cacheable(value = "student")
    public List<Student> select(){

      List<Student> list =   studentMapper.selectAll();

        System.out.println("list = " + list);
        return list;
    }

}
