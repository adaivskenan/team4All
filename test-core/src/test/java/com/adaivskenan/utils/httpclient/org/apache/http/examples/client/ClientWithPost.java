/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2012
 * 包： com.adaivskenan.utils.httpclient.org.apache.http.examples.client
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年9月30日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.utils.httpclient.org.apache.http.examples.client;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * <p>TODO 类描述</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年9月30日
 */

public class ClientWithPost {

	/**
	 * 
	 * @param args void
	 * @throws IOException 
	 * @throws  
	 */
	public static void main(String[] args) throws IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpPost httppost = new HttpPost("http://58.213.100.35:8082/portal/checkCustSupplier");
            httppost.setHeader("authcode", "20180927..");
            httppost.setHeader("syscode", "CRCCSC");
            httppost.setHeader("Content-Type","application/x-www-form-urlencoded");
            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            nvps.add(new BasicNameValuePair("creditcode", "12313131313"));
            httppost.setEntity(new UrlEncodedFormEntity(nvps));            
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                System.out.println(EntityUtils.toString(response.getEntity()));
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
	}

}
