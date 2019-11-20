/**
 * 
 */
package com.adaivskenan.test.ioc.annotation_based_container_configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author adaivskenan
 *
 */
@SpringJUnitConfig
public class MovieRecommender {
	
	private CustomerPreferenceDao customerPreferenceDao;
	
	private MovieFinder movieFinder;

	
	private MovieCatalog movieCatalog;

	
	
	/*
	 * As of Spring Framework 4.3, an @Autowired annotation on such a constructor is
	 * no longer necessary if the target bean defines only one constructor to begin
	 * with. However, if several constructors are available, at least one must be
	 * annotated with @Autowired in order to instruct the container which one to
	 * use.
	 */
	
	@Autowired
	public MovieRecommender(CustomerPreferenceDao customerPreferenceDao) {
		this.customerPreferenceDao = customerPreferenceDao;
	}
	
	@Autowired
	public void setMovieFinder(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}
	
	@Autowired
	public void prepare(MovieCatalog movieCatalog, CustomerPreferenceDao customerPreferenceDao) {
		this.movieCatalog = movieCatalog;
		this.customerPreferenceDao = customerPreferenceDao;
	}
	
	
	@Test
	public void testAutowired() {
		System.out.println(this.movieFinder);
		System.out.println(this.customerPreferenceDao);
	}
	
	
}
