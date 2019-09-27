/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.proxy.dynamic
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月5日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.gof.proxy.dynamic;

/**
 * <p>
 * dynamic proxy test
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

public class DynamicProxyTest {

	/**
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		ProxyClassImpl c = new ProxyClassImpl();
		DynamicProxyHandler proxyHandler = new DynamicProxyHandler(c);
		IProxyClass proxyClass = (IProxyClass) proxyHandler.newProxyInstance();
		System.out.println(proxyClass.getClass().getName());
		System.out.println(proxyClass.doSomething(5));//the proxyClass is Proxy0 ,not the object of ProxyClassImple

	}

}
