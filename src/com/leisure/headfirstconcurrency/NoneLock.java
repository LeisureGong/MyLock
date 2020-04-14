package com.leisure.headfirstconcurrency;

import javafx.beans.binding.ObjectExpression;

/**
 * @author gonglei
 * @date 2020/4/14 10:41
 */
public class NoneLock {

	private static Object lock = new Object();
	static class ThreadA implements Runnable{
		@Override
		public void run() {
			synchronized (lock){
				for (int i = 0; i < 100; i++) {
					System.out.println("Thread A" + i);
				}
			}
		}
	}
	static class ThreadB implements Runnable{
		@Override
		public void run(){
			synchronized (lock){
				for(int i = 0;i < 100;i++){
					System.out.println("Thread B " + i);
				}
			}
		}
	}

	public static void main(String... args) throws InterruptedException{
		new Thread(new ThreadA()).start();
		Thread.sleep(10000);
		new Thread(new ThreadB()).start();
	}
}
