package com.adaivskenan.gof.abstrfactory;

public class Client {
	public static void main(String args[]) {
		// 使用抽象层定义
		SkinFactory factory;
		Button bt;
		TextField tf;
		ComboBox cb;
		factory = new SummerSkinFactory();
		bt = factory.createButton();
		tf = factory.createTextField();
		cb = factory.createComboBox();
		bt.display();
		tf.display();
		cb.display();
	}
}