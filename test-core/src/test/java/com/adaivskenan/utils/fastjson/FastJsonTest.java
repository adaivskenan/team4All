/**============================================================
 * 版权： 久其软件 版权所有 (c) 2002 - 2016
 * 包： com.adaivskenan.utils.fastjson
 * 修改记录：
 * 日期                作者           内容
 * =============================================================
 * 2018年2月2日       qinjunjie        
 * ============================================================*/

package com.adaivskenan.utils.fastjson;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * <p>FastJson测试类</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2016<br>
 * Company: 久其</p>
 *
 * @author qinjunjie
 * @version 2018年2月2日
 */

public class FastJsonTest {

	public static void main(String[] args) {
		Person p = new Person(1, "a", "man");
		Person p1 = new Person(2, "b", "woman");
		String pStr = JSON.toJSONString(p);
		List<Person> ps = new ArrayList<Person>();
		ps.add(p);
		ps.add(p1);
		String psStr = JSON.toJSONString(ps);
		System.out.println(pStr);
		System.out.println(psStr);
		List<Person> aaa =  JSON.parseObject(psStr, new TypeReference<List<Person>>(){});
		System.out.println(aaa);
	}

}
