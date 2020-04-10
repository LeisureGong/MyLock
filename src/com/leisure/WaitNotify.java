package com.leisure;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 等待/通知机制，指一个线程A调用了对象O的wait()方法进入等待状态，
 * 而另一个线程B调用了对象O的notify()或者notifyAll()方法
 * 线程A收到通知后从对象O的wait()方法返回，进而执行后续操作
 * @author gonglei
 * @date 2020/4/10 11:39
 */
public class WaitNotify {
	static boolean flag = true;
	static Object lock = new Object();

	static class Wait implements Runnable{
		@Override
		public void run(){
			synchronized ((lock)){
				while(flag){
					try{
						System.out.println(Thread.currentThread() + " flag is true.wait @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
						lock.wait();
					}catch (InterruptedException e){

					}
				}
				//条件满足时，完成工作
				System.out.println(Thread.currentThread() + "flag is false. running @" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
			}
		}
	}

	static class Notify implements Runnable{
		@Override
		public void run(){
			synchronized (lock){
				System.out.println(Thread.currentThread() + " hold lock. notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
				lock.notifyAll();
				flag = false;
				SleepUtils.second(5);
			}

			//再次加锁
			synchronized (lock){
				System.out.println(Thread.currentThread() + "hold lock again. @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
				SleepUtils.second(5);
			}
		}
	}

	public static void main(String... args)throws Exception{
		Thread waitThread = new Thread(new Wait(),"WaitThread");
		waitThread.start();
		TimeUnit.SECONDS.sleep(1);
		Thread notifyThread = new Thread(new Notify(),"NotifyThread");
		notifyThread.start();
	}
}
