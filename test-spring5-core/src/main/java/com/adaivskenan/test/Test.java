/**
 * 
 */
package com.adaivskenan.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author qinjunjie
 *
 */
@Controller
public class Test {

	@RequestMapping(value = "/n", method = RequestMethod.GET)
    public void method(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("123123123123");
//		request.getRequestDispatcher("./page.html?para=some").forward(request, response);
		System.out.println(request.getRequestURL());
		response.sendRedirect("n/page.html");
    }
}
