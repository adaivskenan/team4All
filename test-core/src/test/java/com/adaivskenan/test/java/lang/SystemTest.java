/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.test.lang
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年1月8日       qinjunjie        
 * ============================================================*/


package com.adaivskenan.test.java.lang;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * <p>java.lang.System 测试类</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年1月8日
 */
public class SystemTest{
	
	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		SystemTest systemtest = new SystemTest();
		getProperties();
		System.out.println(System.lineSeparator());
		//测试System.getProperty()性能500*1000*50(大约有50个默认的值)=25,000,000 大约 40s
		int countNum = 500;
		for(int j=0; j<1000; j++) {
			CountDownLatch cdl = new CountDownLatch(countNum);
			for(int i=0; i<countNum; i++) {
				new Thread(systemtest.new GetPropertiesThread(cdl)).start();
			}
			cdl.await();
		}
		System.out.println(System.currentTimeMillis()-start);
	}
	public static void getProperties(){
		Properties properties = System.getProperties();
        Set<String> names = properties.stringPropertyNames();
        for (String name : names) {
            String value = System.getProperty(name);
            System.out.println(name+ "\t"+ value);
        }
	}
	
	class GetPropertiesThread implements Runnable{
		CountDownLatch cdl;
		GetPropertiesThread(CountDownLatch cdl){
			this.cdl = cdl;
		}

		@Override
		public void run() {
			cdl.countDown();
			byte[] empty = new byte[1024*1024];
			empty.hashCode();
			Properties properties = System.getProperties();
	        Set<String> names = properties.stringPropertyNames();
	        String value = null;
	        for (String name : names) {
	            value = System.getProperty(name);
	        }
	        if(value == null) {
	        	System.out.println("NULL");
	        }
		}
		
	}
}

