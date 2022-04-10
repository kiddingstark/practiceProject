package com.ahong.programming.thread;

import java.util.concurrent.*;

/**
 * @Description 线程池七大参数：核心线程数、最大线程数、队列类型以及队列数、存活时间、存活时间单位、拒绝策略、线程工厂
 * @Author Ricky
 * @Date 2021/11/6 15:20
 */
public class ThreadPool {

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
            executor.execute(new Thread(new ThreadPoolRunnable()));
        }
    }
}
