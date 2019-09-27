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
 * 具体观察者角色
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

public class ConcreteObserver implements Observer {
	// 观察者的状态
	private String observerState;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adaivskenan.gof.observer.Observer#update(java.lang.String)
	 */
	@Override
	public void update(String state) {
		/**
		 * 更新观察者的状态，使其与目标的状态保持一致
		 */
		observerState = state;
		System.out.println("更新状态为：" + observerState);
	}

}
