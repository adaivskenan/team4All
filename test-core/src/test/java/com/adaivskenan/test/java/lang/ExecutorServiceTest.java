package com.adaivskenan.test.java.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		// 创建一个同时允许两个线程并发执行的线程池
		ExecutorService executor = Executors.newFixedThreadPool(2);
		List<String> tasklst = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			tasklst.add(i + "");
		}
		for (String task : tasklst) {
			Thread thread = new TestThread(Integer.valueOf(task));
			executor.execute(thread);
		}
		executor.shutdown();

		try {
			// awaitTermination返回false即超时会继续循环，返回true即线程池中的线程执行完成主线程跳出循环往下执行，每隔10秒循环一次
			while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
				System.out.println("??");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("子线程执行时长：" + (end - start));
	}
}

class TestThread extends Thread {
	int i;

	TestThread(int i) {
		this.i = i;
	}

	public void run() {
		System.out.println(this.getName() + "子线程开始" + i);
		try {
			// 子线程休眠1秒
			// System.out.println(i);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + "子线程结束" + i);
	}
}