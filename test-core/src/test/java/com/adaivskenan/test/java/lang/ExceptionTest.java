/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.test.java.lang
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年1月15日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.test.java.lang;

/**
 * <p>
 * java.lang.Exception.Exception 测试类
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年1月15日
 */

public class ExceptionTest {

	/**
	 * 
	 * @param args void
	 */
	public static void main(String[] args) {
		try {
			try {
				throw new Exception();
			} finally {
				// TODO: handle finally clause
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class ExceptionTest01 {
	public static void main(String[] args) {
		try {
			if (Integer.valueOf(1).equals(1)) {
				throw new Exception01();
			} else {
				throw new Exception02();
			}
		} catch (Exception01 | Exception02 e) {
			e.printStackTrace();
		}
	}
}

class Exception01 extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7530981134586127447L;

}

class Exception02 extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7530981134586127447L;

}

class Close01 implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.err.println("Close01--->");
		throw new InterruptedException("Close01 failed");
	}

}

class Close02 implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.err.println("Close02--->");
		throw new Exception("Close02 failed");
	}

}


/*try
Close02--->
Close01--->
catch
java.lang.Exception: failed
	at com.adaivskenan.test.java.lang.Close01.close(ExceptionTest.java:83)
	at com.adaivskenan.test.java.lang.TestAutoCloseable.main(ExceptionTest.java:101)
finally
*/


/*
try
Close02--->
Close01--->
catch
java.lang.Exception: Close02 failed
	at com.adaivskenan.test.java.lang.Close02.close(ExceptionTest.java:93)
	at com.adaivskenan.test.java.lang.TestAutoCloseable.main(ExceptionTest.java:112)
	Suppressed: java.lang.Exception: Close01 failed
		at com.adaivskenan.test.java.lang.Close01.close(ExceptionTest.java:83)
		... 1 more
finally*/


/*
 * try
Close02--->
Close01--->
catch
java.lang.Exception: Close01 failed
	at com.adaivskenan.test.java.lang.Close01.close(ExceptionTest.java:83)
	at com.adaivskenan.test.java.lang.TestAutoCloseable.main(ExceptionTest.java:128)
---->
java.lang.Exception: Close02 failed
	at com.adaivskenan.test.java.lang.Close02.close(ExceptionTest.java:93)
	at com.adaivskenan.test.java.lang.TestAutoCloseable.main(ExceptionTest.java:128)
	Suppressed: java.lang.Exception: Close01 failed
		at com.adaivskenan.test.java.lang.Close01.close(ExceptionTest.java:83)
		... 1 more
finally

 * */


/*
 * try
Close02--->
Close01--->
catch
java.lang.InterruptedException: Close01 failed
	at com.adaivskenan.test.java.lang.Close01.close(ExceptionTest.java:83)
	at com.adaivskenan.test.java.lang.TestAutoCloseable.main(ExceptionTest.java:151)
---->
java.lang.Exception: Close02 failed
	at com.adaivskenan.test.java.lang.Close02.close(ExceptionTest.java:93)
	at com.adaivskenan.test.java.lang.TestAutoCloseable.main(ExceptionTest.java:151)
	Suppressed: java.lang.InterruptedException: Close01 failed
		at com.adaivskenan.test.java.lang.Close01.close(ExceptionTest.java:83)
		... 1 more
finally

 * */

class TestAutoCloseable {
	public static void main(String[] args) {
		/*
		 * try-with-resources
		 */
		try (Close01 close = new Close01(); Close02 close02 = new Close02()) {
			System.err.println("try");
		} catch (Exception e) {
			System.err.println("catch");
			for (Throwable te : e.getSuppressed()) {
				te.printStackTrace();
				System.err.println("---->");
			}
			e.printStackTrace();
		} finally {
			System.err.println("finally");
		}
	}
}