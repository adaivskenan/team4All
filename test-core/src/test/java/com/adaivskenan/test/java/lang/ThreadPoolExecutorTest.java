package com.adaivskenan.test.java.lang;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) throws InterruptedException {
		threadPoolTest(200_000);
		threadTest(200_000);
	}

	public static void threadPoolTest(int count) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS,
				new LinkedBlockingDeque<Runnable>(count));
		final List<Integer> l = new LinkedList<>();
		final Random random = new Random();
		for (int i = 0; i < count; i++) {
			tp.execute(new Runnable() {

				@Override
				public void run() {
					l.add(random.nextInt());
				}
			});
		}
		//停止接受新的任务，关闭idle线程，不等待所有线程执行完毕
		tp.shutdown();
		//awaitTermination返回true即线程池中的线程执行完成
		tp.awaitTermination(1, TimeUnit.DAYS);
		System.out.println(System.currentTimeMillis() - startTime);
		System.out.println(l.size());
	}

	public static void threadTest(int count) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		final List<Integer> l = new LinkedList<>();
		final Random random = new Random();
		for (int i = 0; i < count; i++) {
			Thread thread = new Thread() {
				@Override
				public void run() {
					l.add(random.nextInt());
				}
			};
			thread.start();
			thread.join();
		}
		System.out.println(System.currentTimeMillis() - startTime);
		System.out.println(l.size());
	}
}
