/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.proxy.cglib
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月5日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.gof.proxy.cglib;

/**
 * <p>
 * Cglib动态代理测试
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年2月5日
 */

public class CglibTest {

	/**
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		CglibProxy cglibProxy = new CglibProxy();
		Do o = (Do) cglibProxy.newProxyInstance(Do.class);
		System.out.println(o.doSomething(5));

	}

}

class Do {
	public int doSomething(int num) {
		System.out.println("方法执行中。。。。。。");
		return num;
	}
}