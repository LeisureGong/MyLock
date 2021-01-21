package com.leisure.currentbeauty;

public class YieldTest implements Runnable {
    YieldTest() {
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            if (i % 5 == 0) {
                System.out.println(Thread.currentThread() + "Yield cpu....");
//                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + " is over");
    }

    public static void main(String[] args) throws InterruptedException {
       Thread thread = new Thread(new Runnable() {
           @Override
           public void run() {
               while (!Thread.currentThread().interrupted()) {
                   System.out.println(Thread.currentThread() + " hello");
               }
           }
       });

       thread.start();
       Thread.sleep(1000);
       System.out.println("main thread interrupt thread");
       thread.interrupt();
       thread.isInterrupted();
       thread.join();
       System.out.println("main is over");
    }
}
