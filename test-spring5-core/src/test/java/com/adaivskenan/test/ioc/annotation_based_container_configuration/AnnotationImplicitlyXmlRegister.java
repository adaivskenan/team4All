/**
 * 
 */
package com.adaivskenan.test.ioc.annotation_based_container_configuration;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author adaivskenan
 *
 */
public class AnnotationImplicitlyXmlRegister {

	@Test
	public void testComposionXml() {

		GenericApplicationContext context = new GenericApplicationContext();
		new XmlBeanDefinitionReader(context).loadBeanDefinitions(
				"com/adaivskenan/test/ioc/annotation_based_container_configuration/context-annotation-config.xml");
		context.refresh();
		AbstractBeanFactory beanFactory = (AbstractBeanFactory) context.getBeanFactory();
		List<BeanPostProcessor> beanPostProcessors = beanFactory.getBeanPostProcessors();
		for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
			System.out.println(beanPostProcessor.toString());
		}

//		org.springframework.context.support.ApplicationContextAwareProcessor@30c15d8b
//		org.springframework.context.annotation.ConfigurationClassPostProcessor$ImportAwareBeanPostProcessor@5e0e82ae
//		org.springframework.context.support.PostProcessorRegistrationDelegate$BeanPostProcessorChecker@6771beb3
//		org.springframework.context.annotation.CommonAnnotationBeanPostProcessor@51399530
//		org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor@6b2ea799
//		org.springframework.context.support.ApplicationListenerDetector@3d0f8e03
	}

}
