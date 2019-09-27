/**
 * 
 */
package com.adaivskenan.test.java.lang.reflect;

import java.lang.reflect.Method;

/**
 * @author qinjunjie
 *
 */
public class MethodTest6 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Class<?> clz = Class.forName("com.adaivskenan.test.java.lang.reflect.MethodTest6");
		Method method = clz.getMethod("target", int.class);
		method.setAccessible(true);
		//造成下面的反射在循环失去内联，内联失败逃逸分析也不会起作用
		polluteProfile();
		
		//避免频繁创建Object[]和128的自动装箱
		Object[] arg = new Object[1];
		arg[0] = 128;
		
		long current = System.currentTimeMillis();
		for (int i = 0; i < 2_000_000_000; i++) {
			if (i % 100_000_000 == 0) {
				long temp = System.currentTimeMillis();
				System.out.println(temp - current);
				current = temp;
			}
			method.invoke(null, arg[0]);
		}

	}

	public static void target(int i) {
	}

	
	//-XX:TypeProfileWidth 默认为2，如果增大可以是jvm对于调用点的类型profile记录更多，被记录的才能被内联
	//profile:对于invokevirtual 或者 invokeinterface,Java虚拟机会记录下调用者的具体类型
	public static void polluteProfile() throws Exception {
		Method m1 = MethodTest6.class.getMethod("target1", int.class);
		Method m2 = MethodTest6.class.getMethod("target2", int.class);
		for (int i = 0; i < 2000; i++) {
			m1.invoke(null, 0);
			m2.invoke(null, 0);
		}
	}

	public static void target1(int i) {
	}

	public static void target2(int i) {
	}
}
