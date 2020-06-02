package com.example.demo;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {
	
	AtomicInteger atomicInt = new AtomicInteger(0);
	
	private Logger logger = LoggerFactory.getLogger(ConsumerService.class);
 
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
 
    // 使用JmsListener配置消费者监听的队列，其中name是接收到的消息
    @JmsListener(destination = "ActiveMQQueue")
    public String handleMessage(String name) {
        throw new RuntimeException("次数" + atomicInt.addAndGet(1) + "消息：" + name);
    }

}