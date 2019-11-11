package com.adaivskenan.test.ioc.bean;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryTest {
	
	@Test
	public void testBeanFactory() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/adaivskenan/test/ioc/assit/composing.xml");
		ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
		BeanDefinition beanDefinition = beanFactory.getBeanDefinition("petStore");
		System.out.println(beanDefinition.toString());
		
	}

}
