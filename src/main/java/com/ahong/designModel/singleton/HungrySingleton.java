package com.ahong.designModel.singleton;

/**
 * @Description TODO
 * @Author Ricky
 * @Date 2021/10/7 2:34
 */
public class HungrySingleton {

    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){

    }

    public static HungrySingleton generateObject(){
        return hungrySingleton;
    }
}
