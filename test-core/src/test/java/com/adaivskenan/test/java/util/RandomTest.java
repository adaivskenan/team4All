/**
 * 
 */
package com.adaivskenan.test.java.util;

import java.util.Random;

/**
 * @author adaivskenan
 *
 */
public class RandomTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//默认方法的seed和系统的时间有关
		Random random = new Random();
		System.out.println(random.nextInt());
		System.out.println(random.nextInt(1000));
		
		//加入seed后生成的将是稳定结果
		Random seedRandom = new Random(520);
		System.out.println(seedRandom.nextInt());
		System.out.println(seedRandom.nextInt(1000));

	}

}
