/**
 * 
 */
package com.adaivskenan.test.ioc.scanning;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author adaivskenan
 *
 */
public class SimpleMovieLister {


	@Test
	public void testRequiredAnnotation() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(ctx.getBean(MovieFinder.class));
	}

}
