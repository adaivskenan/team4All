/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.proxy.cglib
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月5日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.gof.proxy.cglib;

import java.lang.reflect.Method;

import org.mockito.cglib.proxy.Enhancer;
import org.mockito.cglib.proxy.MethodInterceptor;
import org.mockito.cglib.proxy.MethodProxy;

/**
 * <p>Cglib动态代理</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年2月5日
 */

public class CglibProxy implements MethodInterceptor {

	private Enhancer enhancer = new Enhancer();
    @Override
    /**
     * 
     * @param o 是被代理对象
     * @param method 调用方法的Method对象
     * @param args 方法参数
     * @param methodProxy
     * @return cglib生成用来代替Method对象的一个对象，使用MethodProxy比调用JDK自身的Method直接执行方法效率会有提升
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] args,
            MethodProxy methodProxy) throws Throwable {
        System.out.println("before " + methodProxy.getSuperName());  
        System.out.println(method.getName());  
        Object o1 = methodProxy.invokeSuper(o, args);  
        //Object o2 = method.invoke(o, args); 使用这种方式会发生死循环，因为方法会被拦截
        System.out.println("after " + methodProxy.getSuperName());  
        return o1;  
    }
    
    public  Object newProxyInstance(Class<?> c) {
        //Set the class which the generated class will extend
        enhancer.setSuperclass(c); 
        //the callback to use for all methods
        enhancer.setCallback(this);  
        //使用默认无参数的构造函数创建目标对象 
        return enhancer.create();  
    }


}
