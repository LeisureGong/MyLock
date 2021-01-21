package com.leisure.chap4;

/**
 * @author gonglei
 * @date 2020/4/17 9:39
 */
public class runnableTest {
	private static int i = 10;

	static class Hello implements Runnable{
		@Override
		public void run(){
			System.out.println(i++);
		}
	}
	public static void main(String... args){
		Thread thread = new Thread(new Hello(),"Hello");
			thread.start();
	}
}
