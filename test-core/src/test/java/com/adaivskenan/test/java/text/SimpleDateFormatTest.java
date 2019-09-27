/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.test.java.text
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年3月20日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.test.java.text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * <p>
 * java.text.SimpleDateFormat
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年3月20日
 */

public class SimpleDateFormatTest {

	/**
	 * 错误用法，会把别人的时间格式化到自己的下面
	 */
	public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new TestSimpleDateFormat()).start();
		}
	}

}

class TestSimpleDateFormat implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		Random random = new Random();
		if (random.nextBoolean()) {
			c.add(Calendar.DAY_OF_YEAR, -1);
			c.add(Calendar.YEAR, -1);
		} else {
			c.add(Calendar.DAY_OF_YEAR, 1);
			c.add(Calendar.YEAR, 1);
		}
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 这样是正确的
//		String dateStr = simpleDateFormat.format(c.getTime());
		String dateStr = SimpleDateFormatTest.simpleDateFormat.format(c.getTime());
		if (!dateStr.equals("2017-08-23")
				&& !dateStr.equals("2019-08-25")) {
			throw new RuntimeException(dateStr);
		}
		System.out.println(SimpleDateFormatTest.simpleDateFormat.format(c.getTime()));
	}
}
