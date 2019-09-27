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
 * <p>简单高效</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年1月30日
 */

public class Singleton {
	
	/**
	 * 注意：任何地方引用STATUS，都会造成instance实例被创建
	 */
	public static int STATUS=1;
	
	/**
	 * 系优化构造函数
	 */
	private Singleton(){
		System.out.println("Singleton has been created");
	}
	
	/**
	 * private 保证安全性 
	 * static 是因为getInstance()方法为static
	 */
	private static Singleton instance = new Singleton();
	
	/**
	 * 获取单例方法
	 * @return Singleton
	 */
	public static Singleton getInstance(){
		return instance;
	}

}
