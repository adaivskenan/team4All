package com.adaivskenan.utils.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;


/**
 * 集合类辅助工具<br>
 * 其中new前缀的系列方法为利用编译器类型推导创建各种集合对象<br>
 * 
 *
 */
public final class CollectionUtils {

	/**
	 * 私有构造函数防止创建实例
	 */
	private CollectionUtils() {
	}
	
	/**
	 * 创建空ArrayList
	 * 
	 * @param <E>
	 * @return
	 */
	public static <E> ArrayList<E> newArrayList() {
		return new ArrayList<E>();
	}
	
	/**
	 * 用参数中的元素创建ArrayList
	 * 
	 * @param <E>
	 * @param items
	 * @return
	 */
	@SafeVarargs
	public static <E> ArrayList<E> newArrayList(E... items) {
		ArrayList<E> result = newArrayList();
		if (items != null)
			for (E item : items)
				result.add(item);
		return result;
	}
	
	/**
	 * 创建空HashMap
	 * 
	 * @param <K>
	 * @param <V>
	 * @return
	 */
	public static <K, V> HashMap<K, V> newHashMap() {
		return new HashMap<K, V>();
	}
	
	/**
	 * 创建空Hashtable
	 * 
	 * @param <K>
	 * @param <V>
	 * @return
	 */
	public static <K, V> Hashtable<K, V> newHashTable() {
		return new Hashtable<K, V>();
	}
	
	/**
	 * 创建空HashSet
	 * 
	 * @param <E>
	 * @return
	 */
	public static <E> HashSet<E> newHashSet() {
		return new HashSet<E>();
	}
	
	/**
	 * 创建空LinkedList
	 * 
	 * @param <E>
	 * @return
	 */
	public static <E> LinkedList<E> newLinkedList() {
		return new LinkedList<E>();
	}
	
	/**
	 * 创建空LinkedHashMap
	 * 
	 * @param <K>
	 * @param <V>
	 * @return
	 */
	public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
		return new LinkedHashMap<K, V>();
	}
	
	/**
	 * 创建空LinkedHashSet
	 * 
	 * @param <E>
	 * @return
	 */
	public static <E> LinkedHashSet<E> newLinkedHashSet() {
		return new LinkedHashSet<E>();
	}
    
    /**
     * 求差集
     * 
     * @param <T>
     * @param c1
     * @param c2
     * @return c1中存在而c2中不存在的元素集合
     */
    public static <T> Collection<T> diff(Collection<T> c1, Collection<T> c2) {
        if (c1 == null || c1.size() == 0 || c2 == null || c2.size() == 0)
            return c1;
        
        Collection<T> difference = newArrayList();
        for (T item : c1)
            if (!c2.contains(item))
                difference.add(item);
        return difference;
    }
    
    /**
     * 判断集合是否为空，有3种情况：1.集合对象本身是null；2.集合长度为0；3.集合中所有元素都是null
     * 
     * @param <T>
     * @param c
     * @return
     */
    public static <T> boolean isEmpty(Collection<T> c) {
        if (c == null || c.size() == 0)
            return true;

        for (T item : c)
            if (item != null)
                return false;
        return true;
    }
    
    /**
     * 判断数组是否为空，有3种情况：1.参数本身是null；2.数组长度为0；3.数组中所有元素都是null
     * 
     * @param <T>
     * @param c
     * @return
     */
    public static <T> boolean isEmpty(T[] c) {
        if (c == null || c.length == 0)
            return true;
        return isEmpty(Arrays.asList(c));
    }
	
	/**
	 * 获取List中指定位置的值，下标越界时返回null
	 * 
	 * @param list
	 * @param index
	 * @return
	 */
	public static <T> T getItem(final List<T> list, int index) {
		return index < 0 || index >= list.size() ? null : list.get(index);
	}
	
	/**
	 * 获取List中指定位置的值，下标越界时返回defaultValue
	 * 
	 * @param list
	 * @param index
	 * @param defaultValue
	 * @return
	 */
	public static <T> T getItem(final List<T> list, int index, T defaultValue) {
		T result = getItem(list, index);
		return result == null ? defaultValue : result;
	}
	
	/**
	 * 获取数组中指定位置的值，下标越界时返回null
	 * 
	 * @param array
	 * @param index
	 * @return
	 */
	public static <T> T getItem(final T[] array, int index) {
		return index < 0 || index >= array.length ? null : array[index];
	}
	
	/**
	 * 获取数组中指定位置的值，下标越界时返回defaultValue
	 * 
	 * @param array
	 * @param index
	 * @param defaultValue
	 * @return
	 */
	public static <T> T getItem(final T[] array, int index, T defaultValue) {
		T result = getItem(array, index);
		return result == null ? defaultValue : result;
	}

	/**
	 * 集合中是否包含指定元素
	 * 
	 * @param <T>
	 * @param list
	 * @param item
	 * @return
	 */
	public static <T> boolean contains(T[] list, T item) {
//		Assert.isNotNull(item);
//		Assert.isNotNull(list);
		return indexOf(list, item) != -1;
	}
	
	/**
	 * 获取元素在集合中的顺序号，无匹配元素时返回-1
	 * 
	 * @param list
	 * @param item
	 * @return
	 */
	public static <T> int indexOf(T[] list, T item) {
//		Assert.isNotNull(item);
//		Assert.isNotNull(list);
		for (int i = 0; i < list.length; i++)
			if (list[i] == item)
				return i;
		return -1;
	}

	
	
	/**
	 * List转为逗号分隔的字符串
	 * 
	 * @param list
	 * @return
	 */
	public static <T> String toString(List<T> list) {
		return toString(list, ",");
	}
	
	/**
	 * List转为字符串
	 * 
	 * @param list
	 * @param splitter
	 * @return
	 */
	public static <T> String toString(List<T> list, String splitter) {
		StringBuilder sb = new StringBuilder();
		for (T item : list) {
			if (item != null)
				sb.append(item.toString());
			if (splitter != null)
				sb.append(splitter);
		}
		if (splitter != null)
			sb.delete(sb.length() - splitter.length(), sb.length());
		return sb.toString();
	}
	
	/**
	 * 数组转为逗号分隔的字符串
	 * 
	 * @param array
	 * @return
	 */
	public static <T> String toString(T[] array) {
		return toString(array, ",");
	}
	
	/**
	 * 数组转为字符串
	 * 
	 * @param array
	 * @param splitter
	 * @return
	 */
	public static <T> String toString(T[] array, String splitter) {
		return toString(newArrayList(array), splitter);
	}

}
