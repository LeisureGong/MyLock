package com.leisure.sevenmodels.week1;

public class HelloWorld {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i ++ ) {
            Thread myThread = new Thread(){
                public void run() {
                    System.out.println("Hello from new thread");
                }
            };
            myThread.start();
            // 暂停当前线程，让出时间片
//            Thread.yield();
            Thread.sleep(1);
            System.out.println("Hello from main thread");
            myThread.join();
            System.out.println("-----------------\n");
        }

    }
}
