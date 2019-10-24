/**
 * 
 */
package com.adaivskenan.test.java.util.concurrent.ExecutorService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * @author qinjunjie
 *
 */
public class ExplicitAndSafeShutdown {
	private static final Logger log = LoggerFactory.getLogger(ExplicitAndSafeShutdown.class);
	
	static ExecutorService executorService = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("Orders-%d").setDaemon(true)
				.build();
		executorService = Executors.newFixedThreadPool(5, threadFactory);
		try {
			sendAllEmails(Arrays.asList("1","2","3","4"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void sendAllEmails(List<String> emails) throws InterruptedException {
	    emails.forEach(email ->
	            executorService.submit(() ->
	                    sendEmail(email)));
	    executorService.shutdown();
	    final boolean done = executorService.awaitTermination(1, TimeUnit.SECONDS);
	    log.debug("All e-mails were sent so far? {}", done);
	}
	
	private static void sendEmail(String email) {
		try {
			Thread.sleep((long) (1000*2*Math.random()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(email);
	}

}
