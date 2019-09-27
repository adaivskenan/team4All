/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.abstrfactory
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年3月8日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.gof.abstrfactory;

/**
 * <p>
 * Summer按钮类：具体产品
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年3月8日
 */

public class SummerButton implements Button {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adaivskenan.gof.abstrfactory.Button#display()
	 */
	@Override
	public void display() {
		System.out.println("显示浅蓝色按钮。");

	}

}
