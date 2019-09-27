
/**
 * 
 * 
 * @author adaivskenan
 *
 */
package com.adaivskenan.pattern.finalclz;

/**
 * 
 * 不可变类模式</br>
 * 使用场景：</br>
 * <li>当对象创建后,内部状态和数据不再发生任何变化
 * <li>对象需要被共享，被多线程频繁访问
 * </br>
 * 实现不变模式：</br>
 * <li>去出setter方法以及所有修改自身属性的方法
 * <li>将所有属性设置为私有，并用final标记，确保其不可修改
 * <li>确保没有子类可以重写方法
 * <li>有一个可以构建完整对象的构造函数
 * @author adaivskenan
 *
 */
public final class Product {//final 无子类

	private final String no;//私有属性，不会被其它对象获取，final保证不会被第二次赋值
	
	public Product(String no) {
		this.no = no;
	}

	public String getNo() {
		return no;
	}
	
}