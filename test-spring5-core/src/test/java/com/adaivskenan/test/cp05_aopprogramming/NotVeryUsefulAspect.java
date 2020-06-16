package com.adaivskenan.test.cp05_aopprogramming;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Aspect注解将一个java类定义为切面类
 * @Pointcut定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等。 @Before在切入点开始处切入内容
 * @After在切入点结尾处切入内容
 * @AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理） @Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
 * @AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑
 */

@Aspect
public class NotVeryUsefulAspect {
	/**
	 * execution - 匹配方法执行的连接点，这是你将会用到的Spring的最主要的切入点指示符。
	 * 
	 * within - 限定匹配特定类型的连接点（在使用Spring AOP的时候，在匹配的类型中定义的方法的执行）。
	 * 
	 * this - 限定匹配特定的连接点（使用Spring AOP的时候方法的执行），其中bean reference（Spring AOP
	 * 代理）是指定类型的实例。
	 * 
	 * target - 限定匹配特定的连接点（使用Spring AOP的时候方法的执行），其中目标对象（被代理的应用对象）是指定类型的实例。
	 * 
	 * args - 限定匹配特定的连接点（使用Spring AOP的时候方法的执行），其中参数是指定类型的实例。
	 * 
	 * @target - 限定匹配特定的连接点（使用Spring AOP的时候方法的执行），其中正执行对象的类持有指定类型的注解。
	 * 
	 * @args - 限定匹配特定的连接点（使用Spring AOP的时候方法的执行），其中实际传入参数的运行时类型持有指定类型的注解。
	 * 
	 * @within - 限定匹配特定的连接点，其中连接点所在类型已指定注解（在使用Spring AOP的时候，所执行的方法所在类型已指定注解）。
	 * 
	 * @annotation - 限定匹配特定的连接点（使用Spring AOP的时候方法的执行），其中连接点的主题持有指定的注解。
	 * 
	 */
	@Pointcut("execution(* com.adaivskenan.test.cp05_aopprogramming.AspectTest.find*(..))")
	private void pointCut() {
		System.out.println("pointcut-----");
	}

	@Before(value = "")
	private void before() {
		System.out.println("before-----");
	}

	@After(value = "")
	private void after() {
		System.out.println("after-----");
	}

	@AfterReturning
	private void afterReturing() {
		System.out.println("afterReturing-----");
	}

	@Around(value = "")
	private void Around() {
		System.out.println("Around-----");
	}

	@AfterThrowing
	private void AfterThrowing() {
		System.out.println("AfterThrowing-----");
	}
	
}