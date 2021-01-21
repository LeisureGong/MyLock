package com.leisure.ibm;

public class Test2 extends Thread{

    private static int ticket = 5;
    public void run() {
        while (true) {

            System.out.println(Thread.currentThread() + "Runnable ticket = " + ticket--);
            if (ticket < 0) break;
        }
    }

    public static void main(String[] args) {
        new Test2().start();
        new Test2().start();
    }

}
