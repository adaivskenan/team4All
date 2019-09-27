package com.adaivskenan.gof.abstrfactory;

//Summer文本框类：具体产品
public class SummerTextField implements TextField {

	@Override
	public void display() {
		System.out.println("显示蓝色边框文本框。");
	}

}
