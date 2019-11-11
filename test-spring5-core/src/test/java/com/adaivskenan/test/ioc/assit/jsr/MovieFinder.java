package com.adaivskenan.test.ioc.assit.jsr;

import java.util.UUID;

import org.springframework.stereotype.Component;


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
