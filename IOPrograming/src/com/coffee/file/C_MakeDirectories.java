package com.coffee.file;

import java.io.File;
/**
 * File 类并不仅仅是对现有目录路径、文件或者文件组的一个表示。亦可用一个File对象新建一个目录，
 * 甚至创建一个完整的目录路径--加入它尚不存在的话，亦可用它了解文件的属性(长度、
 * 上一次修改日期、读/写属性等)，检查一个File对象到底代表一个文件还是一个目录，以及删除一个文件等等。
 * @author Administrator
 *
 */
public class C_MakeDirectories {
	private final static String usage = "Usage:MakeDirectories path1 ... \n" + 
			"Creates each path\n" +
			"Usage:MakeDirectores -d path1 ...\n" +
			"Deletes each path\n" +
			"Usage:MakeDirectories -r path1 path2\n" +
			"Renames from path1 path2\n" +
			"Renames from path1 to path2\n";
	private static void usage() {
		System.err.print(usage);
		System.exit(1);
	}
	private static void fileData(File f) {
		System.out.print(
				"Absolute path:"+f.getAbsolutePath()+//绝对路径
				"\n Can read:"+f.canRead()+//是否可读
				"\n Can write:"+f.canWrite()+//是否可写
				"\n getName:"+f.getName()+//文件名
				"\n getParent:" + f.getParent()+//父路径
				"\n getPath:" + f.getPath() +"\n length:"+f.length()+//文件长度
				"\n lastModified:" + f.lastModified()//上次修改的毫秒值
				);
		if(f.isFile())
			System.out.print("it'is a file");
		else if(f.isDirectory())
			System.out.println("it's a directory");
	}
	public static void main(String[] args) {
		if(args.length < 1) usage();
		if(args[0].equals("-r")) {
			if(args.length != 3) usage();
			File old = new File(args[1]),
					rname = new File(args[2]);
			old.renameTo(rname);//修改文件名
			fileData(old);
			fileData(rname);
			return;//Exit main
		}
		int count = 0;
		boolean del = false;
		if(args[0].equals("-d")) {
			count++;
			del =true;
		}
		for(;count<args.length;count++) {
			File f = new File(args[count]);
			if(f.exists()) {
				System.out.println(f + "exists");
			if(del) {
				System.out.println("deleting..." + f);
				f.delete();
			}
		}else {
			if(!del) {
				f.mkdirs();
				System.out.println("created " + f);
			}
		}	
			fileData(f);
		}
		
	}
}
