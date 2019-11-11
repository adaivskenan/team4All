/**
 * 
 */
package com.adaivskenan.test.ioc.bean;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author adaivskenan
 *
 */
public class BeanDefinitionTest {

	@Test
	public void testComposionXml() {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/adaivskenan/test/ioc/assit/composing.xml");
		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (int i = 0; i < beanDefinitionNames.length; i++) {
			String beanDefinitionName = beanDefinitionNames[i];
			Object bean = context.getBean(beanDefinitionName);
			System.out.println(beanDefinitionName+"--"+bean);
		}
		
	}
	
}
