/**
 * 
 */
package com.adaivskenan.test.java.lang;

/**
 * @author qinjunjie
 *
 */
public class EnumTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ModelState.NONE);
		System.out.println(ModelState.NONE.ordinal());
		for(ModelState s : ModelState.values()) {
			System.out.println(s.name() + s.ordinal());
		}
	}

}


/**
 * 模型状态
 */
enum ModelState {
	/**
	 * 原始状态
	 */
	NONE,
	/**
	 * 新建状态
	 */
	NEW,
	/**
	 * 浏览状态
	 */
	BROWSE,
	/**
	 * 编辑状态
	 */
	EDIT
}