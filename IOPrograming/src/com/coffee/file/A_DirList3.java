package com.coffee.file;

import java.io.File;
import java.io.FilenameFilter;
/**
 * 遍历目录文件列表和筛选包含指定名称的文件
 * 进一步的匿名内部类的方式
 * @author Administrator
 *
 */
public class A_DirList3 {
	public static void mani(String[] args) {
		final String filterName = "";
		try {
			File path = new File(".");
			String[] list;
			if(filterName == null || "".equals(filterName)) 
				list = path.list();
			else
				list = path.list(new FilenameFilter() {
					String fn = filterName;
					@Override
					public boolean accept(File dir, String name) {
						String f = new File(name).getName();
						return f.indexOf(fn) != -1;
					}
				});
			for(int i=0;i<list.length;i++) 
				System.out.println(list[i]);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
