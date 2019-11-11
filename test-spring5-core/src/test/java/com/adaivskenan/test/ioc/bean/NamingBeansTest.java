/**
 * 
 */
package com.adaivskenan.test.ioc.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author adaivskenan
 *
 */
public class NamingBeansTest {

	@Test
	public void testId() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/adaivskenan/test/ioc/assit/services2.xml", "com/adaivskenan/test/ioc/assit/daos.xml");
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("petStore");
//		BeanDefinition beanDefinition1 = beanFactory.getBeanDefinition("petStore_name");
		BeanDefinition beanDefinition2 = beanFactory.getBeanDefinition("petStore_name2");
//		BeanDefinition beanDefinition3 = beanFactory.getBeanDefinition("petStore_name3");
		System.err.println(beanDefinition);
//		System.err.println(beanDefinition1);
		System.err.println(beanDefinition2);
//		System.err.println(beanDefinition3);
	}
	
	@Test
	public void testNull_Id_Name() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"com/adaivskenan/test/ioc/assit/services2.xml", "com/adaivskenan/test/ioc/assit/daos.xml");
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (int i = 0; i < beanDefinitionNames.length; i++) {
			String beanDefinitionName = beanDefinitionNames[i];
			Object bean = context.getBean(beanDefinitionName);
			System.out.println(beanDefinitionName+"--"+bean);
		}
	}

}
