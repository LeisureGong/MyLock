package com.leisure.chap4;

import java.util.concurrent.TimeUnit;

/**
 * @author gonglei
 * @date 2020/4/10 10:38
 */
public class SleepUtils {
	public static final void second(long seconds){
		try{
			TimeUnit.SECONDS.sleep(seconds);
		}catch (InterruptedException e){

		}
	}
}
