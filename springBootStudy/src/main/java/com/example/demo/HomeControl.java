package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeControl {


    @RequestMapping(value = "/task.do")
    @Async
    public String task() throws Exception {


        long bengin  = System.currentTimeMillis();

        Task task = new Task();

        task.doTaskOne();

        Task2 task2 = new Task2();
        task2.doTaskTwo();

        Task3 task3 = new Task3();
        task3.doTaskThree();


        Thread.sleep(1000);
        long end  = System.currentTimeMillis();
        System.out.println("time = "+(end-bengin));

        return "/task.do";
    }
}
