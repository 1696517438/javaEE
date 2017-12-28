package com.test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ex2 {
	public static void main(String [] args){
		String str1="abcdefs";
		String str2="abcdef";
		String str=compare(str1,str2);
		System.out.println(str);
	}
	public static String compare (String str1,String str2){
		char[]arr1=str1.toCharArray();
		char[]arr2=str2.toCharArray();
		if(arr1.length > arr2.length){
			return str1;
		}else if(arr1.length < arr2.length){
			return str2;
		}else{
			int sum=0;
			for (int i = 0; i < arr1.length; i++) {
				sum+=(int)arr1[i];
			}
			int sum1=0;
			for (int i = 0; i < arr2.length; i++) {
				sum1+=(int)arr2[i];
			}
			if(sum>sum1){
				return str1;
			}else if(sum<sum1){
				return str2;
			}else{
				return str1;
			}
		}
	}
}
	/*
	 * 
	 * */

/*
 * int[] a=new int[]{1,2,54,36,78,45,98,45,63,54,21,56,321,66}; 
		int[] b=new int[a.length-1];   
		int c=4; 
		for (int i =c-1;i < a.length-1; i++) {  
			a[i]=a[i+1];  
		}   
		for (int i = 0; i < b.length; i++) { 
			b[i]=a[i]; 
		}   a=b;  
		for (int i = 0; i < b.length; i++) { 
		  System.out.println(a[i]); 
		} 
 * int min_index = 0;// 表示当前轮最小元素的下标
 * // 变量i既可以控制轮数，也表示当前选中的位置
		for (int i = 0; i < arr.length - 1; i++) {
			min_index = i;// 假设当前选中的位置的元素就是最小值

			for (int j = i + 1; j <= arr.length - 1; j++) {
				if (arr[min_index] > arr[j]) {
					min_index = j;
				}
			}

			if (min_index != i) {
				// 交换
				int temp = arr[min_index];
				arr[min_index] = arr[i];
				arr[i] = temp;
			}
		}

		// 增强for循环 foreach 语法糖
		for (int i : arr) {
			System.out.print(i);
		}*/
 