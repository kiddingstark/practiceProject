package com.ahong.designModel.singleton;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2021/10/7 2:32
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;

    private LazySingleton() {

    }

    public static LazySingleton generateObject() {
        if (null == lazySingleton) {
            synchronized (LazySingleton.class){
                if(null == lazySingleton) {
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
