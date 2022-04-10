package com.ahong.programming;

import org.junit.Test;


/**
 * 
 * @author zhengruihong
 * 2/1，3/2，5/3，8/5，13/8，21/13...求出 这个数列的前20项之和。
 * 解决思路：斐波那契
 */
public class Total {
	@Test
	public void test(){
		double x = 2,y = 1,sum = 0;
		for(int i=2;i<=20;i++){
			double middle;
			sum = sum+x/y;
			middle = y;
			y = x;
			x = x+middle;
		}
    	System.out.println("数列的前20项之和:"+sum);
	}
}
