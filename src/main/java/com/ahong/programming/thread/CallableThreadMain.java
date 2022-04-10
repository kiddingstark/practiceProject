package com.ahong.programming.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2022/2/27 15:59
 */

@Slf4j
public class CallableThreadMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //ExecutorService executor = Executors.newFixedThreadPool(3);
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("judge-pool-%d")
                .setUncaughtExceptionHandler((thread, throwable) ->
                        log.info("ThreadPool {} got exception", thread, throwable))
                .build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2),namedThreadFactory);
        ArrayList<Future<String>> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            executor.submit(new AThread());
            //executor.submit(new CallableThread(i));
        }
//
//        for (Future<String> future : result) {
//            System.out.println("若future中还未获得结果，则下面的get方法会堵塞住");
//            System.out.println(future.get());
//        }
    }
}
