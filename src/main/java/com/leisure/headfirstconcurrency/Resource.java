package com.leisure.headfirstconcurrency;

import com.leisure.chap4.Interrupted;

public class Resource {

    private int number = 0;
    private boolean flag = true;

    public synchronized void create() {
        if (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName() + " " + number);
        flag = true;
        notify();
    }

    public synchronized void destroy() {
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " " + number);
        flag = false;
        notify();
    }
}

class Producer implements Runnable {

    private Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException er) {
                er.printStackTrace();
            }
            resource.create();
        }
    }
}

class Consumer implements Runnable {

    private Resource resource;
    public Consumer(Resource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ProducerConsumerTest {
    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(new Producer(resource)).start();
        new Thread(new Consumer(resource)).start();
    }
}
