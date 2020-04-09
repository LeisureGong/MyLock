package com.encdata;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gonglei
 * @date 2020/4/9 10:06
 */
public class LockTest {

    //悲观锁
	public synchronized void testMethod(){
	}

	private ReentrantLock lock = new ReentrantLock();
	public void modifyPublicResources(){
		lock.lock();
		//操作同步资源
		lock.unlock();
	}

	//乐观锁
	private AtomicInteger atomicInteger = new AtomicInteger();
	public void increment(){
		atomicInteger.incrementAndGet();
	}
	public static void main(String[] args){
		System.out.println();
	}

}
