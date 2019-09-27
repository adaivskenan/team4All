/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.visitor
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年1月31日       qinjunjie        
 * ============================================================*/

/**
 * <p>VISITOR</p>
 *	访问者模式：访问者模式的目的是封装一些施加于某种数据结构元素之上的
 *	操作。一旦这些操作需要修改的话，接受这个操作的数据结构可以保持不变。
 *	访问者模式适用于数据结构相对未定的系统，它把数据结构和作用于结构上
 *	的操作之间的耦合解脱开，使得操作集合可以相对自由的演化。访问者模式
 *	使得增加新的操作变的很容易，就是增加一个新的访问者类。访问者模式将
 *	有关的行为集中到一个访问者对象中，而不是分散到一个个的节点类中。当
 *	使用访问者模式时，要将尽可能多的对象浏览逻辑放在访问者类中，而不是
 *	放到它的子类中。访问者模式可以跨过几个类的等级结构访问属于不同的等
 *	级结构的成员类。
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年1月31日
 */

package com.adaivskenan.gof.visitor;