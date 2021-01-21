package com.leisure.headfirstconcurrency;

import java.util.stream.IntStream;

/**
 * @author gonglei
 * @date 2020/4/12 11:33
 */
public class Demo {

	public static class T1 extends Thread{
		@Override
		public void run(){
			super.run();
			System.out.println(String.format("当前执行的线程是：%s,优先级：%d",Thread.currentThread().getName(),
					Thread.currentThread().getPriority()));
		}
	}

	public static void main(String... args){
		Thread thread = new Thread(() -> {});
		System.out.println(thread.getState());
	}
}
