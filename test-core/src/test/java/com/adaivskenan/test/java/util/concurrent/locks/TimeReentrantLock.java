/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.test.java.util.concurrent.locks
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月6日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.test.java.util.concurrent.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * ReentrantLock 限时等待
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年2月6日
 */

public class TimeReentrantLock implements Runnable {

	/**
	 * 多实例公用的锁
	 */
	public static ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		try {
			if (lock.tryLock(5, TimeUnit.SECONDS)) {
				System.out.println(Thread.currentThread().getId() + " get lock success");
				Thread.sleep(6 * 1000);
			} else {
				System.out.println(Thread.currentThread().getId() + " get lock failed");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if (lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}

	/**
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		TimeReentrantLock timeLock = new TimeReentrantLock();
		Thread t1 = new Thread(timeLock);
		Thread t2 = new Thread(timeLock);
		t1.start();
		t2.start();
	}
}
