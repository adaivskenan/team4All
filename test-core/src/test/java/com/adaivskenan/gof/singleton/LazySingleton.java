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
 * <p>延迟加载</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年1月30日
 */

public class LazySingleton {
	
	/**
	 * 注意：STATUS不会造成instance实例被创建，因为instance初始为null;
	 */
	public static int STATUS=1;
	
	private LazySingleton(){
		System.out.println("LazySingleton has been created");
	}
	
	private static LazySingleton instance = null;
	
	/**
	 * 获取实例使用锁的方式，会造成性能略差
	 * @return LazySingleton
	 */
	public static synchronized LazySingleton getInstance(){
		if(instance == null){
			instance = new LazySingleton();
		}
		return instance;
	}
	
}
