package com.ahong.currentLimiting;

/**
 * @Description 令牌桶算法：拿到令牌再放行，与计数器实现方式相反，与漏桶相比能够自己定义应用的阈值（通过令牌）
 * @Author Ricky
 * @Date 2021/10/2 3:11
 */
public class TokenBucketLimiting {

    private int tokenNumber  = 0;//定义一个策略生成令牌

    public void testController(){
        if(tokenNumber < 0){
            return;
        }
        tokenNumber--;
        // 调用service

    }
}
