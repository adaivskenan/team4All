/**
 * 
 */
package com.adaivskenan.test.java.util.concurrent.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author qinjunjie 2）支持可重入。读线程在获取了读锁后还可以获取读锁；写线程在获取了写锁之后既可以再次获取写锁又可以获取读锁；
 * 
 *         3）还允许从写入锁降级为读取锁，其实现方式是：先获取写入锁，然后获取读取锁，最后释放写入锁。但是，从读取锁升级到写入锁是不允许的；
 */
public class ReentrantReadWriteLockTest {

	private static final ReentrantReadWriteLock.ReadLock RL;
	private static final ReentrantReadWriteLock.WriteLock WL;
	static {
		ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
		RL = rwl.readLock();
		WL = rwl.writeLock();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RNestW();
	}

	private static void RR() {

	}

	private static void WW() {
		WL.lock();
		try {
			System.out.println();
			WL.lock();
			try {
				System.out.println();
			} finally {
				WL.unlock();
			}
		} finally {
			WL.unlock();
		}
	}

	/**
	 * 
	 */
	private static void RNestW() {
		RL.lock();
		try {
			System.out.println();
			WL.lock();
			try {
				System.out.println();
			} finally {
				WL.unlock();
			}
		} finally {
			RL.unlock();
		}
	}

	private static void WNestR() {
		WL.lock();
		try {
			RL.lock();
			try {
				System.out.println();
			} finally {
				RL.unlock();
			}
		} finally {
			WL.unlock();
		}
	}

}
