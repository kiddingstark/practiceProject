package com.ahong.programming.thread;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2021/11/6 15:44
 */
public class ThreadPoolRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在运行！");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
