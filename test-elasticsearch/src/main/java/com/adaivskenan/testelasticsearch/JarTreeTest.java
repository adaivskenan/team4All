package com.adaivskenan.testelasticsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class JarTreeTest {
	public static void main(String[] args){
		Map<String, String> rqMap = new HashMap<String, String>();// key为Bundle,value为被依赖Bundle或者jar
		File file = new File("C:\\Users\\qinjunjie.JIUQI\\AppData\\Local\\Temp\\server.log");
		Reader in = null;
		BufferedReader br = null;
		try{
			in = new FileReader(file);
			br = new BufferedReader(in);
			String lineStr;
			String key;
			String value;
			while((lineStr = br.readLine()) != null){
				if(null != lineStr && !"".equals(lineStr)){
					if(lineStr.contains("org.osgi.framework.BundleException")){
						key =
						        lineStr.substring(
						                lineStr.lastIndexOf("org.osgi.framework.BundleException: The bundle \"") + 48,
						                lineStr.indexOf("_"));
						value = lineStr.substring(lineStr.lastIndexOf(": ") + 2, lineStr.lastIndexOf(";"));
						rqMap.put(key, value);
					}
				}
			}
			Map<String, String> baseMap = new HashMap<String, String>(rqMap);
			for(String v : rqMap.values()){
				if(baseMap.get(v) == null){
					baseMap.put(v, "jiuqi");
				}
			}
			java.util.Iterator<Entry<String, String>> it = baseMap.entrySet().iterator();
			while(it.hasNext()){
				Map.Entry<String, String> entry = it.next();
				putData(entry.getValue(),entry.getKey());
				System.out.println(entry.getKey() + "  |  " + entry.getValue());
			}

			makeTree("jiuqi", 1);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				br.close();
				in.close();
			}
			catch(IOException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static HashMap<String, ArrayList<String>> tmpMap = new HashMap<String, ArrayList<String>>();

	private static void putData(String pid, String id){
		ArrayList<String> childList = tmpMap.get(pid);
		if(childList == null){
			childList = new ArrayList<String>();
			tmpMap.put(pid, childList);
		}
		childList.add(id);
	}

	private static void makeTree(String pid, int level){
		for (int i = 1; i < level; i++)
	         System.out.print("\t|");
		System.out.println(pid);
		ArrayList<String> childList = tmpMap.get(pid);
		if(childList != null){
			for(int i = 0; i < childList.size(); i++){
				makeTree(childList.get(i), level + 1);
			}
		}
	}

}
