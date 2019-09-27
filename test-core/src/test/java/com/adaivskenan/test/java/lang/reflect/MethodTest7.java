/**
 * 
 */
package com.adaivskenan.test.java.lang.reflect;

import java.lang.reflect.Method;

/**
 * @author qinjunjie
 *
 */
public class MethodTest7 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Class<?> clz = Class.forName("com.adaivskenan.test.java.lang.reflect.MethodTest7");
		Method method = clz.getMethod("target", int.class);
		method.setAccessible(true);
		//造成下面的反射在循环失去内联，内联失败逃逸分析也不会起作用
		polluteProfile();
		
		
		long current = System.currentTimeMillis();
		for (int i = 0; i < 2_000_000_000; i++) {
			if (i % 100_000_000 == 0) {
				long temp = System.currentTimeMillis();
				System.out.println(temp - current);
				current = temp;
			}
			method.invoke(null, 127);
		}

	}

	public static void target(int i) {
	}

	
	public static void polluteProfile() throws Exception {
		//同为target1还是无法内联
		//如果其中一个为target则可以内联
		Method m1 = MethodTest7.class.getMethod("target1", int.class);
		Method m2 = MethodTest7.class.getMethod("target1", int.class);
		
		for (int i = 0; i < 2000; i++) {
			m1.invoke(null, 0);
			m2.invoke(null, 0);
		}
		//m1  equals m2
		System.out.println(m1.equals(m2));
	}

	public static void target1(int i) {
	}

	public static void target2(int i) {
	}
}
