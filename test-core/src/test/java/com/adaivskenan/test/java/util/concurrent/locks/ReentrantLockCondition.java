/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.test.java.util.concurrent.locks
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月6日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.test.java.util.concurrent.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>ReentrantLock with Condition</p>
 * 
 * add breakpoint and debug: watch the execute step
 * 
 * Example:java.util.concurrent.ArrayBlockingQueue<E>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年2月6日
 */

public class ReentrantLockCondition implements Runnable {

	public static ReentrantLock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();//Returns a Condition instance for use with this Lock instance. 

	
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			lock.lock();// step 1
			condition.await();//step 2 The current thread is assumed to hold the lock associated with this Condition when this method is called.
			System.out.println("Thread is going on");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();	//step 6
		}
	}

	/**
	 * 
	 * @param args void
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ReentrantLockCondition lockCondition = new ReentrantLockCondition();
		Thread t1 = new Thread(lockCondition);
		t1.start();
		Thread.sleep(2000);
		//通知线程lockCondition继续执行
		lock.lock();//step 3
		condition.signal(); //step 4
		lock.unlock();	//step 5 if cancle this step, t1 can not wake up and step 6 cannot execute 
	}

}
