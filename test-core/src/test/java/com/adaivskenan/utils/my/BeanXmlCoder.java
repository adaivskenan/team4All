package com.adaivskenan.utils.my;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/**
 * 普通JavaBean的XML序列化辅助类
 * 
 * 
 * 普通JavaBean的要求：
 * 1. 必须有一个无参数的默认构造函数
 * 2. 所有需要序列化的属性都有getter/setter方法
 * 3. 所有需要序列化的属性及其属性都符合前两条规则
 * 
 * 注意：由此工具类序列化的JavaBean不能随意更改包名、类名、getter/setter方法名，
 * 		  可以增加新属性及其getter/setter方法，但不能删除原有的getter/setter方法名，
 * 		  因此只能用于内部对象序列化，不适合用作对外接口上对象的序列化
 */
public class BeanXmlCoder {
	
	private static final String encoding = "UTF-8";

	/**
	 * 对象序列化为XML字符串
	 * 
	 * @param bean
	 * @return
	 */
	public static String beanToXmlStr(Object bean) {
		byte[] result = beanToXmlByte(bean);
		try {
			return result == null ? null : new String(result, encoding);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * 对象序列化为XML字节流
	 * 
	 * @param bean
	 * @return
	 */
	public static byte[] beanToXmlByte(Object bean) {
		ByteArrayOutputStream outputStream1 = new ByteArrayOutputStream();
		XMLEncoder encoder = new XMLEncoder(outputStream1);
		encoder.writeObject(bean);
		encoder.close();
		ByteArrayOutputStream outputStream = outputStream1;
		return outputStream.toByteArray();
	}

	/**
	 * XML字符串反序列化为对象
	 * 
	 * @param xml
	 * @return
	 */
	public static Object xmlStrToBean(String xml) {
		try {
			byte[] bytes = xml.getBytes(encoding);
			return xmlByteToBean(bytes);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * XML字节流反序列化为对象
	 * 
	 * @param xml
	 * @return
	 */
	public static Object xmlByteToBean(byte[] xml) {
		ByteArrayInputStream inputStream = new ByteArrayInputStream(xml);
		XMLDecoder decoder = new XMLDecoder(inputStream);
		Object result = decoder.readObject();
		decoder.close();
		return result;
	}
	
	/**
	 * XML字符串反序列化为特定类型的对象
	 * 
	 * @param <T>
	 * @param xml
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xmlStrToBean(String xml, Class<T> cls) {
		return (T) xmlStrToBean(xml);
	}
	
	/**
	 * XML字节流反序列化为特定类型的对象
	 * 
	 * @param <T>
	 * @param xml
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xmlByteToBean(byte[] xml, Class<T> cls) {
		return (T) xmlByteToBean(xml);
	}
}
