/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.proxy.dynamic
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月5日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.gof.proxy.dynamic;

/**
 * <p>TODO 类描述</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年2月5日
 */

public class ProxyClassImpl implements IProxyClass {

	/* (non-Javadoc)
	 * @see com.adaivskenan.gof.proxy.dynamic.IProxyClass#doSomething(int)
	 */
	@Override
	public int doSomething(int i) {
		System.out.println("方法执行中.....");
        return i;
	}

}
