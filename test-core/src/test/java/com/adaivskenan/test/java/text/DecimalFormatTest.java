/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： java.text
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年3月20日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.test.java.text;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Random;

/**
 * <p>
 * java.text.DecimalFormat
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年3月20日
 */

public class DecimalFormatTest {

	public static final DecimalFormat doubleFormat = new DecimalFormat("######0.00");

	/**
	 * 
	 * @param args
	 *            void
	 */
	public static void main(String[] args) {
		for(int i=0; i<2; i++){
			new Thread(new Test()).start();
		}
	}

}

class Test implements Runnable{
	
	@Override
	public void run() {
		double num = Math.random()*100;
		BigDecimal numBig = new BigDecimal(num);
		Random random =  new Random();
		String numStr1 ;
		String numStr2 ;
		if(random.nextBoolean()){
			numStr2 = DecimalFormatTest.doubleFormat.format(numBig);
			numStr1 = DecimalFormatTest.doubleFormat.format(num);
		}else{
			numStr1 = DecimalFormatTest.doubleFormat.format(num);
			numStr2 = DecimalFormatTest.doubleFormat.format(numBig);
		}
		
		if(!numStr1.equals(numStr2)){
			System.out.println(num + "--" + numStr1 + ":" + numStr2);
		}
//		try {
//			System.out.println(num + ":" + DecimalFormatTest.doubleFormat.parse(numStr));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
	}
	
}