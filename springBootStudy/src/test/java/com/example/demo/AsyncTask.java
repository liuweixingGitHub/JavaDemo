package com.example.demo;

import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTask {
    private StringBuffer name = new StringBuffer("jim");

    @Async  
    public Future<String> task1() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();  
        Thread.sleep(1000);
        long currentTimeMillis1 = System.currentTimeMillis();  
        System.out.println("task1任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
        synchronized (this) {

            System.out.println("name1 = " + name);
            name.append("01");
            System.out.println("name1 = " + name);
//        synchronized (this) {
        return new AsyncResult<>("task1执行完毕"+name);
        }
    }  
      
    @Async  
    public Future<String> task2() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();  
        Thread.sleep(2000);
        long currentTimeMillis1 = System.currentTimeMillis();  
        System.out.println("task2任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
        synchronized (this) {

            System.out.println("name2 = " + name);
            name.append("02");
            System.out.println("name2 = " + name);
//        synchronized (this) {
        return new AsyncResult<>("task2执行完毕"+name);
        }
    }  
    @Async  
    public Future<String> task3() throws InterruptedException{
        long bengin = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("task3任务耗时:"+(end-bengin)+"ms");
        synchronized (this) {

            System.out.println("name3 = " + name);
             name.append("03");
            System.out.println("name3= " + name);
//        synchronized (this) {
        return new AsyncResult<>("task3执行完毕"+name);
        }
    }


    @Async
    public void doTaskOne() throws InterruptedException {

        System.out.println("tdoTaskOne");

        long bengin = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("task3任务耗时:"+(end-bengin)+"ms");


//        System.out.println("name = " + name);

    }
    @Async
    public void doTaskTwo() throws InterruptedException {
        System.out.println("doTaskTwo");
//        long currentTimeMillis = System.currentTimeMillis();
//        Thread.sleep(2000);
//        long currentTimeMillis1 = System.currentTimeMillis();
//        System.out.println("task2任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
    }
    @Async
    public void doTaskThree() throws InterruptedException {

        long currentTimeMillis = System.currentTimeMillis();
        Thread.sleep(1000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("task3任务耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms");
    }

} 