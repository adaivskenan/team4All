/**
 * 
 */
package com.adaivskenan.test.ioc.container;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.adaivskenan.test.ioc.assit.services.PetStoreService;
import com.adaivskenan.test.ioc.assit.services.PetStoreServiceImpl;

/**
 * @author adaivskenan
 *
 */
public class ApplicationContextTest {

	@Test
	public void testXml() {

		/**
		 * org.springframework.context.support.ClassPathXmlApplicationContext
		 * org.springframework.beans.factory.xml.XmlBeanDefinitionReader
		 * org.springframework.beans.factory.support.DefaultListableBeanFactory
		 */

		ApplicationContext context = new ClassPathXmlApplicationContext("com/adaivskenan/test/ioc/assit/services.xml",
				"com/adaivskenan/test/ioc/assit/daos.xml");
		System.out.println(context.getBean(PetStoreServiceImpl.class));

	}

	@Test
	public void testComposionXml() {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/adaivskenan/test/ioc/assit/composing.xml");
		System.out.println(context.getBean(PetStoreServiceImpl.class));
	}

	/*
	 * The namespace itself provides the import directive feature. Further
	 * configuration features beyond plain bean definitions are available in a
	 * selection of XML namespaces provided by Spring — for example, the context and
	 * util namespaces.
	 */

	@Test
	public void contextNamespaces() {

	}

	@Test
	public void UtilNamespaces() {

	}

}
