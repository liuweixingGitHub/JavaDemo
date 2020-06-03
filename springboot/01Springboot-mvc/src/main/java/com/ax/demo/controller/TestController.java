package com.ax.demo.controller;

import com.ax.demo.entity.Student;

public class TestController {

    public void init(){


        Student student = new Student(1,"jim");


        Student.builder().id(1).name("jim");


    }
}
