package com.ahong.programming.thread;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2020/11/12 14:47
 */
public class AThread implements Runnable {
    @Override
    public void run() {
        //用同一个对象去调用synchronized对象维度则无线程安全问题
        //ThreadModel threadModel = new ThreadModel();
        for (int i = 0; i < 20; i++) {
            //由于每次都new一个对象，所以线程不安全
            //ThreadModel threadModel = new ThreadModel();
            //System.out.println(Thread.currentThread().getName() + ":" + threadModel.incrementNumberByObject());
            if (true) {
                throw new RuntimeException("测试异常");
            }
            //该方法是synchronized类维度
            System.out.println(Thread.currentThread().getName() + ":" + ThreadModel.incrementNumber());

        }
    }
}
