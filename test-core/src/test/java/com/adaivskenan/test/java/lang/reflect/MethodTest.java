/**
 * 
 */
package com.adaivskenan.test.java.lang.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author qinjunjie
 * @version V0
 *
 */
public class MethodTest {

	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> clz = Class.forName("com.adaivskenan.test.java.lang.reflect.MethodTest");
		Method method = clz.getMethod("target", int.class);
		method.invoke(null, 0);
	}

	public static void target(int i) {
		new Exception("#" + i).printStackTrace();
	}

}
/*
at com.adaivskenan.test.java.lang.reflect.MethodTest.target(MethodTest.java:34)
at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
at java.lang.reflect.Method.invoke(Unknown Source)
at com.adaivskenan.test.java.lang.reflect.MethodTest.main(MethodTest.java:29)

*/