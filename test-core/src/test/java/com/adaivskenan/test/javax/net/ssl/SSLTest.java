/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2012
 * 包： com.adaivskenan.test.javax.net.ssl
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年12月10日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.test.javax.net.ssl;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

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
 * @version 2018年12月10日
 */

public class SSLTest {
	public static void main(String[] args) throws Exception {
		System.setProperty("ssl.debug", "true");
		System.setProperty("javax.net.debug", "all");
		SSLContext context = SSLContext.getDefault();
		SSLSocketFactory sf = context.getSocketFactory();
		System.out.println(sf);
		String[] cipherSuites = sf.getSupportedCipherSuites();
		System.out.println(cipherSuites.length);
		for (String cipher : cipherSuites) {
			System.out.println(cipher);
		}
		SSLSocket socket = (SSLSocket) sf.createSocket();
		String[] protocols = socket.getSupportedProtocols();

		System.out.println("Supported Protocols: " + protocols.length);
		for (int i = 0; i < protocols.length; i++) {
			System.out.println(" " + protocols[i]);
		}

		protocols = socket.getEnabledProtocols();

		System.out.println("Enabled Protocols: " + protocols.length);
		for (int i = 0; i < protocols.length; i++) {
			System.out.println(" " + protocols[i]);
		}
	}
}
