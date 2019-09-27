/**
 * 
 */
package com.adaivskenan.utils.log.logback;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author adaivskenan
 *         <ol>
 *         <li>trace (the least serious)</li>
 *         <li>debug</li>
 *         <li>info</li>
 *         <li>warn</li>
 *         <li>error</li>
 *         <li>fatal (the most serious)</li>
 *         </ol>
 */
public class LogbackTest {

	private static final Log logger = LogFactory.getLog(LogbackTest.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * org.apache.commons.logging.impl.SLF4JLocationAwareLog
		 * ch.qos.logback.classic.Logger
		 */
		// default level can not log trace information
		logger.trace("Test logback", new RuntimeException());
		//
		logger.debug("Test logback");
		logger.debug("Test logback", new RuntimeException());
		//
		logger.error("Test logback", new RuntimeException());
		// Logback does not have a FATAL level. It is mapped to ERROR .
		logger.fatal("Test logback", new RuntimeException());
	}

}
