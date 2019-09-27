/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2012
 * 包： com.adaivskenan.utils
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年8月17日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.utils;

/**
 * <p>TODO 类描述</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年8月17日
 */

public class GUIDTest {

	/**
	 * 
	 * @param args void
	 */
	public static void main(String[] args) {
		long L = (1<<16L)+3;
		System.out.println(L + ":" + (byte)L);
		System.out.println(5361354777945072559L + ":" + (byte)5361354777945072559L);
		//‭0100 1010 0110 0111 0101 1011 1100 0011 1100 1110 0100 0010 0110 0011 1010 1111
		//1010 1111 -->‬ 反码--> 1101 0000-->补码-->1101 0001-->-81
		String guid = GUID.randomID().toString();
		GUID guid01 = GUID.valueOf(guid);
		GUID guid02 = GUID.valueOf(guid);

		synchronized (guid01){
			synchronized(guid02) {
				System.out.println(guid01);
			}
		}
		System.out.println(guid01);
		System.out.println(guid02);
	}

}
