/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.observer.java
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月7日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.gof.observer.java;

import java.util.Observable;

/**
 * <p>TODO 类描述</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年2月7日
 */

public class Concrete4JObserver implements java.util.Observer {
    //观察者的状态
    @SuppressWarnings("unused")
	private String observerState;


    /**
     * @param o 被观察着对象
     * @param arg 参数对象
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("更新观察者,参数：" + arg.toString());

    }
}
