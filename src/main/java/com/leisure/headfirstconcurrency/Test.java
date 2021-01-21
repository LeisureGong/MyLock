package com.leisure.headfirstconcurrency;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 阻塞队列-生产者消费者模型
 * @author gonglei
 * @date 2020/4/16 16:06
 */
public class Test {

	private int queueSize = 10;
	private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(queueSize);


	class Consumer extends Thread{
		@Override
		public void run(){
			consume();
		}
		private void consume(){
			while(true){
				try{
					queue.take();
					System.out.println("从队列取走一个元素，当前队列剩余 " + queue.size() + " 个元素");
				}catch (InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}

	class Producer extends Thread{
		@Override
		public void run(){
			produce();
		}

		private void produce(){
			while(true){
				try{
					queue.add(1);
					System.out.println("向队列中插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String... args){
		Test test = new Test();
		Producer producer = test.new Producer();
		Consumer consumer = test.new Consumer();

		producer.start();
		consumer.start();
	}
}
