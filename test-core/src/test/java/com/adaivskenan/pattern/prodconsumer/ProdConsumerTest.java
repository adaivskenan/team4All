/**
 * 
 */
package com.adaivskenan.pattern.prodconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者消费者测试类
 * @author adaivskenan
 *
 */
public class ProdConsumerTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		//建立缓冲区
		BlockingQueue<PCData> queue = new LinkedBlockingQueue<>(10);
		//建立生产者
		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);
		//建立消费者
		Consumer consumer1 = new Consumer(queue);
		Consumer consumer2 = new Consumer(queue);
		Consumer consumer3 = new Consumer(queue);
		//建立线程池
		ExecutorService executorService = Executors.newCachedThreadPool();
		//运行生产者
		executorService.execute(producer1);
		executorService.execute(producer2);
		executorService.execute(producer3);
		//运行消费者
		executorService.execute(consumer1);
		executorService.execute(consumer2);
		executorService.execute(consumer3);
		//停止生产者
		Thread.sleep(10*1000);
		producer1.stop();
		producer2.stop();
		producer3.stop();
		Thread.sleep(3000);
		executorService.shutdown();
	}

}
