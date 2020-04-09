package com.leisure;

/**
 * @author gonglei
 * @date 2020/4/9 14:08
 */
public class DeadLockDemo {
	private static String A = "A";
	private static String B = "B";
	/**
	* 死锁，死循环，双方都想要对方释放资源
	* @date 2020/4/9
	*/
	private void deadLock(){
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (A){
					try{
						Thread.currentThread().sleep(2000);
					}catch (InterruptedException e){
						e.printStackTrace();
					}
					synchronized (B){
						System.out.println("1");
					}
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (B) {
					synchronized (A){
						System.out.println("2");
					}
				}
			}
		});
		t1.start();
		t2.start();
	}

	public static void main(String... args){
		new DeadLockDemo().deadLock();
	}
}
