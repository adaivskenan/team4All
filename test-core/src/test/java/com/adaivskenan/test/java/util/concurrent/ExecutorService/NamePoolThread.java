/**
 * 
 */
package com.adaivskenan.test.java.util.concurrent.ExecutorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author qinjunjie
 *
 */
public class NamePoolThread {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NamePoolThread.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Orders-%d").setDaemon(true)
				.build();
		final ExecutorService executorService = Executors.newFixedThreadPool(5, threadFactory);
		for (int i = 0; i < 20; i++) {
			executorService.submit(() -> LOGGER.info(Thread.currentThread().getName()));
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
