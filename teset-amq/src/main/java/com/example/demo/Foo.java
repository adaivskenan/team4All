package com.example.demo;
import org.apache.activemq.RedeliveryPolicy;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQConnectionFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Foo
{
	@Bean
    public ActiveMQConnectionFactoryCustomizer configureRedeliveryPolicy() {
        return connectionFactory ->
        {
            RedeliveryPolicy redeliveryPolicy = new RedeliveryPolicy();
            // configure redelivery policy
            redeliveryPolicy.setMaximumRedeliveries(0);//客户端不重试可以保证接受重试次数与服务端配置一致
            connectionFactory.setRedeliveryPolicy(redeliveryPolicy);
        };
    }
}