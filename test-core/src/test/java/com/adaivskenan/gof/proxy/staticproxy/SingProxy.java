/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.proxy.staticproxy
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月5日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.gof.proxy.staticproxy;

/**
 * <p>静态代理</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年2月5日
 */

public class SingProxy implements IDoSomething{
	//接收保存目标对象
	private IDoSomething sing = new Sing();

	@Override
	public int doSometing(int num) {
		System.out.println("Befor singing ");
        int result = sing.doSometing(num);
        System.out.println("After singing");
        return result;
	}

}
