/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2012
 * 包： com.adaivskenan.cache.guava
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年8月15日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.cache.guava;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

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

public class TestCacheLoader {

	/**
	 * 
	 * @param args void
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 缓存接口为LoadingCache，LoadingCache在缓存项不存在时可以自动加载缓存
		LoadingCache<Integer, String> strCache = CacheBuilder.newBuilder()// 构建工程方式创建builder
				.concurrencyLevel(8)// 设置并发级别，同时写缓存的线程数
				.expireAfterWrite(8, TimeUnit.SECONDS)// 8秒过期
				.initialCapacity(10)// 初始容器大小
				.maximumSize(100)// 超过100后按照LRU移除缓存
				.recordStats()// 设置要统计缓存的命中率
				// 设置缓存移除的通知
				.removalListener(new RemovalListener<Object, Object>() {

					@Override
					public void onRemoval(RemovalNotification<Object, Object> notification) {
						System.out.println(notification.getKey() + " was removed. cause is " + notification.getCause());
					}
				})
				// 设置CacheLoader，在缓存不存在时通过CacheLoader自动加载缓存
				.build(new CacheLoader<Integer, String>() {

					@Override
					public String load(Integer key) throws Exception {
						System.out.println("load data:" + key);
						String str = key + ":cache-value";
						return str;
					}
				});

		for (int i = 0; i < 20; i++) {
			// 从缓存中加载数据，没有则会加入缓存
			String str = strCache.get(1);
			System.out.println(str);
			//
			TimeUnit.SECONDS.sleep(1);
		}
		// 命中率
		System.out.println("cache stats:\n" + strCache.stats().toString());
	}

}
