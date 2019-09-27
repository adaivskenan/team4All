/**
 * 
 */
package com.adaivskenan.test.java.lang.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author qinjunjie
 *
 */
public class MethodTest2 {

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
		Class<?> clz = Class.forName("com.adaivskenan.test.java.lang.reflect.MethodTest2");
		Method method = clz.getMethod("target", int.class);
		
		long current = System.currentTimeMillis();
		for (int i = 0; i < 2_000_000_000; i++) {
			if(i%100_000_000 == 0) {
				long temp = System.currentTimeMillis();
				System.out.println(temp - current);
				current = temp;
			}
			//1、Method.invoke是一个变长的参数方法，调用时会不断的创建一个Object数组，由于Object数组不能存储基本类型，Java
			//编译器会对传入的基本类型参数进行自动装箱
			//2、Java缓存了[-128,127]中的Integer对象，128需要自动装箱时会新建一个Integer对象
			//-DJava.lang.Integer.IntegerCache.high=128 可以避免128的自动装箱产生的新对象
			method.invoke(null, 128);
		}
		
	}

	public static void target(int i) {
	}

}
