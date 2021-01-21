package com.leisure.chap4;

import java.util.concurrent.TimeUnit;

/**
 * 安全地中止线程
 * @author gonglei
 * @date 2020/4/17 10:30
 */
public class ShutDown {

	private static class Runner implements Runnable{
		private long i;
		private volatile boolean on = true;
		@Override
		public void run(){
			while(on && !Thread.currentThread().isInterrupted()){
				i++;
			}
			System.out.println("Count i = " + i);
		}
		public void cancel(){
			on = false;
		}
	}

	public static void main(String... args) throws Exception{
		Runner one = new Runner();
		Thread countThread = new Thread(one,"CountThread");
		countThread.start();
		//睡眠一秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
		TimeUnit.SECONDS.sleep(1);
		countThread.interrupt();
		Runner two = new Runner();
		countThread = new Thread(two,"CountThread");
		countThread.start();
		TimeUnit.SECONDS.sleep(10);
		two.cancel();

	}
}
