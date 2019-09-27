/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.jvm
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月24日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.jvm;

/**
 * <p>
 * 32位系统下long的读写不是原子操作
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

public class MultiThreadLong {

	public static long t = 0;

	public static class ChangeT implements Runnable {

		private long to;

		public ChangeT(long to) {
			this.to = to;
		}

		@Override
		public void run() {
			while (true) {
				MultiThreadLong.t = to;
				Thread.yield();
			}
		}

	}

	public static class ReadT implements Runnable {

		@Override
		public void run() {
			while (true) {
				long tmp = MultiThreadLong.t;
				if (tmp != 111L && tmp != -999L && tmp != 333L && tmp != -444L) {
					System.out.println(tmp);
					Thread.yield();
				}
			}
		}
	}

	/**
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		new Thread(new ChangeT(111L)).start();
		new Thread(new ChangeT(-999L)).start();
		new Thread(new ChangeT(333L)).start();
		new Thread(new ChangeT(-444L)).start();
		new Thread(new ReadT()).start();;
	}

}
