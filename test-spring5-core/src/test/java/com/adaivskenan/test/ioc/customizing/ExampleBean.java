/**
 * 
 */
package com.adaivskenan.test.ioc.customizing;

import org.springframework.stereotype.Component;

/**
 * @author qinjunjie
 *
 */

@Component
public class ExampleBean {
	
	public void init() {
		System.err.println("ExampleBean init()");
	}
	
	public void destroy() {
		System.err.println("ExampleBean destroy()");
	}
	
}
