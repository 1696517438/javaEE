package com.test;

import java.io.File;

public class Test1 {
	private static int level = 0;// 表示目录层级

	public static void main(String[] args) {
		
		printDir(new File("d:\\江浩"));
	}

	/**
	 * 递归显示指定目录
	 * @param dir	指定目录
	 */
	public static void printDir(File dir){
		// 入参检查
		if(dir == null){
			return ;
		}
		
		// 如果是文件或者空目录，直接输出文件名
		if(dir.isFile() || dir.list().length == 0){
			System.out.println(dir.getName());
			return;
		}
		
		// 如果是有内容的目录，则递归遍历
		File[] fs = dir.listFiles();
		for (File f : fs) {
			if(f.isFile()){
				// 打印空格
				System.out.print(getTab(level));
				// 打印文件名
				System.out.println(f.getName());
			}else{
				// 打印空格
				System.out.print(getTab(level));
				// 打印目录名+\
				System.out.println(f.getName()+"\\");
				// 递归
				level ++;// 目录层级 +1
				printDir(f);
				level --;
			}
		}
		
	}
	
	// 输出目录之前的空白
	private static String getTab(int level){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < level; i++) {
			sb.append('\t');
		}
		return sb.toString();
	}
}

