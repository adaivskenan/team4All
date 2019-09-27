package com.adaivskenan.lambda;

import java.util.HashMap;
import java.util.Map;

public class LambdaTest {
	public static void main(String[] args) {
		Map<String, Object> paramCopy = new HashMap<>();
		Map<String, Object> param = new HashMap<>();
		param.put("A", "a");
		param.put("B", "");
		param.put("C", null);
		param.put("sign", "sign");
		paramCopy.putAll(param);
		paramCopy.remove("sign");
		String reuslt = paramCopy.entrySet().stream().filter(e -> compare(e)).collect(StringBuffer::new, (a, b) -> {
					System.err.println(a);
					System.err.println(b);
			a.append("&" + b);
		}, StringBuffer::append).append("&timestamp=" + System.currentTimeMillis()).toString().toUpperCase();
//		System.out.println(reuslt);
	}

	private static boolean compare(Object o) {
		System.out.println(o.toString());
		return true;
	}
}
