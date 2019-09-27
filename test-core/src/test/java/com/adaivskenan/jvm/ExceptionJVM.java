/**
 * 
 */
package com.adaivskenan.jvm;

/**
 * @author qinjunjie
 *
 */
public class ExceptionJVM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			mayThrowException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mayThrowException() {

	}

}
