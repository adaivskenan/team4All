/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.proxy.dynamic
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月5日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.gof.proxy.dynamic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import sun.misc.ProxyGenerator;

/**
 * <p>TODO 类描述</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年2月5日
 */

@SuppressWarnings("restriction")
public class DynamicProxyHandler implements InvocationHandler {

private Object proxied;
    
    /**
     * @param proxied 被代理对象
     */
    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }
    
    /**
     * 返回代理对象
     * @return
     */
    public Object newProxyInstance() {
        return Proxy.newProxyInstance(proxied.getClass().getClassLoader(), proxied.getClass().getInterfaces(), this);
    }

    /**
     * 
     * @param proxy 代理对象
     * @param method 代理方法
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { 
        //将代理对象生成字节码到F盘上，方便反编译出java文件查看，实际动态代理是不需要自己生成的
//        addClassToDisk(proxy.getClass().getName(), ProxyClassImpl.class,"E:/$Proxy0.class");
        System.out.println("method:"+method.getName());  
        System.out.println("args:"+args[0].getClass().getName());  
        System.out.println("Before invoke method...");  
        Object object=method.invoke(proxied, args);
        System.out.println("After invoke method...");  
        return object;  
    }
    
    /**
     * 用于生产代理对象的字节码，并将其保存到硬盘上
     * @param className
     * @param cl
     * @param path
     */
    private void addClassToDisk(String className, Class<?> cl, String path) {
        //用于生产代理对象的字节码
        byte[] classFile = ProxyGenerator.generateProxyClass(className, cl.getInterfaces());
        FileOutputStream out = null;  
        try {  
            out = new FileOutputStream(path);  
            //将代理对象的class字节码写到硬盘上
            out.write(classFile);  
            out.flush();  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                out.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }

}
