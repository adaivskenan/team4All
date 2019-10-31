/**
 * 
 */
package com.adaivskenan.test.java.util;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 
 * 如果我们手工使用JDK
 * Timer（Quartz的Scheduler），在Web容器启动时启动Timer，当Web容器关闭时，除非你手工关闭这个Timer，否则Timer中的任务还会继续运行
 * 
 * @author qinjunjie
 *
 */
public class TimerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Web应用程序启动...");
		new Thread(new Runnable() {

			@Override
			public void run() {
				Timer timer = new Timer();// ②-1:创建一个Timer，Timer内部自动创建一个背景线程
//				Timer timer = new Timer(true);// 设置为守护线程Timer
				TimerTask task = new SimpleTimerTask();
				timer.schedule(task, 1000L, 5000L); // ②-2:注册一个5秒钟运行一次的任务
			}
		}).start();
		System.out.println("Web应用程序关闭...");
	}

}

class SimpleTimerTask extends TimerTask {
	private int count;

	public void run() {
		System.out.println((++count) + "execute task..." + (new Date()));
	}
}
