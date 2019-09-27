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
public class MethodTest3 {

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
		Class<?> clz = Class.forName("com.adaivskenan.test.java.lang.reflect.MethodTest3");
		Method method = clz.getMethod("target", int.class);
		
		Object[] arg = new Object[1];
		arg[0] = 128;
		
		long current = System.currentTimeMillis();
		for (int i = 0; i < 2_000_000_000; i++) {
			if(i%100_000_000 == 0) {
				long temp = System.currentTimeMillis();
				System.out.println(temp - current);
				current = temp;
			}
			//避免频繁创建Object[]和128的自动装箱后速度反而更慢了
			//因为MethodTest2中的反射方法被内联了，从而即时编译器中的逃逸分析将原本新建的Object数组判定为不逃逸对象
			//不逃逸对象，即时编译器可以选择栈分配甚至是虚拟分配，也就是不占用堆空间，不会触发GC
			//如果再循环外新建数组，即时编译器无法确定这个数组会不会被中途修改，因此无法优化掉访问数组的操作
			method.invoke(null, arg);
		}
		
	}

	public static void target(int i) {
	}

}
