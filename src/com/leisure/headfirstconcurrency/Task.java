package com.leisure.headfirstconcurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author gonglei
 * @date 2020/4/14 9:20
 */
public class Task implements Callable<Integer> {
	@Override
	public Integer call() throws Exception{
		Thread.sleep(1000);
		return 3;
	}
	public static void main(String... args) throws ExecutionException, InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();
		FutureTask<Integer> result = new FutureTask<>(new Task());
		executor.submit(result);
		System.out.println(result.get());
	}
}
