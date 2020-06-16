/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.test.io
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年1月8日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.test.java.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * <p>
 * java.io.File 测试类
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年1月8日
 */
public class FileTest {
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		separator();
		tmpdir();
		readFile();
	}

	/**
	 * 系统分隔符 void
	 */
	public static void separator() {
		System.out.println(File.separator);
	}

	/**
	 * 系统临时目录 void
	 */
	public static void tmpdir() {
		System.out.println(System.getProperty("java.io.tmpdir"));
	}

	public static void readFile() throws IOException {
		File file = new File("C:\\Users\\qinjunjie.JIUQI\\Desktop\\2019-12-11_183436.log");
		List<String> allLines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
		for (String line : allLines) {
			if (line.contains("resolved")) {
				System.out.println(line);
			}
//			if (!line.startsWith("\t") && !line.startsWith("表：") && !line.startsWith("致命错误")
//					&& !line.startsWith("Log Time:") && !line.startsWith("Message:")
//					&& !line.startsWith("com.jiuqi.dna.core.spi.sql.SQLCombinedException") && !line.startsWith("行") 
//					) {
//				System.out.println(line);
//			}
		}
	}

}