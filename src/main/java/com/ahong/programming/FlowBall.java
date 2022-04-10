package com.ahong.programming;

import org.junit.Test;

/**
 * 小球从100米的高空落地，每次落地反弹高度都为一半。
 * @author zhengruihong
 *
 */
public class FlowBall {
	@Test
	public void test(){
		double allHeight = 100;
		double height = 50;//第一次弹起的高度；
		for(int i = 2;i<=10;i++){//从第二次开始循环，每次的总路程：allHeight+弹起距离的两倍
			allHeight = allHeight+height*2;
			height = height/2;
			System.out.println("小球第"+i+"次落地经过的总路程为："+allHeight);
			System.out.println("小球第"+i+"次落地弹起的距离为："+height);
		}
	}
}
