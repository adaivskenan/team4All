/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2012
 * 包： com.adaivskenan.cache.guava
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年8月15日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.cache.guava;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * <p>
 * Guava测试
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年8月15日
 */

public class TestCallable {

	/**
	 * 
	 * @param args void
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void main(String[] args) throws ExecutionException {
		Cache<Object, Object> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
		// 从缓存中加载数据，没有则会加入缓存
		String str = "";
		for (int i = 0; i < 20; i++) {
			str = (String) cache.get("test", new Callable<String>() {

				@Override
				public String call() throws Exception {
					System.out.println("load cache");
					return "test-value";
				}
			});

		}
		System.out.println(str);
	}

}
