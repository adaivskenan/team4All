/**
 * 
 */
package com.adaivskenan.test.java.util.concurrent.ExecutorService;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author qinjunjie
 *
 */
public class MonitorQueueLengthAndKeepItBounded {
	/**
	 * if thread is not daemon thread, when main thread finished, the thread will still run
	 */
	final static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Orders-%d").setDaemon(true).build();
	static ExecutorService executorService = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + " is daemon Thread :" + Thread.currentThread().isDaemon());
		final BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(10);
		executorService = new ThreadPoolExecutor(5, 10, 0L, TimeUnit.MILLISECONDS, queue, threadFactory);

		for (int i = 0; i < 100; i++) {
			executorService.submit(() -> {
				System.out.println("process some work----current queue size :" + queue.size());
			});
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
