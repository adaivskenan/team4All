package com.adaivskenan.gof.observer.java;

import java.util.Observable;

public class Concrete4JSubject extends Observable {

	private String state;

	public String getState() {
		return state;
	}

	public void change(String newState) {
		state = newState;
		System.out.println("主题状态为：" + state);
		// 在状态改变，通知观察者时需要设置该标识。
		setChanged();
		// 状态发生改变，通知各个观察者
		this.notifyObservers(state);
	}
}