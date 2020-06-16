package com.adaivskenan.test.cp05_aopprogramming.demo;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration("classpath:com/adaivskenan/test/cp05_aopprogramming/demo/context.xml")
public class Demo {
	@Resource(name = "userService")
	private UserService us;

	@Test
	public void fun1() {
		us.save();
	}

}