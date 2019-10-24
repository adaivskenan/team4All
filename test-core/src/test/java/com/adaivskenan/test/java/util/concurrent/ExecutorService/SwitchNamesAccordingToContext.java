/**
 * 
 */
package com.adaivskenan.test.java.util.concurrent.ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author qinjunjie
 *
 */
public class SwitchNamesAccordingToContext {

	static ExecutorService executorService = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Orders-%d").setDaemon(true)
				.build();
		executorService = Executors.newFixedThreadPool(5, threadFactory);
		process("my message id");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void process(String messageId) {
		executorService.submit(() -> {
			final Thread currentThread = Thread.currentThread();
			final String oldName = currentThread.getName();
			currentThread.setName("Processing-" + messageId);
			try {
				System.out.println(Thread.currentThread().getName());
			} finally {
				currentThread.setName(oldName);
			}
		});
	}

}
