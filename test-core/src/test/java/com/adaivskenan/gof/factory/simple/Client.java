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
 * 抽象工厂使用类
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

public class Client {

	/**
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		Chart chart;
		//这里就可以根据配置文件或者启动参数来动态确定需要创建的类型
		chart = ChartFactory.getChart("histogram"); // 通过静态工厂方法创建产品
		chart.display();
	}

}
