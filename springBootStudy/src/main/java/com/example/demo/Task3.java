package com.example.demo;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class Task3 {
    public String name = "jim";

    @Async
    public void doTaskOne() throws Exception {

//        System.out.println("doTaskOne"+name);

        Thread thread = Thread.currentThread();
        thread.getName();
      long bengin  = System.currentTimeMillis();

        Thread.sleep(3000);
        long end  = System.currentTimeMillis();
        System.out.println("doTaskOne"+"thread.getName() = " + thread.getName()+"time = "+(end-bengin));
//        name = name+"01";
//        System.out.println("doTaskOne"+name);

    }
    @Async
    public void doTaskTwo() throws Exception {

//        System.out.println("doTaskTwo"+name);
        Thread thread = Thread.currentThread();
        thread.getName();
        long bengin  = System.currentTimeMillis();

        Thread.sleep(2000);
        long end  = System.currentTimeMillis();
        System.out.println("doTaskTwo"+"thread.getName() = " + thread.getName()+"time = "+(end-bengin));
//        name = name+"02";
//        System.out.println("doTaskTwo"+name);
    }
    @Async
    public void doTaskThree() throws Exception {

//        System.out.println("doTaskThree"+name);
        Thread thread = Thread.currentThread();
        thread.getName();
        long bengin  = System.currentTimeMillis();

        Thread.sleep(1000);
        long end  = System.currentTimeMillis();
        System.out.println("doTaskThree"+"thread.getName() = " + thread.getName()+"time = "+(end-bengin));
//        name = name+"03";
//        System.out.println("doTaskThree"+name);
    }
}