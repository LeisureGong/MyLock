package com.leisure.currentbeauty.text;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(10000);
        return 2;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        System.out.println(result.get());
        executor.shutdown();
    }
}
