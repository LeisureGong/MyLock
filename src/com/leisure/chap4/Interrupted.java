package com.leisure.chap4;

import java.util.concurrent.TimeUnit;

/**
 * 中断
 * 许多声明抛出InterruptedException方法
 * 这些方法在抛出InterruptedException前，Java虚拟机会先将该线程的终端标识位清除
 * 然后抛出InterruptedException，此时调用isInterrupted()方法将会返回false
 * @author gonglei
 * @date 2020/4/17 9:53
 */
public class Interrupted {

	//休眠线程
	static class SleepRunner implements Runnable{
		@Override
		public void run(){
			while(true){
				SleepUtils.second(10);
			}
		}
	}

	//运行线程
	static class BusyRunner implements Runnable{
		@Override
		public void run(){
			while(true){

			}
		}
	}
	public static void main(String... args) throws Exception{
		//sleepThread线程尝试不断睡眠
		Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
		sleepThread.setDaemon(true);
		//busyThread线程不停地运行
		Thread busyThread = new Thread(new BusyRunner(),"BusyThread");
		busyThread.setDaemon(true);
		sleepThread.start();
		busyThread.start();
		//休眠5秒，让sleepThread和busyThread充分运行
		TimeUnit.SECONDS.sleep(5);
		sleepThread.interrupt();
		busyThread.interrupt();
		System.out.println("SleepThread interrupted is " + sleepThread.isInterrupted());
		System.out.println("BusyThread interrupted is " + busyThread.isInterrupted());
		SleepUtils.second(2);
	}
}
