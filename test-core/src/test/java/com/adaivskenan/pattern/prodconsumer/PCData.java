/**
 * 
 */
package com.adaivskenan.pattern.prodconsumer;

/**
 * @author adaivskenan
 *
 */
public final class PCData {
	
	private final int intData;

	public PCData(int d) {
		intData = d;
	}

	public int getIntData() {
		return intData;
	}

	@Override
	public String toString() {
		return "PCData [intData=" + intData + "]";
	}
	
}
