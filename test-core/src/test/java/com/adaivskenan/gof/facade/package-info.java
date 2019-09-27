/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.gof.facade
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年1月31日       qinjunjie        
 * ============================================================*/

/**
 * <p>FACADE</p>
 *	外观模式\门面模式：外部与一个子系统的通信必须通过一个统一的门面对象进行。
 *	门面模式提供一个高层次的接口，使得子系统更易于使用。每一个子系统
 *	只有一个门面类，而且此门面类只有一个实例，也就是说它是一个单例模
 *	式。但整个系统可以有多个门面类。
 *
 *	外观模式：为子系统中的一组接口提供一个统一的入口。外观模式定义了一个高层接口，这个接口使得这
 *		一子系统更加容易使用。
 *	Facade Pattern: Provide a unified interface to a set of interfaces 
 *	in a subsystem. Facade defines a higher-level interface that makes
 *	the subsystem easier to use.
 *	
 *		外观模式是迪米特法则的一种具体实现，通过引入一个新的外观角色可以降低原有系统的复杂度，
 *	同时降低客户类与子系统的耦合度。
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年1月31日
 */

package com.adaivskenan.gof.facade;

/**
 * 外观模式包含如下两个角色：
 * 
 * (1) Facade（外观角色）：在客户端可以调用它的方法，在外观角色中可以知道相关的（一个或者多个）子系统的
 * 功能和责任；在正常情况下，它将所有从客户端发来的请求委派到相应的子系统去，传递给相应的子系统对象处理。
 * 
 * (2) SubSystem（子系统角色）：在软件系统中可以有一个或者多个子系统角色，每一个子系统可以不是一个单独
 * 的类，而是一个类的集合，它实现子系统的功能；每一个子系统都可以被客户端直接调用，或者被外观角色调用，它处理由外观
 * 类传过来的请求；子系统并不知道外观的存在，对于子系统而言，外观角色仅仅是另外一个客户端而已。
 */