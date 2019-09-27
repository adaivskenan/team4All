/**
 * 
 */
package com.adaivskenan.test.java.util.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock中断响应测试
 * 
 * @author adaivskenan
 *
 */
public class InterruptedRentrantLock implements Runnable{
	
	/**
	 * 多实例公用的锁
	 */
	public static ReentrantLock reentrantLock1 = new ReentrantLock();
	public static ReentrantLock reentrantLock2 = new ReentrantLock();
	
	int lock;
	
	public InterruptedRentrantLock(int lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		try {
			if(lock == 1) {
				reentrantLock1.lockInterruptibly();
				Thread.sleep(500);
				reentrantLock2.lockInterruptibly();
			}else {
				reentrantLock2.lockInterruptibly();
				Thread.sleep(500);
				reentrantLock1.lockInterruptibly();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if(reentrantLock1.isHeldByCurrentThread()) {
				reentrantLock1.unlock();
			}
			if(reentrantLock2.isHeldByCurrentThread()) {
				reentrantLock2.unlock();
			}
			System.out.println(Thread.currentThread().getId() + ":线程退出");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		InterruptedRentrantLock lock1 = new InterruptedRentrantLock(1);
		InterruptedRentrantLock lock2 = new InterruptedRentrantLock(2);
		Thread t1 = new Thread(lock1);
		Thread t2 = new Thread(lock2);
		t1.start();
		t2.start();
//		t1.join();	不可join，否则造成主线程等待
//		t2.join();
		Thread.sleep(500);
		t2.interrupt();	//中断t2后其余线程才能继续执行
	}

}
