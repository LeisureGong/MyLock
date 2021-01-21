package com.leisure.currentbeauty.text;

public class Demo2 extends Thread {
    public static void main(String[] args) {
        Thread testThread = new Thread(() -> {
            System.out.println("testThread当前线程组名：" + Thread.currentThread().getThreadGroup().getName());
            System.out.println("hah" + Thread.currentThread().getName());
        });
        testThread.start();
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getName());
    }
}
