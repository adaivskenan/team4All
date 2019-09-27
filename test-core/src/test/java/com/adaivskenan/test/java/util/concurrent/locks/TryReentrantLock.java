/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.test.java.util.concurrent.locks
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月6日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.test.java.util.concurrent.locks;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>try ReentrantLock 效率发现不高，切换获取锁开销很大</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年2月6日
 */

public class TryReentrantLock implements Runnable {

	/**
	 * 多实例公用的锁
	 */
	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();
	
	/**
	 * 记录为了获取锁切换的次数
	 */
	static AtomicInteger count = new AtomicInteger(0);
	
	int key;
	
	public TryReentrantLock(int key){
		this.key = key;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		if(key == 1){
			while(true){
				count.incrementAndGet();
				if(lock1.tryLock()){
					try {
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
						}
						if (lock2.tryLock()) {
							try {
								System.out.println(Thread.currentThread().getId() + " My Job done"+ "count is" + count);
								return;
							} finally {
								lock2.unlock();
							}
						} 
					} finally {
						lock1.unlock();
					}
				}
			}
		}else{
			while(true){
				count.incrementAndGet();
				if(lock2.tryLock()){
					try{
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
						}
						if(lock1.tryLock()){
							try {
								System.out.println(Thread.currentThread().getId() + " My Job done"+ "count is" + count);
								return;
							} finally {
								lock1.unlock();
							}
						}
					}finally{
						lock2.unlock();
					}
				}
			}
		}
	}

	/**
	 * 
	 * @param args void
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		TryReentrantLock tryLock1 = new TryReentrantLock(1);
		TryReentrantLock tryLock2 = new TryReentrantLock(2);
		Thread t1 = new Thread(tryLock1);
		Thread t2 = new Thread(tryLock2);
		t1.start();
		t2.start();
//		t1.join();	Waits for this thread to die
//		t2.join();	Waits for this thread to die 相互等待造成无法结束
	}

}
