/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.proxy.staticproxy
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月5日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.gof.proxy.staticproxy;

/**
 * <p>
 * 静态代理 测试类
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

public class StaticProxyTest {

	public static int sing(IDoSomething sing, int num) {
		return sing.doSometing(num);
	}

	public static void main(String[] args) {

		// 目标对象

		// 代理对象,把目标对象传给代理对象,建立代理关系

		// 执行代理的方法

		System.out.println(StaticProxyTest.sing(new SingProxy(), 5));
	}

}
