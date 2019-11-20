/**
 * 
 */
package com.adaivskenan.test.ioc.customizing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author adaivskenan
 *
 */

@SpringJUnitConfig
@Configuration
@ComponentScan(basePackages = "com.adaivskenan.test.ioc.customizing")
public class LifecycleCallbacks {
	
	@Autowired
	ExampleBean exampleBean;
	
	@Test
	public void testAutoDe() {
		System.out.println(exampleBean);
	}
	
	

}
