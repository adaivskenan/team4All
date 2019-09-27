package com.adaivskenan.gof.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>抽象主题角色(抽象被观察者(Observable)角色)</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年3月8日
 */
public abstract class Subject {
	/**
	 * 用来保存注册的观察者对象
	 */
	private List<Observer> list = new ArrayList<>();

	/**
	 * 注册观察者对象
	 *
	 * @param observer
	 *            观察者对象
	 */
	public void addObserver(Observer observer) {

		list.add(observer);
		System.out.println("add an observer");
	}

	/**
	 * 删除观察者对象
	 *
	 * @param observer
	 *            观察者对象
	 */
	public void deleteObserver(Observer observer) {

		list.remove(observer);
	}

	/**
	 * 通知所有注册的观察者对象
	 */
	public void notifyObservers(String newState) {

		for (Observer observer : list) {
			observer.update(newState);
		}
	}
}