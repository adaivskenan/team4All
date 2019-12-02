/**
 * 
 */
package com.adaivskenan.test.java.util.concurrent.locks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author qinjunjie
 *
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
