package com.ahong.programming.cache;

import org.apache.commons.lang.time.DateUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 本地缓存
 * 1、过期淘汰
 * 2、懒惰淘汰：使用次数/最新使用时间
 * 3、容量有限
 * @Author Ricky
 * @Date 2022/1/23 15:52
 */
public class LocalCache {

    private static ConcurrentHashMap<String, Map<String, Object>> localCache = new ConcurrentHashMap<>();

    private static Timer timer = new Timer();

    private final static Integer CACHE_SIZE = 500;

    //缓存值
    private final static String CACHE_VALUE = "value";

    //缓存过期时间
    private final static String CACHE_EXPIRE = "expire";

    //缓存使用次数
    private final static String CACHE_USED_COUNT = "usedCount";

    //缓存创建时间
    private final static String CACHE_CREATE_TIME = "createTime";

    //缓存最新使用时间
    private final static String CACHE_USED_TIME = "usedTime";

    //默认缓存12小时无使用则进行删除
    private final static Integer CACHE_DELETED_USED_TIME = 720;


    /**
     * 添加缓存
     *
     * @param key
     * @param value
     * @param expire
     * @return
     */
    public static boolean add(String key, Object value, Integer expire) {
        Map<String, Object> cacheMap = new HashMap<>();
        //缓存默认1天过期
        if (null == expire || expire != -1) {
            expire = 1440;
        }
        Date expireTime = DateUtils.addMinutes(new Date(), expire);
        cacheMap.put(CACHE_EXPIRE, expireTime);
        timer.schedule(new LocalCacheTimer(key), expire * 60 * 1000);

        cacheMap.put(CACHE_USED_COUNT, 0);
        cacheMap.put(CACHE_VALUE, value);
        cacheMap.put(CACHE_CREATE_TIME, new Date());

        //相当于redis内存淘汰策略中的allkeys-lru
        if (localCache.size() >= CACHE_SIZE) {
            //使用次数小于10次且12小时内无使用的缓存则直接删除
            deleteByUsed(10);
        }
        if (localCache.size() >= CACHE_SIZE) {
            throw new RuntimeException("本地缓存容量已满，请手动删除缓存后再设置缓存！");
        }

        localCache.put(key, cacheMap);

        return true;
    }

    public static boolean delete(String key) {
        localCache.remove(key);
        return true;
    }

    /**
     * 获取缓存
     *
     * @param key
     * @return
     */
    public static Map<String, Object> get(String key) {
        Map<String, Object> cahceMap = localCache.get(key);
        Integer usedCount = Integer.valueOf(cahceMap.get(CACHE_USED_COUNT).toString());
        usedCount++;
        cahceMap.put(CACHE_USED_COUNT, usedCount);
        cahceMap.put(CACHE_USED_TIME, new Date());
        localCache.put(key, cahceMap);
        return cahceMap;
    }

    /**
     * 根据最新使用时间、使用次数删除该缓存
     *
     * @return
     */
    public static boolean deleteByUsed(Integer deletedUsedCount) {
        for (String key : localCache.keySet()) {
            Map<String, Object> cacheMap = localCache.get(key);
            Date nowTime = new Date();
            Date usedTime = (Date) cacheMap.get(CACHE_USED_TIME);
            Integer usedCount = Integer.valueOf(cacheMap.get(CACHE_USED_COUNT).toString());
            //超过12小时无使用、且使用次数过少则进行删除
            if (usedCount <= deletedUsedCount && (nowTime.getTime() - usedTime.getTime()) / 1440 >= CACHE_DELETED_USED_TIME) {
                localCache.remove(key);
            }
        }
        return true;
    }

}
