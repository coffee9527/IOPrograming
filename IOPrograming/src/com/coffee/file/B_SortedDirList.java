package com.coffee.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 对指定路径下的文件排序遍历
 * @author Administrator
 *
 */
public class B_SortedDirList {
	private File path;
	private String[] list;
	public B_SortedDirList(final String afn) {
		path = new File(".");
		if(afn == null)
			list = path.list();
		else
			list = path.list(new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
					String f = new File(name).getName();
					return f.indexOf(afn) != -1;
				}
			});
		sort();
	}
	void print () {
		for(int i=0;i<list.length;i++)
			System.out.println(list[i]);
	}
	private void sort() {
		B_StrSortVector sv = new B_StrSortVector();
		for(int i=0;i<list.length;i++) 
			sv.addElement(list[i]);
			//The first time an element is pulled from
			//the StrSortVector the list is sorted;
		for(int i=0;i<list.length;i++)
			list[i] = sv.elementAt(i);
		
	}
	
	//Test it;
	public static void main(String[] args) {
		B_SortedDirList sd;
		if(args.length == 0)
			sd = new B_SortedDirList(null);
		else 
			sd = new B_SortedDirList(args[0]);
		sd.print();
	}
}
