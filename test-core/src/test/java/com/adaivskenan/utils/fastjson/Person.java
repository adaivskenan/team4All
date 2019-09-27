/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.utils.fastjson
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月2日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.utils.fastjson;

/**
 * <p>
 * Person Pojo
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年2月2日
 */

public class Person {
	int age;
	String name;
	String sex;

	/**
	 * default constructor will be required by deserializer
	 */
	Person() {
	}

	Person(int age, String name, String sex) {
		this.age = age;
		this.name = name;
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
