package com.leisure.headfirstconcurrency;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author gonglei
 * @date 2020/4/14 8:58
 */
public class Demo1 {
	public static class MyThread implements Runnable{
		@Override
		public void run(){
			System.out.println("MyThread1");
		}
	}

	public static void main(String... args){
		new MyThread().run();
		System.out.println(Thread.currentThread());
		new Thread(() -> {
			System.out.println("Java8 匿名内部类");
		}).start();
	}
}
