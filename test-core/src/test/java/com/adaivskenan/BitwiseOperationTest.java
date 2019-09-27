/**
 * 
 */
package com.adaivskenan;

/**
 * @author adaivskenan
 *
 */
public class BitwiseOperationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NOT();
		AND();
		OR();
		XOR();
		BitShifts();
	}

	public static void NOT() {
		int b = 7;// 0000 0111
		System.out.println("-b：" + (-b));
	}

	public static void AND() {
		int a = 8;// 0000 1000
		int b = 7;// 0000 0111
		System.out.println("与的结果是：" + (a & b));
	}

	public static void OR() {
		int a = 8;// 0000 1000
		int b = 7;// 0000 0111
		System.out.println("或的结果是：" + (a | b));
	}

	public static void XOR() {
		int a = 15;// 0000 1111
		int b = 7;// 0000 0111
		System.out.println("异或的结果是：" + (a ^ b));// 0000 1000
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("a:"+a);
		System.out.println("b:"+b);
	}

	// << (left shift), >> (signed right shift), and >>> (unsigned right shift)
	public static void BitShifts() {
		System.out.println(2>>1);
		System.out.println(1<<1);
		System.out.println(-1>>>1);
	}

}
