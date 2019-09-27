/**
 * 
 */
package com.adaivskenan.pattern.prodconsumer;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author adaivskenan
 *
 */
public class Consumer implements Runnable {

	private BlockingQueue<PCData> queue; // 缓冲区
	private static final int SLEEPTIME = 1000;

	public Consumer(BlockingQueue<PCData> queue) {
		this.queue = queue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("start Consumer id=" + Thread.currentThread().getId());

		Random r = new Random();
		try {
			while (true) {
				PCData data = queue.take();
				if (data != null) {
					int d = data.getIntData();
					int re = d * d;
					System.out.println(MessageFormat.format("{0}*{1}={2}", d, d, re));
					Thread.sleep(r.nextInt(SLEEPTIME));
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
	}

}
