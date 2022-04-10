package com.ahong.currentLimiting;

/**
 * @Description 计数器限流：缺点是请求不可控，会导致不均匀的情况，如300个线程在1秒内就全部请求完毕，后面9s都拒绝了请求
 * @Author Ricky
 * @Date 2021/10/2 1:19
 */
public class CountLimiting {

    private int threadNumber  = 0;//定时将变量归零，如在10S内只能有300个线程调用，则每10s归零
    private int totalNumber = 300;

    public void testController(){
        if(threadNumber >= totalNumber){
            return;
        }
        threadNumber++;
        // 调用service

    }
}
