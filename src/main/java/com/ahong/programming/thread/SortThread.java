package com.ahong.programming.thread;

import java.util.concurrent.Semaphore;

/**
 * @Description 通过信号量控制线程顺序执行
 * @Author Ricky
 * @Date 2022/1/11 14:44
 */
public class SortThread {

    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(0);
        Semaphore semaphore2 = new Semaphore(0);

        final Thread thread1 = new Thread(()->{
            semaphore1.release();
            System.out.println("线程1执行");
        });

        final Thread thread2 = new Thread(()->{
            try {
                //acquire方法会堵直到信号量可用
                semaphore1.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2执行");
            semaphore2.release();
        });

        final Thread thread3 = new Thread(()->{
            try {
                semaphore2.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程3执行");
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
