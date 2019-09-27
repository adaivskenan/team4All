/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.singleton
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年1月30日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.gof.singleton;

/**
 * <p>内部类单例</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年1月30日
 */

public class StaticSingleton {
	
	private StaticSingleton(){
		System.out.println("StaticSingleton is create");
	}
	
	/**
	 * 利用JVM对内部类和类的初始化方式创建单例
	 * @author adaivskenan
	 *
	 */
	private static class SingletonHolder{
		private static StaticSingleton instance = new StaticSingleton();
	}

	public static StaticSingleton getInstance(){
		return SingletonHolder.instance;
	}
	
}
