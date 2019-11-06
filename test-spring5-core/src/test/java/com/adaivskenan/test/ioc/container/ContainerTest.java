/**
 * 
 */
package com.adaivskenan.test.ioc.container;

/**
 * @author adaivskenan
 *
 */
public class ContainerTest {

	/**
	 * IOC (Inversion of Control)
	 * 
	 * IOC is a process whereby objects define their dependencies (that is, the
	 * other objects they work with) only through constructor arguments, arguments
	 * to a factory method, or properties that are set on the object instance after
	 * it is constructed or returned from a factory method.
	 * 
	 * 
	 * using direct construction of classes or a mechanism such as the Service
	 * Locator pattern
	 * 
	 * The org.springframework.beans and org.springframework.context packages are
	 * the basis for Spring Framework’s IoC container
	 */

	/**
	 * 
	 * BeanFactory & ApplicationContext
	 * 
	 * The BeanFactory interface provides an advanced configuration mechanism
	 * capable of managing any type of object.
	 * 
	 * ApplicationContext is a sub-interface of BeanFactory .It adds:
	 * 
	 * Easier integration with Spring’s AOP features
	 * 
	 * Message resource handling (for use in internationalization)
	 * 
	 * Event publication
	 * 
	 * Application-layer specific contexts such as the WebApplicationContext for use
	 * in web applications.
	 */

	/**
	 * Bean
	 * 
	 * A bean is an object that is instantiated, assembled, and otherwise managed by
	 * a Spring IoC container.
	 */

	/**
	 * 
	 * configuration metadata
	 * 
	 * XML
	 * Java annotations		(Spring 2.5）
	 * Java code			(Spring 3)
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Learn Container");
	}

}
