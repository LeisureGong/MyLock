package com.leisure.headfirstconcurrency;

/**
 * @author gonglei
 * @date 2020/4/14 10:55
 */
public class Signal {

	private static volatile int signal = 0;

	static class ThreadA implements Runnable{
		@Override
		public void run(){
			while(signal < 5){
				if(signal % 2 == 0){
					System.out.println("Thread A " + signal);
					signal++;
				}
			}
		}
	}
	static class ThreadB implements Runnable{
		@Override
		public void run(){
			while(signal < 5){
				if(signal % 2 == 1){
					System.out.println("Thread B " + signal);
					signal = signal + 1;
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
