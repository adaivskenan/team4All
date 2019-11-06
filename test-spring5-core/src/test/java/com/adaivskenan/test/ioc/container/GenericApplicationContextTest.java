/**
 * 
 */
package com.adaivskenan.test.ioc.container;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import com.adaivskenan.test.ioc.assit.services.PetStoreServiceImpl;

/**
 * @author adaivskenan
 *
 */
public class GenericApplicationContextTest {

	@Test
	public void testComposionXml() {

		/*
		 * You can mix and match such reader delegates on the same ApplicationContext,
		 * reading bean definitions from diverse configuration sources.
		 */

		GenericApplicationContext context = new GenericApplicationContext();
		new XmlBeanDefinitionReader(context).loadBeanDefinitions("com/adaivskenan/test/ioc/assit/composing.xml");
		context.refresh();
		System.out.println(context.getBean(PetStoreServiceImpl.class));
	}

}
