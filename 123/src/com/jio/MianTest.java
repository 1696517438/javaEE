package com.jio;

import java.util.Calendar;

public class MianTest {
	public static void main(String[] args) {
		int total = total(10);
		System.out.println(total);
	}
	 public static int total(int day)  
	    {  
	        if (day == 10)  
	        {  
	            return 1;  
	        }  
	        else  
	        {  
	            return (total(day + 1) + 1) * 2;  
	        }  
	    }  
}
