package com.ahong.programming.thread;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2021/9/15 15:17
 */
public class DeadThread implements Runnable {
    private int flag;
    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始运行！flag:" + flag);
        if (1 == flag) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + "运行成功！");
                }
            }
        }
        if (2 == flag) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + "运行成功！");
                }
            }
        }
    }
}
