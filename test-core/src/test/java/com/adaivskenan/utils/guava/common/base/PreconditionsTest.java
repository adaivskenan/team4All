/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.google.common.base
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月26日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.utils.guava.common.base;

import static com.google.common.base.Preconditions.*;

/**
 * <p>
 * com.google.common.base.Preconditions
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

public class PreconditionsTest {

	/**
	 * Use static import:import static com.google.common.base.Preconditions.*;</br>
	 * checkElementIndex
	 * 索引值常用来查找列表、字符串或数组中的元素，如List.get(int), String.charAt(int)
	 * checkPositionIndex
	 * 位置值和位置范围常用来截取列表、字符串或数组，如List.subList(int，int), String.substring(int)
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		checkArgument("".equals(""));// IllegalArgumentException
		checkNotNull(true);// NullPointerException
		checkState("".equals(""));// IllegalStateException
		checkPositionIndex(1, 1);// IndexOutOfBoundsException
		checkElementIndex(1, 1);// IndexOutOfBoundsException
	}

}
