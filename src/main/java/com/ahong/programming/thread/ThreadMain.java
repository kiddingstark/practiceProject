package com.ahong.programming.thread;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2020/11/12 14:47
 */
public class ThreadMain {
    public static void main(String[] args) {

        /**
         * 线程异步高并发
         */
        AThread thread1  = new AThread();
        AThread thread2 = new AThread();
        System.out.println("thread1开始执行！");
        new Thread(thread1,"thread1").start();
        System.out.println("thread1结束执行！");

        //System.out.println("通过打印表示两个线程之间是异步情况，不需要等到thread1线程执行完毕，Thread2才开始执行");

        System.out.println("thread2开始执行！");
        new Thread(thread2,"thread2").start();
        System.out.println("thread2结束执行！");

        /**
         * 死锁测试
         *
         */
//        DeadThread deadThread1  = new DeadThread();
//        deadThread1.setFlag(1);
//        DeadThread deadThread2 = new DeadThread();
//        deadThread2.setFlag(2);
//        new Thread(deadThread1,"deadThread1").start();
//        new Thread(deadThread2,"deadThread2").start();

    }
}
