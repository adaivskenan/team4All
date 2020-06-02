/**
 * 
 */
package com.adaivskenan.test.java.util.concurrent.ExecutorService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author qinjunjie
 *
 */
public class RememberAboutExceptionHandling {
	final static ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Orders-%d").setDaemon(true).build();
	final static ExecutorService executorService = Executors.newFixedThreadPool(5, threadFactory);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			bad();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			good();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			e1.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void bad() {
		executorService.submit(() -> {
		    System.out.println(1 / 0);
		});
	}
	
	public static void good() throws InterruptedException, ExecutionException {
		final Future<Integer> division = executorService.submit(() -> 1 / 0);
		division.get();
	}

}
