/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2012
 * 包： com.adaivskenan.test.java.lang.annotation
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年9月30日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.test.java.lang.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(CLASS)
@Target(TYPE)
/**
 * <p>TODO 类描述</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年9月30日
 */

public @interface MyAnnotation1 {

}


/*(01) @interface
使用@interface定义注解时，意味着它实现了java.lang.annotation.Annotation接口，即该注解就是一个Annotation。
定义Annotation时，@interface是必须的。
注意：它和我们通常的implemented实现接口的方法不同。Annotation接口的实现细节都由编译器完成。通过@interface
定义注解后，该注解不能继承其他的注解或接口。

(02) @Documented 
类和方法的Annotation在缺省情况下是不出现在javadoc中的。如果使用@Documented修饰该Annotation，则表示它可以
出现在javadoc中。定义Annotation时，@Documented可有可无；若没有定义，则Annotation不会出现在javadoc中。

(03) @Target(ElementType.TYPE)
前面我们说过，ElementType 是Annotation的类型属性。而@Target的作用，就是来指定Annotation的类型属性。
@Target(ElementType.TYPE) 的意思就是指定该Annotation的类型是ElementType.TYPE。这就意味着，MyAnnotation1
是来修饰“类、接口（包括注释类型）或枚举声明”的注解。定义Annotation时，@Target可有可无。若有@Target，则该
Annotation只能用于它所指定的地方；若没有@Target，则该Annotation可以用于任何地方。

(04) @Retention(RetentionPolicy.RUNTIME)
前面我们说过，RetentionPolicy 是Annotation的策略属性，而@Retention的作用，就是指定Annotation的策略属性。
@Retention(RetentionPolicy.RUNTIME) 的意思就是指定该Annotation的策略是RetentionPolicy.RUNTIME。这就意
味着，编译器会将该Annotation信息保留在.class文件中，并且能被虚拟机读取。定义Annotation时，@Retention可有
可无。若没有@Retention，则默认是RetentionPolicy.CLASS。*/








