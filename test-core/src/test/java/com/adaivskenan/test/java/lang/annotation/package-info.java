/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.test.lang.annotation
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年1月9日       qinjunjie        
 * ============================================================*/

/**
 * <p>
 * java annotation practice
 * </p>
 *
 * <p>
 * Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其
 * </p>
 *
 * @author qinjunjie
 * @version 2018年1月9日
 */

package com.adaivskenan.test.java.lang.annotation;

/*
 * Java Annotation认知(包括框架图、详细介绍、示例说明)
 * 
 * 
 * 摘要
 * 
 * 从中，我们可以看出：
 * 
 * (01) 1个Annotation 和 1个RetentionPolicy关联。
 * 可以理解为：每1个Annotation对象，都会有唯一的RetentionPolicy属性。
 * 
 * (02) 1个Annotation 和 1~n个ElementType关联。
 * 可以理解为：对于每1个Annotation对象，可以有若干个ElementType属性。
 * 
 * (03) Annotation 有许多实现类，包括：Deprecated, Documented, Inherited, Override等等。
 * Annotation 的每一个实现类，都“和1个RetentionPolicy关联”并且“和1~n个ElementType关联”。
 * 
 * java.lang.annotation.Annotation
 * 
 * java.lang.annotation.ElementType
 * 
 * 
 * java.lang.annotation.RetentionPolicy
 * 
 * 
 * 
 * 说明：
(01) Annotation 就是个接口。
      “每1个Annotation” 都与 “1个RetentionPolicy”关联，并且与 “1～n个ElementType”关联。可以通俗的理解为：每1个Annotation对象，都会有唯一的RetentionPolicy属性；至于ElementType属性，则有1~n个。

(02) ElementType 是Enum枚举类型，它用来指定Annotation的类型。
      “每1个Annotation” 都与 “1～n个ElementType”关联。当Annotation与某个ElementType关联时，就意味着：Annotation有了某种用途。
      例如，若一个Annotation对象是METHOD类型，则该Annotation只能用来修饰方法。

(03) RetentionPolicy 是Enum枚举类型，它用来指定Annotation的策略。通俗点说，就是不同RetentionPolicy类型的Annotation的作用域不同。
      “每1个Annotation” 都与 “1个RetentionPolicy”关联。
      a) 若Annotation的类型为 SOURCE，则意味着：Annotation仅存在于编译器处理期间，编译器处理完之后，该Annotation就没用了。
          例如，“ @Override ”标志就是一个Annotation。当它修饰一个方法的时候，就意味着该方法覆盖父类的方法；并且在编译期间会进行语法检查！编译器处理完后，“@Override”就没有任何作用了。
      b) 若Annotation的类型为 CLASS，则意味着：编译器将Annotation存储于类对应的.class文件中，它是Annotation的默认行为。
      c) 若Annotation的类型为 RUNTIME，则意味着：编译器将Annotation存储于class文件中，并且可由JVM读入。

这时，只需要记住“每1个Annotation” 都与 “1个RetentionPolicy”关联，并且与 “1～n个ElementType”关联。学完后面的内容之后，再回头看这些内容，会更容易理解。
 * 
 * 
 */