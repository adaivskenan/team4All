package com.example.demo;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	public Queue queue() {
		return new ActiveMQQueue("DQL");
	}

}
