/**
 * 
 */
package com.adaivskenan.test.java.util.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * java.util.concurrent.locks.ReentrantLock 测试类
 * 其中变量i为线程不安全的，如果两个线程同时进行修改则结果无法预知。
 * 使用重入锁保证结果为20000000
 * 
 * @author adaivskenan
 *
 */
public class ReentrantLockTest implements Runnable {

	/**
	 * 多实例公用的锁
	 */
	public static ReentrantLock reentrantlock = new ReentrantLock();

	int i = 0;//线程不安全
	
	@Override
	public void run() {
		for (int j = 0; j < 10000000; j++) {
			reentrantlock.lock();
			try {
				i++;
				if(j==(10000000-1)){
					System.out.println(i);
				}
			} finally {
				reentrantlock.unlock();
//				reentrantlock.unlock(); 释放次数多于锁的的次数 java.lang.IllegalMonitorStateException
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
		Thread t1 = new Thread(reentrantLockTest);
		Thread t2 = new Thread(reentrantLockTest);
		t1.start();
		t2.start();
		t1.join();//Waits for this thread to die 但是不是说t1和t2就是顺序执行了
		t2.join();
		System.out.println(reentrantLockTest.i);
	}

}