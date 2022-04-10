package com.ahong.currentLimiting;

/**
 * @Description 漏桶限流算法：剞劂计数器限流不均衡的问题
 * @Author Ricky
 * @Date 2021/10/2 2:21
 */
public class BucketLimiting {

    private int waterLevel = 0;

    private int totalLevel = 200;

    private int threadNumber = 0;

    private int totalNumber = 10;

    private void testController() throws InterruptedException {

        //1、未达到限流速率时直接放行
        if (threadNumber <= totalNumber) {
            threadNumber++;
            //调用service()
        } else {
            //2、达到限流速率是看水位是否已满，已满则return
            if (waterLevel > totalLevel) {
                return;
            }
            //3、达到限流速率是看水位是否已满，未满则放入桶中，并等待限流速率归零
            waterLevel++;
            while (threadNumber > totalNumber) {
                Thread.sleep(500);
            }
            //归零后则调用，水位-1
            waterLevel--;
            threadNumber++;
            //调用service()
        }
    }

}
