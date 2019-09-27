/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.factory.simple
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年3月8日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.gof.factory.simple;

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
 * @version 2018年3月8日
 */

public class HistogramChart implements Chart {

	public HistogramChart() {
		System.out.println("创建柱状图！");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.adaivskenan.gof.factory.simple.Chart#display()
	 */
	@Override
	public void display() {
		System.out.println("显示柱状图！");

	}

}
