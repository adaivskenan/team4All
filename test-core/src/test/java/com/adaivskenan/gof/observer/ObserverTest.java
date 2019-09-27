/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.observer
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月7日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.gof.observer;

/**
 * <p>
 * TODO 类描述
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年2月7日
 */

public class ObserverTest {

	/**
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		// 创建主题对象
		ConcreteSubject subject = new ConcreteSubject();
		// 创建观察者对象
		Observer observer = new ConcreteObserver();
		// 将观察者对象登记到主题对象上
		subject.addObserver(observer);
		// 改变主题对象的状态
		subject.change("new state");
	}

}
