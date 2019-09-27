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
 * 文件日志记录器工厂类：具体工厂
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

public class FileLoggerFactory implements LoggerFactory {
	public Logger createLogger() {
		// 创建文件日志记录器对象
		Logger logger = new FileLogger();
		// 创建文件，代码省略
		return logger;
	}
}
