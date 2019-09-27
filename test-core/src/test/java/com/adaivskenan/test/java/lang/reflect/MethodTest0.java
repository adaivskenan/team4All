/**
 * 
 */
package com.adaivskenan.test.java.lang.reflect;

/**
 * @author qinjunjie
 *
 */
public class MethodTest0 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long current = System.currentTimeMillis();
		for (int i = 0; i < 2_000_000_000; i++) {
			if(i%100_000_000 == 0) {
				long temp = System.currentTimeMillis();
				System.out.println(temp - current);
				current = temp;
			}
			target(1);
		}
	}

	public static void target(int i) {
	}

}
