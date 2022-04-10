package com.ahong.programming;

import org.junit.Test;

/**
 * 
 * @author zhengruihong
 * 斐波那契数列:从数列的第三项开数，此项等于前两项之和
 * 杨辉三角：第n行有n个数，第n行第i个数等于第n行第i-1个数加上第n行第i+1个数
 * 掌握数组初始化的三种方式
    	        1
		   	  1   1
		   	1   2   1
		  1   3   3   1
		1   4   6   4   1
      1   5  10  10   5   1
    1   6  15  20  15   6   1
 */
public class Fibonacci {
	@Test
	public void test(){
		int a1 = 1;
		int a2 = 2;
		int a3 = 0;
		for(int i = 3;i<=12;i++){
			a3 = a1+a2;
			a1 = a2;
			a2 = a3;
			System.out.println("第"+i+"个月的兔子数量为："+a3);
		}
	}
	@Test
	public void yangHuiSanJiao(){
		//1.数组直接赋值
		int [][]test1 = new int[][]{{1,2},{2,3,4},{1,2}};
		//2.指定大小
		int [][]test2 = new int[4][3];
		//3.指定一维大小后动态赋值
		final int NMAX = 10; 
        int[][] odds = new int[NMAX + 1][];//定义11行，二维未定义
        for (int n = 0; n <= NMAX; n++){
        	odds[n] = new int[n + 1];
        }
        for (int n = 0; n < odds.length; n++){
        	for (int k = 0; k < odds[n].length; k++){
	            int lotteryOdds = 1;
	            for (int i = 1; i <= k; i++){
	               lotteryOdds = lotteryOdds * (n - i + 1) / i;
	            }
	            odds[n][k] = lotteryOdds;
        	}
         }
        for (int[] row : odds){
        	for (int odd : row){
        		System.out.printf("%4d", odd);
        	}
        	System.out.println();
        }
	}
}
