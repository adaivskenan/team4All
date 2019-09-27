/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.test.java.lang
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月24日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.test.java.lang;

/**
 * <p>
 * TODO 类描述
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年2月24日
 */

public class ThreadTest {

	/**
	 * 
	 * @param args
	 *            void
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// ThreadTest.startThread();
		// StopThreadUnsafe.test();
		// InterruptThread.test();
		// WaitAndNotifyThread.test();
		SuspendTest.test();
	}

	///////////////////////// Start Thread/////////////////////////

	/**
	 * how to start a new Thread, use three different way void
	 */
	public static void startThread() {
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("hello thread t1");
			}
		});
		t1.start();

		Thread t2 = new Thread() {
			@Override
			public void run() {
				System.out.println("hello thread t2");
			}
		};
		t2.start();

		new Thread(new TRunbale()).start();
	}

	public static class TRunbale implements Runnable {

		@Override
		public void run() {
			System.out.println("hello thread t3");
		}

	}

	///////////////////////// Stop Thread/////////////////////////

	public static User u = new User();

	public static class User {
		private int id;
		private String name;

		public User() {
			id = 0;
			name = "0";
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + "]";
		}
	}

	public static class StopThreadUnsafe {

		@SuppressWarnings("deprecation")
		public static void test() throws InterruptedException {
			new ReadObjectThread().start();
			while (true) {
				Thread t = new ChangeObjectThread();
				t.start();
				Thread.sleep(150);
				t.stop();
			}
		}

		public static class ChangeObjectThread extends Thread {
			@Override
			public void run() {
				while (true) {
					synchronized (u) {
						int v = (int) (System.currentTimeMillis() / 1000);
						u.setId(v);
						try {
							Thread.sleep(100);// stopThreadUnsafe() sleep 150
												// ,so this line will sleep
												// twice,and the second time of
												// setName can not execute
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						u.setName(String.valueOf(v));
					}
					Thread.yield();
				}
			}
		}

		public static class ReadObjectThread extends Thread {
			@Override
			public void run() {
				while (true) {
					synchronized (u) {
						if (u.getId() != Integer.parseInt(u.getName())) {
							System.out.println(u.toString());
						}
					}
					Thread.yield();
				}
			}
		}

	}

	///////////////////////// Interrupt Thread/////////////////////////

	public static class InterruptThread {
		public static Thread t1 = new Thread() {
			public void run() {
				while (true) {
					if (Thread.currentThread().isInterrupted()) {
						System.out.println("Interrupted!");
						break;
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						System.out.println("Interrupted when sleep!");
						// need reset The interrupted status
						Thread.currentThread().interrupt();
					}
				}
			};
		};

		public static void test() throws InterruptedException {
			t1.start();
			Thread.sleep(2000);
			t1.interrupt();
		}

	}

	///////////////////////// Wait and Notify Thread/////////////////////////

	final static Object object = new Object();

	public static class WaitObjectThread extends Thread {

		String threadName;

		public WaitObjectThread(String threadName) {
			this.threadName = threadName;
		}

		@Override
		public void run() {
			synchronized (object) {
				System.out.println(System.currentTimeMillis() + " : " + threadName + " start!");
				try {
					System.out.println(System.currentTimeMillis() + " : " + threadName + " wait for object");
					object.wait();// if you call the wait(), the object will be
									// free to use by other thread and the
									// current thread will wait for notify,that
									// is the difference between Thread.sleep()
									// and Object.wait()
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis() + " : " + threadName + " end!");
			}
		}
	}

	public static class NotifyObjectThread extends Thread {
		@Override
		public void run() {
			synchronized (object) {
				System.out.println(System.currentTimeMillis() + " : NotifyObjectThread notify one thread");
				object.notify();
				System.out.println(System.currentTimeMillis() + " : NotifyObjectThread end!");
				try {
					Thread.sleep(1000);// after notify, if the thread still hold
										// the object, the WaitObjectThread
										// still can not run
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class WaitAndNotifyThread {
		public static void test() throws InterruptedException {
			Thread t1 = new WaitObjectThread("t1");
			Thread t11 = new WaitObjectThread("t11");
			Thread t2 = new NotifyObjectThread();
			t1.start();
			t11.start();
			Thread.sleep(100);
			t2.start();
		}
	}

	///////////////////////// suspend and resume Thread/////////////////////////

	public static Object obj = new Object();

	public static class SuspendTest {
		static ChangeObjectThread t1 = new ChangeObjectThread("t1");
		static ChangeObjectThread t2 = new ChangeObjectThread("t2");

		@SuppressWarnings("deprecation")
		public static void test() throws InterruptedException {
			t1.start();
			t2.start();
			Thread.sleep(1000);
			t1.resume();
			System.out.println("t1 resume()");
			t2.resume();
			System.out.println("t2 resume()");
			t1.join();
			t2.join();
		}
	}

	public static class ChangeObjectThread extends Thread {
		public ChangeObjectThread(String name) {
			super.setName(name);
		}

		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			System.out.println("start " + getName());
			synchronized (obj) {
				System.out.println("in " + getName());
				Thread.currentThread().suspend();
				System.out.println("out " + getName());
			}
			System.out.println("end " + getName());
		}
	}

}
