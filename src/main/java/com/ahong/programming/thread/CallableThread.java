package com.ahong.programming.thread;

import java.util.concurrent.Callable;

/**
 * @Description Callable相对于Runnable来说有返回值且能抛出异常，返回值用Future接受
 * @Author Ricky
 * @Date 2022/2/27 15:58
 */
public class CallableThread implements Callable<String> {

    private Integer id;

    public CallableThread(Integer id) {
        this.id = id;
    }


    @Override
    public String call() throws Exception {
        //Thread.sleep(10000);
        if (true) {
            throw new RuntimeException("异常测试");
        }
        return Thread.currentThread().getName() + "id为：" + id;
    }
}
