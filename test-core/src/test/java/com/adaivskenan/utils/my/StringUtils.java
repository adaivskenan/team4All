/**
 * 
 */
package com.adaivskenan.utils.my;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author adaivskenan
 *
 */
public class StringUtils {

	/**
	 * Splits stringToSplit into a list, using the given delimiter
	 * 
	 * @param stringToSplit
	 *            the string to split
	 * @param delimiter
	 *            the string to split on
	 * @param trim
	 *            should the split strings be whitespace trimmed?
	 * 
	 * @return the list of strings, split by delimiter
	 * 
	 * @throws IllegalArgumentException
	 */
	public static List<String> split(String stringToSplit, String delimiter, boolean trim) {
		if (stringToSplit == null) {
			return new ArrayList<String>();
		}

		if (delimiter == null) {
			throw new IllegalArgumentException();
		}

		StringTokenizer tokenizer = new StringTokenizer(stringToSplit, delimiter, false);

		List<String> splitTokens = new ArrayList<String>(tokenizer.countTokens());

		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();

			if (trim) {
				token = token.trim();
			}

			splitTokens.add(token);
		}

		return splitTokens;
	}
	
}
