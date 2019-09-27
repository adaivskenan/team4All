/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.google.common.base
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月26日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.utils.guava.common.base;

import com.google.common.base.Optional;

/**
 * <p>
 * com.google.common.base.Optional<T> </br>
 * <a href= "http://ifeve.com/google-guava-using-and-avoiding-null"/>
 * google-guava-using-and-avoiding-null</a>
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年2月26日
 */

public class OptionalTest {

	/**
	 * 使用Optional除了赋予null语义，增加了可读性，最大的优点在于它是一种傻瓜式的防护。Optional
	 * 迫使你积极思考引用缺失的情况，因为你必须显式地从Optional获取引用。直接使用null很容易让人忘掉
	 * 某些情形，尽管FindBugs可以帮助查找null相关的问题，但是我们还是认为它并不能准确地定位问题根源。
	 * 如同输入参数，方法的返回值也可能是null。和其他人一样，你绝对很可能会忘记别人写的方法method(a,b)
	 * 会返回一个null，就好像当你实现method(a,b)时，也很可能忘记输入参数a可以为null。将方法的返回类
	 * 型指定为Optional，也可以迫使调用者思考返回的引用缺失的情形。
	 */
	public static void main(String[] args) {
		Optional.of(null);
		Optional.absent();
	}

}
