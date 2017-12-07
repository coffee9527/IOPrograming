package com.coffee.file;

import java.io.File;
import java.io.FilenameFilter;
/**
 * 遍历目录文件列表和筛选包含指定名称的文件
 * 一般方式
 * @author Administrator
 *
 */
public class A_DirList {
	public static void main(String[] args) {
		try {
			File path = new File(".");
			String[] list;
			if(args.length == 0)
				list = path.list();
			else
				list = path.list(new DirFilter(args[0]));
			for(int i=0; i<list.length;i++)
				System.out.println(list[i]);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/**
 * 使用到了策略模式，把具体要实现的算法提取到接口中
 * @author Administrator
 *
 */
class DirFilter implements FilenameFilter {
	String afn;
	DirFilter(String afn) {
		this.afn = afn;
	}
	
	/**
	 * 判断
	 */
	@Override
	public boolean accept(File dir, String name) {
		//Strip path infomation
		String f = new File(name).getName();
		return f.indexOf(afn) != -1;
	}
	
}
