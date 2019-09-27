package com.adaivskenan.jvm;

/**
 * <p>
 * try - catch - finally
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年3月19日
 */
public class TryCatchFinallyTest {

	public static void main(String[] args) {
		
		System.out.println("try catch finally ---");
		tryCatchFinally();
		System.out.println("try catch finally --- end");
		
//		System.out.println("try finally ---");
//		tryFinally();
//		System.out.println("try finally --- end");
		
		
	}

	public static void tryFinally() {
		try {
			throw new RuntimeException("Test Exception");
		} finally {
			System.out.println("finally end");
		}
	}

	public static void tryCatchFinally() {
		String str = "";
		try {
			str = "test";
			throw new RuntimeException("Test Exception");
		} catch (Exception e) {
			str = "new test";
			System.out.println(str);
			throw e;
		} finally {
			System.out.println(str);
		}
	}

}
