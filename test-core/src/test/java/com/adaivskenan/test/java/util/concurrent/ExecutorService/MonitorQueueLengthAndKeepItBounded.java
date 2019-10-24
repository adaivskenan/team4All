/**
 * 
 */
package com.adaivskenan.test.java.util.concurrent.ExecutorService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author qinjunjie
 *
 */
public class MonitorQueueLengthAndKeepItBounded {
	static ExecutorService executorService = null;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
		executorService = new ThreadPoolExecutor(5, 10,
		        0L, TimeUnit.MILLISECONDS,
		        queue);
		
		for (int i = 0; i < 100; i++) {
			executorService.submit(()->{System.out.println("process");});
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
