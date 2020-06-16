package com.adaivskenan.test;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Controller
public class Test {

	public static void main(String[] args) throws IOException {
		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
		RequestBody body = RequestBody.create(mediaType, "sjson =%7B%7D");
		Request request = new Request.Builder()
		  .url("http://www.sina.com")
		  .post(body)
		  .addHeader("content-type", "application/x-www-form-urlencoded")
		  .addHeader("cache-control", "no-cache")
		  .addHeader("postman-token", "884656da-7c90-1b8b-b0b2-23189aea962b")
		  .build();

		Response response = client.newCall(request).execute();
		System.out.println(response.message());
		System.out.println(response.toString());

	}
	
	@RequestMapping(value = "/n", method = RequestMethod.GET)
	public void method(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("123123123123");
//		request.getRequestDispatcher("./page.html?para=some").forward(request, response);
		System.out.println(request.getRequestURL());
		response.sendRedirect("n/page.html");
	}

}
