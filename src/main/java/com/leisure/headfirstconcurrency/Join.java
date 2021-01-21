package com.leisure.headfirstconcurrency;

/**
 * @author gonglei
 * @date 2020/4/14 11:07
 */
public class Join {

	static class ThreadA implements Runnable{

		@Override
		public void run(){
			try{
				System.out.println("我是子线程：我先睡一秒");
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName());
			}catch (InterruptedException e){
				e.printStackTrace();
			}
		}
	}
	public static void main(String... args) throws InterruptedException{
		System.out.println(Thread.currentThread().getName());
		Thread thread = new Thread(new ThreadA());
		thread.start();
		thread.join();
		System.out.println(Thread.currentThread().getName());
		System.out.println("---------------");
	}
}
