/**
 * 
 */
package com.adaivskenan.test.ioc.annotation_based_container_configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author adaivskenan
 *
 */
public class SimpleMovieLister {

	@Autowired
	private MovieFinder movieFinder;

	public void setMovieFinder(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}

	@Test
	public void testRequiredAnnotation() {
		GenericApplicationContext context = new GenericApplicationContext();
		new XmlBeanDefinitionReader(context).loadBeanDefinitions(
				"com/adaivskenan/test/ioc/annotation_based_container_configuration/context-annotation-config.xml");
		context.refresh();
		System.out.println(new SimpleMovieLister().movieFinder.toString());
	}

}
