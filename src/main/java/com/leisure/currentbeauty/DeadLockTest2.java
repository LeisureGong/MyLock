package com.leisure.currentbeauty;

public class DeadLockTest2 {

    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        daemonThread.setDaemon(true);
        daemonThread.start();
        daemonThread.sleep(10000);
    }
}
