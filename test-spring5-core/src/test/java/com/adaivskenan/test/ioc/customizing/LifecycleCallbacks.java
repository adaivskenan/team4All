/**
 * 
 */
package com.adaivskenan.test.ioc.customizing;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author adaivskenan
 *
 */

@SpringJUnitConfig
@Configuration
@ComponentScan(basePackages = "com.adaivskenan.test.ioc.customizing")
public class LifecycleCallbacks {
	
	@Lazy
	ExampleBean exampleBean;
	
	@Test
	public void testAutoDe() {
		ApplicationContext context = new AnnotationConfigApplicationContext(LifecycleCallbacks.class);
		System.out.println(exampleBean);
	}
	
	

}
