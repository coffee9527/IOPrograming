package com.coffee.file;

import java.io.File;
import java.io.FilenameFilter;
/**
 * 遍历目录文件列表和筛选包含指定名称的文件
 * 匿名内部类的方式
 * @author Administrator
 *
 */
public class A_DirList2 {
	public static FilenameFilter filter(final String afn) {
		//Creation of anonymous inner class;
		return new FilenameFilter() {
			String fn = afn;
			public boolean accept(File dir, String n) {
				//Strip path information ;
				String f = new File(n).getName();
				return f.indexOf(fn) != -1;
			}
		};//End of anonymous inner class
	}
	
	public static void mani(String[] args) {
		String filterName = "";
		try {
			File path = new File(".");
			String[] list;
			if(filterName == null || "".equals(filterName)) 
				list = path.list();
			else
				list = path.list(filter(filterName));
			for(int i=0;i<list.length;i++) 
				System.out.println(list[i]);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
