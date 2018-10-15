package com.springboot001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.*;

@SpringBootApplication
public class Springboot001Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot001Application.class, args);
        // ES
        System.out.println("Get request from TC, thread id="+Thread.currentThread().getId());
        ExecutorService ES=Executors.newCachedThreadPool();

        //task
        Callable<Integer> rmTask= new RMTask();
        Callable<Integer> cupdTask = new CUPDTask();

        //ES submit task,
        //param is callable
        //return result
        Future<Integer> rmResult=ES.submit(rmTask);
        Future<Integer> cupdResult= ES.submit(cupdTask);
        ES.shutdown();

        System.out.println("ES shutdown, thread id="+Thread.currentThread().getId());
        //ES shutdown

        try {
            Integer result = rmResult.get();
            System.out.println("process rmResult, thread id="+Thread.currentThread().getId());
            System.out.println("process rmResult="+result);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

//define task
class RMTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("creating response Rich media, thread id="+Thread.currentThread().getId());
        Thread.sleep(3000);
        System.out.println("end response Rich media, thread id="+Thread.currentThread().getId());
        return new Integer(3);
    }

}

class CUPDTask implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("creating CUPD msg, thread id="+Thread.currentThread().getId());
        Thread.sleep(8000);
        System.out.println("end response Rich media, thread id="+Thread.currentThread().getId());
        return new Integer(10);
    }
}

