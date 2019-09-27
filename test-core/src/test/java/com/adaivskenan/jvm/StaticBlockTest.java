/**
 * 
 */
package com.adaivskenan.jvm;

/**
 * @author adaivskenan
 *
 */
public class StaticBlockTest {

	static// if block this, the result is 2
	{
		i = 2;
	}

	private static int i = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StaticBlockTest sb = new StaticBlockTest();
		System.out.println(i);// result is 0
	}

	// first int i;
	// second run static block i=2;
	// third i = 0;

	// if remove static
	// first int i;
	// second i = 0;
	// run block i=2;
}
