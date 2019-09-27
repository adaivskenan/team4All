/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2012
 * 包： com.adaivskenan.test.java.math
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年8月22日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.test.java.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <p>
 * TODO 类描述
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年8月22日
 */

public class BigDecimalTest {

	/**
	 * 
	 * @param args void
	 */
	public static void main(String[] args) {

	}

	public static BigDecimal sqrtB(BigDecimal db) {
		BigDecimal initial = db;
//		BigDecimal diff;
//		do {
//			BigDecimal sDivX = db.divide(initial, 8, RoundingMode.FLOOR);
//			BigDecimal sum = sDivX.add(initial);
//			BigDecimal div = sum.divide(TWO, 8, RoundingMode.FLOOR);
//			diff = div.subtract(initial).abs();
//			diff.setScale(8, RoundingMode.FLOOR);
//			initial = div;
//		} while (diff.compareTo(error) > 0);
		return initial;
	}

}
