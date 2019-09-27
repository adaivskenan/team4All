/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.observer.java
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月7日       qinjunjie        
 * ============================================================*/

/**
 * <p>java 观察者模式</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年2月7日
 */

package com.adaivskenan.gof.observer.java;


/**
 * JDK中包提供两个类来提供观察者模式的支持
 * ，Observable对应上例中的Subject是被观察者，java.util.Observer对应上例中的Observer是观察者接口。
 * 	XXX : Observable中大量的锁控制并发，感觉性能不高，日后再做探究
 * 一个被观测的对象必须服从下面的两个简单规则：
 * 
 * 	第一，如果它被改变了，它必须调用setChanged()方法。
 * 	第二，当它准备通知观测程序它的改变时，它必须调用notifyObservers()方法，
 * 这导致了在观测对象中对update()方法的调用。
 */

/*
 * 如果在调用notifyObservers()方法之前没有调用setChanged()方法，就不会有什么动作发生。
 * notifyObservers()方法中包含clearChanged()方法，将标志变量置回原值。
 * notifyObservers()方法采用的是从后向前的遍历方式，即最后加入的观察者最先被调用update()方法。
 * notifyObservers()方法在循环调用观察者的update()方法时并没有做任何异常处理，实际上也无法处理异常，
 * 因为也不知道该如何处理，所以实现观察者的update()方法时要自己处理异常，否则发生异常会导致无法通知剩下的观察者
 */


