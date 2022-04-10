package com.ahong.programming.thread;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2020/11/12 14:48
 */
public class ThreadModel {

    //将int类型转为AtomicInteger,则该变量的读与写是原子性操作，就不用加synchronized
    //public static AtomicInteger number = new AtomicInteger(0);
    public static volatile int number = 0;

    /**
     * 不加synchronized会出现多线程问题
     * 1时刻：A线程读取number为1，更改为2，后堵塞
     * 2时刻：B线程读取number为1，更改为2，写回内存
     * 3时刻：A线程将2写回内存。结果本应该为3
     * @returns
     */
    public synchronized static int incrementNumber(){
        return ++number;
    }

    public synchronized int incrementNumberByObject(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ++number;
    }
}
