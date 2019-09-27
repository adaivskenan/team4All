/**
 * 
 */
package com.adaivskenan.test.java.util;

import java.util.StringTokenizer;

/**
 * @author adaivskenan
 *
 */
public class StringTokenizerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String orgStr = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 1000; i++) {
			sb.append(i);
			sb.append(",");
		}
		orgStr = sb.toString();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			orgStr.split(",");
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);//2461
		
		start = System.currentTimeMillis();
		String orgStr1  = sb.toString();
		StringTokenizer st = new StringTokenizer(orgStr1, ",");
//		for (int i = 0; i < 100000; i++) {
//			st.nextToken();
//		}
		while (st.hasMoreTokens()) {
			st.nextToken();
		}
		end = System.currentTimeMillis();//1
		System.out.println(end - start);
	}

}
