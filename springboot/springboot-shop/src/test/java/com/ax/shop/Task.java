package com.ax.shop;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
    public class Task {
      @Async
      public void doTaskOne()  throws Exception {
        Thread thread = Thread.currentThread();
       String name = thread.getName();
        long start = System.currentTimeMillis();
       Thread.sleep(20000);
      long end = System.currentTimeMillis();

        System.out.println("doTaskOne="+(end-start)+" ss"+"name = "+name);
      }
      @Async
      public void doTaskTwo() throws Exception {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        long start = System.currentTimeMillis();
        Thread.sleep(20000);
        long end = System.currentTimeMillis();

        System.out.println("doTaskTwo="+(end-start)+" ss"+"name = "+name);
      }
      @Async
      public void doTaskThree() throws Exception {
        Thread thread = Thread.currentThread();
        String name = thread.getName();
        long start = System.currentTimeMillis();
        Thread.sleep(20000);
        long end = System.currentTimeMillis();

        System.out.println("doTaskThree="+(end-start)+" ss"+"name = "+name);
      }
  }