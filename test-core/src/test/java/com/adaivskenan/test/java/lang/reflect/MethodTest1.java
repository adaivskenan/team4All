/**
 * 
 */
package com.adaivskenan.test.java.lang.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author qinjunjie
 * @version V1
 *
 */
public class MethodTest1 {

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
		Class<?> clz = Class.forName("com.adaivskenan.test.java.lang.reflect.MethodTest1");
		Method method = clz.getMethod("target", int.class);
		// -Dsun.reflect.inflationThreshold=15
		// 其中15是默认的阈值，当某个反射调用的次数在15之下时，采用本地实现；
		// 当达到15时便开始生成字节码，并将委派实现的委派对象切换至动态实现，这个过程为Inflation
		for (int i = 0; i < 20; i++) {
			method.invoke(null, i);
		}
	}

	public static void target(int i) {
		new Exception("#" + i).printStackTrace();
	}

}

/*
java.lang.Exception: #19
at com.adaivskenan.test.java.lang.reflect.MethodTest.target(MethodTest.java:34)
at sun.reflect.GeneratedMethodAccessor1.invoke(Unknown Source)
at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source)
at java.lang.reflect.Method.invoke(Unknown Source)
at com.adaivskenan.test.java.lang.reflect.MethodTest.main(MethodTest.java:29)*/
