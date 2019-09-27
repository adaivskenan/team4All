/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.factory
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年3月8日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.gof.factory;

/**
 * <p>
 * 工厂类客户端
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
	public static void main(String args[]) {
		LoggerFactory factory;
		Logger logger;
		// 在客户端代码中将不再使用new关键字来创建工厂对象，而是将具体工厂类的类名
		// 存储在配置文件（如XML文件）中，通过读取配置文件获取类名字符串，再使用Java
		// 的反射机制，根据类名字符串生成对象。
		factory = new FileLoggerFactory(); // 可引入配置文件实现
		logger = factory.createLogger();
		logger.writeLog();
	}
}
