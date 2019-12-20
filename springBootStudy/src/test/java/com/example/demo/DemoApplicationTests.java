package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
public class DemoApplicationTests {


    @Autowired
    private AsyncTask asyncTask;

	@Test
	public void task() throws InterruptedException {
//        long bengin  = System.currentTimeMillis();
        asyncTask.doTaskOne();
        asyncTask.doTaskTwo();
//        asyncTask.doTaskThree();
//        long end  = System.currentTimeMillis();
//        System.out.println("time = "+(end-bengin));

	}



    @Test
    public void doTask() throws InterruptedException , ExecutionException {
//        AsyncTask asyncTask = new AsyncTask();

        long currentTimeMillis = System.currentTimeMillis();
        Future<String> task1 = asyncTask.task1();
        Future<String> task2 = asyncTask.task2();
        Future<String> task3 = asyncTask.task3();
        String result = null;
        for (;;) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long currentTimeMillis1 = System.currentTimeMillis();
        result = "task任务总耗时:"+(currentTimeMillis1-currentTimeMillis)+"ms";

        System.out.println("result = " + result);
        System.out.println("task1 = ," +task1.get()+" task2 = ,"+task2.get()+" task3 = ,"+task3.get());
    }

}
