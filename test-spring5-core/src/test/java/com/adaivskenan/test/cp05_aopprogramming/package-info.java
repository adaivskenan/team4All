
/**
 * https://docs.spring.io/spring/docs/5.2.0.RELEASE/spring-framework-reference/core.html#aop-introduction-defn
 */
package com.adaivskenan.test.cp05_aopprogramming;
/*
 *
 * Aspect: A modularization of a concern that cuts across multiple classes.
 * Transaction management is a good example of a crosscutting concern in
 * enterprise Java applications. In Spring AOP, aspects are implemented by using
 * regular classes (the schema-based approach) or regular classes annotated with
 * the @Aspect annotation (the @AspectJ style).
 * 
 * Join point: A point during the execution of a program, such as the execution
 * of a method or the handling of an exception. In Spring AOP, a join point
 * always represents a method execution.
 * 
 * Advice: Action taken by an aspect at a particular join point. Different types
 * of advice include “around”, “before” and “after” advice. (Advice types are
 * discussed later.) Many AOP frameworks, including Spring, model an advice as
 * an interceptor and maintain a chain of interceptors around the join point.
 * 
 * Pointcut: A predicate that matches join points. Advice is associated with a
 * pointcut expression and runs at any join point matched by the pointcut (for
 * example, the execution of a method with a certain name). The concept of join
 * points as matched by pointcut expressions is central to AOP, and Spring uses
 * the AspectJ pointcut expression language by default.
 * 
 * Introduction: Declaring additional methods or fields on behalf of a type.
 * Spring AOP lets you introduce new interfaces (and a corresponding
 * implementation) to any advised object. For example, you could use an
 * introduction to make a bean implement an IsModified interface, to simplify
 * caching. (An introduction is known as an inter-type declaration in the
 * AspectJ community.)
 * 
 * Target object: An object being advised by one or more aspects. Also referred
 * to as the “advised object”. Since Spring AOP is implemented by using runtime
 * proxies, this object is always a proxied object.
 * 
 * AOP proxy: An object created by the AOP framework in order to implement the
 * aspect contracts (advise method executions and so on). In the Spring
 * Framework, an AOP proxy is a JDK dynamic proxy or a CGLIB proxy.
 * 
 * Weaving: linking aspects with other application types or objects to create an
 * advised object. This can be done at compile time (using the AspectJ compiler,
 * for example), load time, or at runtime. Spring AOP, like other pure Java AOP
 * frameworks, performs weaving at runtime.
 */

/*
 * 切面（Aspect）：
 * 		一个关注点的模块化，这个关注点可能会横切多个对象。事务管理是J2EE应用中一个关于横切关注点的很好的例子。在Spring
 * AOP中，切面可以使用基于模式或者基于@Aspect注解的方式来实现。
 * 
 * 连接点（Joinpoint）：
 * 	在程序执行过程中某个特定的点，比如某方法调用的时候或者处理异常的时候。在Spring
 * AOP中，一个连接点总是表示一个方法的执行。
 * 
 * 通知（Advice）：
 * 		在切面的某个特定的连接点上执行的动作。其中包括了“around”、“before”和“after”等不同类型的通知（
 * 通知的类型将在后面部分进行讨论）。许多AOP框架（包括Spring）都是以拦截器做通知模型，并维护一个以连接点为中心的拦截器链。
 * 
 * 切入点（Pointcut）：
 * 		匹配连接点的断言。通知和一个切入点表达式关联，并在满足这个切入点的连接点上运行（例如，当执行某个特定名称的方法时）。
 * 切入点表达式如何和连接点匹配是AOP的核心：Spring缺省使用AspectJ切入点语法。
 * 
 * 引入（Introduction）：
 * 		用来给一个类型声明额外的方法或属性（也被称为连接类型声明（inter-type
 * declaration））。Spring允许引入新的接口（以及一个对应的实现）到任何被代理的对象。例如，
 * 你可以使用引入来使一个bean实现IsModified接口，以便简化缓存机制。
 * 
 * 目标对象（Target Object）：
 * 	被一个或者多个切面所通知的对象。也被称做被通知（advised）对象。既然Spring
 * AOP是通过运行时代理实现的，这个对象永远是一个被代理（proxied）对象。
 * 
 * AOP代理（AOP Proxy）：
 * AOP框架创建的对象，用来实现切面契约（例如通知方法执行等等）。在Spring中，AOP代理可以是JDK动态代理或者CGLIB代理。
 * 
 * 织入（Weaving）： 
 * 把切面连接到其它的应用程序类型或者对象上，并创建一个被通知的对象。这些可以在编译时（例如使用AspectJ编译器），
 * 类加载时和运行时完成。Spring和其他纯Java AOP框架一样，在运行时完成织入。
 */