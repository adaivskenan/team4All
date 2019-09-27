/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.test.java.text
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年1月31日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.test.java.text;

import java.text.*;
/**
 * <p>java.text.MessageFormat 测试类</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年1月31日
 */

public class MessageFormatTest {
	public static void main(String[] args) {
		
		String pattern = "Dear {0}, I have to tell you the truth, I am {1}";
		System.out.println(MessageFormat.format(pattern, "Alex", "MessageFormat"));
	}

}
