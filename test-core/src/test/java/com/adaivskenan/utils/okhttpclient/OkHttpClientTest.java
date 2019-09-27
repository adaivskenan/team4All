package com.adaivskenan.utils.okhttpclient;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class OkHttpClientTest {

	public static void main(String[] args) throws IOException {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
		  .url("https://api.crccig.com/portal/interface/toDo/insert")
		  .post(new RequestBody() {
			
			@Override
			public void writeTo(BufferedSink sink) throws IOException {
				
			}
			
			@Override
			public MediaType contentType() {
				return null;
			}
		})
		  .addHeader("apikey", "8hWLxqNjtwn0YfTJw3ShD7lGruvA54pR")
		  .addHeader("Host", "work.crccig.com")//do not need set System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
		  .addHeader("Content-Type", "application/x-www-form-urlencoded")
		  .addHeader("Cache-Control", "no-cache")
//		  .addHeader("Postman-Token", "c81b998f-f274-49a1-b12d-88c07fb8b05f")
		  .build();

		Response response = client.newCall(request).execute();
		System.out.println(response.message()+response.body().string());
	}

}
