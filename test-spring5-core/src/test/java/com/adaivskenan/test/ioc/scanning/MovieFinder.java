/**
 * 
 */
package com.adaivskenan.test.ioc.scanning;

import java.util.UUID;

import org.springframework.stereotype.Component;

/**
 * @author adaivskenan
 *
 */

@Component
public class MovieFinder {
	
	private UUID uuid;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	
	
}
