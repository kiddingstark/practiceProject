package com.ahong.programming.cache;

import java.util.TimerTask;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2022/1/23 16:50
 */
public class LocalCacheTimer extends TimerTask {

    private String key;

    public LocalCacheTimer(String key){
        this.key = key;
    }

    @Override
    public void run() {
        LocalCache.delete(key);
    }
}
