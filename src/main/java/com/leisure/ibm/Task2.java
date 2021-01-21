package com.leisure.ibm;

public class Task2 {

    public synchronized static void doLongTimeTaskA() {
        System.out.println("name = " + Thread.currentThread().getName() + ", began" + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end" + System.currentTimeMillis());
    }

    public synchronized static void doLongTimeTaskB() {
        System.out.println("name = " + Thread.currentThread().getName() + ", began" + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end" + System.currentTimeMillis());
    }

    public synchronized void doLongTimeTaskC() {
        System.out.println("name = " + Thread.currentThread().getName() + ", began" + System.currentTimeMillis());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name = " + Thread.currentThread().getName() + ", end" + System.currentTimeMillis());
    }

    public static void main(String[] args) {
        Task2 mTask2 = new Task2();
        ThreadA ta = new ThreadA(mTask2);
        ThreadB tb = new ThreadB(mTask2);
        ta.setName("A");
        tb.setName("B");


        ta.start();
        tb.start();


    }

}

class ThreadA extends Thread {

    private Task2 mTask2;

    public ThreadA(Task2 tk) {
        mTask2 = tk;
    }

    public void run() {
        mTask2.doLongTimeTaskA();
    }
}

class ThreadB extends Thread {

    private Task2 mTask2;

    public ThreadB(Task2 tk) {
        mTask2 = tk;
    }

    public void run() {
        mTask2.doLongTimeTaskC();
    }
}

class ThreadC extends Thread {
    private Task2 mTask2;

    public ThreadC(Task2 tk) {
        mTask2 = tk;
    }

    public void run() {
        mTask2.doLongTimeTaskC();
    }
}
