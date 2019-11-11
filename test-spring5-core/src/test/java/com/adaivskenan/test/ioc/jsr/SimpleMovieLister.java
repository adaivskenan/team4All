/**
 * 
 */
package com.adaivskenan.test.ioc.jsr;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.adaivskenan.test.ioc.assit.jsr.MovieFinder;

/**
 * @author adaivskenan
 *
 */
@SpringJUnitConfig
public class SimpleMovieLister {

	@Autowired
	private MovieFinder movieFinder;

	public void setMovieFinder(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}

	public void listMovies() {
		System.out.println(movieFinder);

	}
	
	@Test
	public void testInject() {
		listMovies();
		
	}

}
