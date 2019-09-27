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
public class MethodTest4 {
	
	//-Djava.lang.Integer.IntegerCache.high=128
	//-Dsun.reflect.noInflation=true

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
		Class<?> clz = Class.forName("com.adaivskenan.test.java.lang.reflect.MethodTest4");
		Method method = clz.getMethod("target", int.class);
		method.setAccessible(true);//关闭权限检查
		
		
		long current = System.currentTimeMillis();
		for (int i = 0; i < 2_000_000_000; i++) {
			if(i%100_000_000 == 0) {
				long temp = System.currentTimeMillis();
				System.out.println(temp - current);
				current = temp;
			}
			//关闭反射调用的Inflation机制，从而取消委派实现，直接使用动态实现
			//关闭权限检查
			//增加Integer缓存128
			method.invoke(null, 128);
		}
		
	}

	public static void target(int i) {
	}

}
