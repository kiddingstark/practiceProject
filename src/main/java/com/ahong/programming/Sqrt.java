package com.ahong.programming;

import java.util.Random;

/**
 * 
 * @author zhengruihong
 * 一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，求该数
 * 要点：1.掌握Math API 2.掌握判断整数的方法 %1 = 0
 */
public class Sqrt {
	public static void main(String[] args){
		Random r = new  Random();
		for(int i = 1;;i++){
			System.out.println(r.nextInt(10)+","+Math.random());
			if((Math.sqrt(i+100))%1==0 && (Math.sqrt(i+168))%1==0){
				System.out.println("此数为："+i);
				break;
			}
		}
	}
}
