/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.test.java.util.concurrent.locks
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月6日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.test.java.util.concurrent.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>TODO 类描述</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年2月6日
 */

public class FairReentrantLock implements Runnable {
	
	public static ReentrantLock lock = new ReentrantLock(true);

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for(;;){
			if(lock.tryLock()){
				try {
					Thread.sleep(50);
					System.out.println(Thread.currentThread().getId() + "get lock success");	
				} catch (InterruptedException e) {
				} finally {
					lock.unlock();
				}
			}
		}
	}

	/**
	 * 
	 * @param args void
	 */
	public static void main(String[] args) {
		FairReentrantLock fairLock = new FairReentrantLock();
		Thread t1 = new Thread(fairLock);
		Thread t2 = new Thread(fairLock);
		t1.start();
		t2.start();
	}

}
