package com.adaivskenan.testelasticsearch;
import java.io.File;
import java.io.IOException;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

public class sss {
	public static void main(String[] args){
		File f = new File("D:/happylife/HappyLife");
		StringBuffer prefix = new StringBuffer("");
		System.out.println(f.getName());
		list(f, prefix);
	}

	public static void list(File path, StringBuffer prefix){
		if(path != null && path.exists() && path.isDirectory()){
			prefix.append("\t");
			File[] childs = path.listFiles();
			if(childs != null && childs.length > 0){
				for(File child : childs){
					if(child.getName().contains(".jar")){
						try  
				        {  
				            JarFile jf = new JarFile(child);  
				            Manifest mf = jf.getManifest();
				            if(mf.getMainAttributes().getValue("Require-Bundle")!=null && mf.getMainAttributes().getValue("Require-Bundle").contains("javax.servlet")){
				            	System.out.println(prefix + "|--" + child.getName() + "******");
				            }
				        }  
				        catch (IOException e)  
				        {  
				            e.printStackTrace();  
				        }  
					}else{
						if(child.isDirectory()){
							System.out.println(prefix + "|--" + child.getName());
						}
					}
					list(child, prefix);
				}
			}
			prefix.deleteCharAt(prefix.length() - 1);
		}
	}
}

}
