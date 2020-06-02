package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class TesetAmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(TesetAmqApplication.class, args);
	}

}
