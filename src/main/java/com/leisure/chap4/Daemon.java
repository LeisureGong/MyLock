package com.leisure.chap4;

import com.leisure.chap4.SleepUtils;

/**
 * @author gonglei
 * @date 2020/4/10 10:37
 */
public class Daemon {
	public static void main(String... args){
		Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
		thread.setDaemon(true);
		thread.start();
	}

	static class DaemonRunner implements Runnable{
		@Override
		public void run(){
			try{
				SleepUtils.second(10);
			}finally {
				System.out.println("DaemonThread finally run.");
			}
		}
	}
}
