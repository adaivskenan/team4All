/**
 * 
 */
package com.adaivskenan.test.ioc.scanning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author adaivskenan
 *
 */

@Component
public class Service {

	@Autowired
	private MovieFinder movieFinder;

	public MovieFinder getMovieFinder() {
		return movieFinder;
	}

	public void setMovieFinder(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
	}
	
}
