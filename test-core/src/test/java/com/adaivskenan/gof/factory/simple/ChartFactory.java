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
 * 静态工厂类
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

public class ChartFactory {
	// 静态工厂方法
	public static Chart getChart(String type) {
		Chart chart = null;
		if (type.equalsIgnoreCase("histogram")) {
			chart = new HistogramChart();
			System.out.println("初始化设置柱状图！");
		} else if (type.equalsIgnoreCase("pie")) {
			chart = new PieChart();
			System.out.println("初始化设置饼状图！");
		} else if (type.equalsIgnoreCase("line")) {
			chart = new LineChart();
			System.out.println("初始化设置折线图！");
		}
		return chart;
	}
}
