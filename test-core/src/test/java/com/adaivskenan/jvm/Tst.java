/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2012
 * 包： com.adaivskenan.jvm
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年8月22日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.jvm;

/**
 * <p>
 * TODO 类描述
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年8月22日
 */

public class Tst {

	/**
	 * 
	 * @param args void
	 */
	public static void main(String[] args) {
		testArgs("ss");
	}

	public static void test(Object... a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void testArgs(Object str, Object... a) {
		System.out.println(str);
		test(a);
	}

}
