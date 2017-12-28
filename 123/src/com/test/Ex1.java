package com.test;

import java.util.Scanner;

public class Ex1 {
	public static void main(String[] args) {
		
		
		
		System.out.println("请输入两个正整数");
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入第一个正整数:");
		int number=sc.nextInt();
		System.out.println("请输入第二个正整数:");
		int number1=sc.nextInt();
		
		if(number>number1){
			for(int i=number; i>=1; i--){
				if(number%i==0 &&number1%i==0){
				
						System.out.println("最大公约数是"+i);
						break;
				}
			}
		}else if(number1>number){
			for(int i=number1; i>=1; i--){
				if(number1%i==0 && number%i==0){
						System.out.println("最大公约数是"+i);
						break;
				}
			}
		}
		else if(number1==number){
			System.out.println("最大公约数是"+number);
		
		}
			else{
			System.out.println("最大公约数是"+"1");
		
		}
		
		System.out.println("");
		System.out.println("求最小公因数!!!!!!!!");
		for(int a=1;a<=number*number1;a++){
			if(a % number == 0 && a % number1 == 0){
				System.out.println("求最小公因数"+a);
				break;
				}
			}
		}
	}
//		for(int i=1;i<=9;i++){
//			for(int j=1;j<=i;j++){
//				System.out.print("0");
//			}
//			System.out.println("");
//		}
//		for(int a=1;a<=9;a++){
//			for(int b=1;b<=10-a;b++){
//				System.out.print("*");
//			}
//			System.out.println("");
//		}
//		int  sum=0;
//		int j=1,i;
//		while(j<8){
//		i=j;
//		j++;
//		int num=1;
//		while (i >0) {
//		num*=i;
//		i--;
//		}
//		sum=sum+num;
//		}
//		System.out.println(sum);
//		int  sum=0;
//		for (int j = 1;  j< 8; j++) {
//		int num=1;
//		for (int i = j; i >0; i--) {
//			num*=i;
//		}
//		sum=sum+num;
//		}
//		System.out.println(sum);
	
