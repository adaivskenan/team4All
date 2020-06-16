/**
 * 
 */
package com.adaivskenan.test.cp05_aopprogramming;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author adaivskenan
 *
 */

public class AspectTest {

	@Test
	public void testAop() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		this.find();
	}
	
	
	private boolean find() {
		System.out.println("-----------find------------");
		return true;
	}
}
