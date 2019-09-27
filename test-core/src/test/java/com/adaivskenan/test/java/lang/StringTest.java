/**
 * 
 */
package com.adaivskenan.test.java.lang;

import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.adaivskenan.utils.my.CollectionUtils;
import com.adaivskenan.utils.my.StringUtils;

/**
 * @author adaivskenan
 *
 */
public class StringTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// testSub();
//		testSplit();
		createKey("Hello", 1);
		System.out.println(new Date().getTime());
		System.out.println(System.currentTimeMillis());
	}
	
	public static String createKey(String vid, int order) {
		return String.format("%1$s%2$05d", new Object[] { vid, order });
	}

	public static void testSplit() {
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
		System.out.println(end - start);// 2461

		start = System.currentTimeMillis();
		String orgStr1 = sb.toString();
		StringTokenizer st = new StringTokenizer(orgStr1, ",");
		// for (int i = 0; i < 100000; i++) {
		// st.nextToken();
		// }
		while (st.hasMoreTokens()) {
			st.nextToken();
		}
		end = System.currentTimeMillis();// 1
		System.out.println(end - start);

		///
		start = System.currentTimeMillis();
		String orgStr2 = sb.toString();
		for (int i = 0; i < 100000; i++) {
			StringUtils.split(orgStr2, ",", false);
		}
		end = System.currentTimeMillis();// 1
		System.out.println(end - start);

	}

	/**
	 * 测试用例在来自《Java性能优化》一书，书中说subString会保留原字符的对象 ，而不是
	 * 一个全新的对象，导致垃圾数据多，容易性能出现问题。然后用newString() 来保证之前 
	 * 的对象可以被回收，垃圾写法。呵呵哒，大家小心，作者说的不对
	 * 
	 * @throws InterruptedException
	 */
	public static void testSub() throws InterruptedException {
		Thread.sleep(10 * 1000);
		List<String> handler = CollectionUtils.newArrayList();
		for (int i = 0; i < 100; i++) {
			HugeStr h = new HugeStr();
			handler.add(h.getSubString(1, 5));
			ImprovedHugStr impH = new ImprovedHugStr();
			handler.add(impH.getSubString(1, 5));
		}
	}

	static class HugeStr {
		private String str = new String(new char[500000000]);

		public String getSubString(int begin, int end) {
			return str.substring(begin, end);
		}
	}

	static class ImprovedHugStr {
		private String str = new String(new char[500000000]);

		public String getSubString(int begin, int end) {
			return new String(str.substring(begin, end));
		}
	}

}
