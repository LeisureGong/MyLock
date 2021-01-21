package com.leisure.chap4;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 暂停、恢复和停止
 * @author gonglei
 * @date 2020/4/17 10:16
 */
public class Deprecated {

	static class Runner implements Runnable{
		@Override
		public void run(){
			DateFormat format = new SimpleDateFormat("HH:mm:ss");
			while(true){
				System.out.println(Thread.currentThread().getName() + " Run at " + format.format(new Date()));
				SleepUtils.second(1);
			}
		}
	}

	public static void main(String... args)throws Exception{
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		Thread printThread = new Thread(new Runner(),"PrintThread");
		printThread.setDaemon(true);
		printThread.start();
		TimeUnit.SECONDS.sleep(3);
		printThread.suspend();
		System.out.println("main suspend PrintThread at " + format.format(new Date()));
		TimeUnit.SECONDS.sleep(3);
		printThread.resume();
		System.out.println("main resume PrintThread at " + format.format(new Date()));
		TimeUnit.SECONDS.sleep(3);
		printThread.stop();
		TimeUnit.SECONDS.sleep(3);
	}
}
