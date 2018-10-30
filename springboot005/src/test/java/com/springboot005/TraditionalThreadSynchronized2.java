package com.springboot005;

import java.util.Date;

public class TraditionalThreadSynchronized2
{
   public  static  void  main(String[] args) throws InterruptedException {
       Demo1 demo1=new Demo1();
       //子线程执行
       new Thread(new Runnable() {
           @Override
           public void run() {
                for (int i=0;i<50;i++){
                    try {
                        demo1.childMethod();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
           }
       }).start();
       //主线程执行
       for (int i=1;i<=50;i++){
           demo1.mainMethod();
       }
   }
}
class  Demo1{
    private boolean mainIsrunning;
    //子线程方法
    public  synchronized void childMethod() throws InterruptedException {
        if(mainIsrunning){//判断主线程是否运行,运行就等待
            this.wait();
        }
        for (int i=1;i<=10;i++){
            System.out.println("child"+new Date() );
        }
        mainIsrunning=true;
        this.notify();//唤醒主线程
    }
    //主线程执行方法
    public synchronized void  mainMethod() throws InterruptedException {
        if(!mainIsrunning){//判断主线程运行状态
            this.wait();
        }
        for (int i=1;i<=100;i++){
            Date date=new Date();
            System.out.println("main "+date +" "+i);
        }
        mainIsrunning=false;
        this.notify();//唤醒子线程
    }
}
