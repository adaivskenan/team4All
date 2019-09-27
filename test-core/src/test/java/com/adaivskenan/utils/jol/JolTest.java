/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.utils.fastjson.jol
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月6日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.utils.jol;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * <p>
 * TODO 类描述
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年2月6日
 */

public class JolTest {

	/**
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		System.out.println(ClassLayout.parseClass(Pojo1.class).toPrintable());
		System.out.println(ClassLayout.parseClass(Pojo2.class).toPrintable());
		System.out.println(ClassLayout.parseClass(Pojo3.class).toPrintable());
	}

}
